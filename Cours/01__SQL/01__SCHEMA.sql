-- Chaque produit peut être acheté par plusieurs clients
-- Chaque client peut acheter plusieurs produits, et plusieurs fois le même produit
-- Chaque produit va avoir un seul fournisseur
-- Chaque fournisseur peut fournir plusieurs produits
-- Chaque client (qui a acheté) peut commenter un produit, autant de fois qu'il veut

-- Création de la base de données
CREATE DATABASE eshop COLLATE utf8_general_ci;

-- Utilisation de la base de données
USE eshop;

-- Création de la table personne
CREATE TABLE personne (
    PER_ID INT AUTO_INCREMENT NOT NULL,
    PER_NOM VARCHAR(50) NOT NULL,
    PER_PRENOM VARCHAR(50) NOT NULL,
    PER_MAIL VARCHAR(150) NOT NULL,
    PER_TELEPHONE VARCHAR(20) NOT NULL,
    PER_ADRESSE VARCHAR(150) NOT NULL,
    PER_PASSWORD VARCHAR(300),
    PER_DATE_NAISSANCE DATE,
    PER_SIRET VARCHAR(14),
    PER_TYPE ENUM('C', 'F') NOT NULL DEFAULT 'C',
    PRIMARY KEY (PER_ID)
) ENGINE = InnoDb;


-- Création de la table categorie
CREATE TABLE categorie (
    CAT_ID INT NOT NULL AUTO_INCREMENT,
    CAT_LIBELLE VARCHAR(50) NOT NULL,
    CAT_PARENT_ID INT, -- future clé étrangère qui sera référencée sur categorie (CAT_ID)
    PRIMARY KEY (CAT_ID)
) ENGINE = InnoDb;


-- Création de la table produit
CREATE TABLE produit (
    PRO_ID INT NOT NULL AUTO_INCREMENT,
    PRO_LIBELLE VARCHAR(50) NOT NULL,
    PRO_PRIX DECIMAL(10, 2) NOT NULL DEFAULT 0,
    PRO_STOCK INT NOT NULL DEFAULT 0,
    PRO_PHOTO VARCHAR(250),
    PRO_NOTE DECIMAL(4, 2),
    PRO_FOURNISSEUR_ID INT, -- future clé étrangère qui sera référencée sur personne (PER_ID)
    PRIMARY KEY (PRO_ID)
) ENGINE = InnoDb;


-- Création de la table produit_categorie
CREATE TABLE produit_categorie (
    PRCA_CATEGORIE_ID INT NOT NULL, -- future clé étrangère qui sera référencée sur categorie (CAT_ID)
    PRCA_PRODUIT_ID INT NOT NULL, -- future clé étrangère qui sera référencée sur produit (PRO_ID)
    PRIMARY KEY (PRCA_CATEGORIE_ID, PRCA_PRODUIT_ID)
) ENGINE = InnoDb;


-- Création de la table paiement
CREATE TABLE paiement (
    PAIE_ID INT NOT NULL AUTO_INCREMENT,
    PAIE_TYPE ENUM('VISA', 'MASTERCARD', 'CHEQUE', 'LIQUIDE', 'AUTRE') NOT NULL DEFAULT 'AUTRE',
    PRIMARY KEY (PAIE_ID)
) ENGINE = InnoDb;


-- Création de la table commande
CREATE TABLE commande (
    CMD_ID INT NOT NULL AUTO_INCREMENT,
    CMD_DATE DATETIME NOT NULL DEFAULT NOW(),
    CMD_CLIENT_ID INT NOT NULL, -- future clé étrangère qui sera référencée sur personne (PER_ID)
    CMD_PAIEMENT_ID INT NOT NULL, -- future clé étrangère qui sera référencée sur paiement (PAIE_ID)
    CMD_PAIEMENT_AUTORISE BIT NOT NULL DEFAULT 0,
    PRIMARY KEY (CMD_ID)
) ENGINE = InnoDb;
 --DEFAULT CURRENT_TIMESTAMP au lieu de DEFAULT NOW() fonctionne aussi


-- Création de la table commande_detail
CREATE TABLE commande_detail (
    CDET_COMMANDE_ID INT NOT NULL, -- future clé étrangère qui sera référencée sur commande (CMD_ID)
    CDET_PRODUIT_ID INT NOT NULL, -- future clé étrangère qui sera référencée sur produit (PRO_ID)
    CDET_QUANTITE INT NOT NULL DEFAULT 1,
    PRIMARY KEY (CDET_COMMANDE_ID, CDET_PRODUIT_ID)
) ENGINE = InnoDb;


-- Création de la table commentaire
CREATE TABLE commentaire (
    COM_ID INT NOT NULL AUTO_INCREMENT,
    COM_CLIENT_ID INT NOT NULL, -- future clé étrangère qui sera référencée sur personne (PER_ID)
    COM_COMMANDE_ID INT NOT NULL, -- future clé étrangère qui sera référencée sur commande (CMD_ID)
    COM_PRODUIT_ID INT NOT NULL, -- future clé étrangère qui sera référencée sur produit (PRO_ID)
    COM_TEXTE TEXT NOT NULL,
    COM_ANONYMOUS BOOLEAN NOT NULL DEFAULT 1,
    COM_DATE DATETIME NOT NULL DEFAULT NOW(),
    PRIMARY KEY (COM_ID)
) ENGINE = InnoDb;



-- Clé étrangère Catégorie -> Catégorie
ALTER TABLE categorie
    ADD CONSTRAINT FK_CategorieParent
    FOREIGN KEY (CAT_PARENT_ID)
    REFERENCES categorie (CAT_ID)
    ON DELETE CASCADE
    ON UPDATE CASCADE;


-- Clé étrangère Produit -> Fournisseur (personne)
ALTER TABLE produit
    ADD CONSTRAINT FK_ProduitFournisseur
    FOREIGN KEY (PRO_FOURNISSEUR_ID)
    REFERENCES personne (PER_ID)
    ON DELETE RESTRICT;


-- Clé étrangère ProduitCategorie -> Categorie
ALTER TABLE produit_categorie
    ADD CONSTRAINT FK_ProduitCategorieCategorie
    FOREIGN KEY (PRCA_CATEGORIE_ID)
    REFERENCES categorie (CAT_ID)
    ON DELETE CASCADE;

-- Clé étrangère ProduitCategorie -> Produit
ALTER TABLE produit_categorie
    ADD CONSTRAINT FK_ProduitCategorieProduit
    FOREIGN KEY (PRCA_PRODUIT_ID)
    REFERENCES produit (PRO_ID)
    ON DELETE CASCADE;


-- Clé étrangère Commande -> Client (personne)
ALTER TABLE commande
    ADD CONSTRAINT FK_CommandeClient
    FOREIGN KEY (CMD_CLIENT_ID)
    REFERENCES personne (PER_ID);


-- Clé étrangère Commande -> Paiement
ALTER TABLE commande
    ADD CONSTRAINT FK_CommandePaiement
    FOREIGN KEY (CMD_PAIEMENT_ID)
    REFERENCES paiement (PAIE_ID);


-- Clé étrangère CommandeDetail -> Commande
ALTER TABLE commande_detail
    ADD CONSTRAINT FK_CommandeDetailCommande
    FOREIGN KEY (CDET_COMMANDE_ID)
    REFERENCES commande (CMD_ID)
    ON DELETE CASCADE;

-- Clé étrangère CommandeDetail -> Produit
ALTER TABLE commande_detail
    ADD CONSTRAINT FK_CommandeDetailProduit
    FOREIGN KEY (CDET_PRODUIT_ID)
    REFERENCES produit (PRO_ID);


-- Clé étrangère Commentaire -> Client (personne)
ALTER TABLE commentaire
    ADD CONSTRAINT FK_CommentaireClient
    FOREIGN KEY (COM_CLIENT_ID)
    REFERENCES personne (PER_ID);


-- Clé étrangère Commentaire -> Commande
ALTER TABLE commentaire
    ADD CONSTRAINT FK_CommentaireCommande
    FOREIGN KEY (COM_COMMANDE_ID)
    REFERENCES commande (CMD_ID)
    ON DELETE CASCADE;


-- Clé étrangère Commentaire -> Produit
ALTER TABLE commentaire
    ADD CONSTRAINT FK_CommentaireProduit
    FOREIGN KEY (COM_PRODUIT_ID)
    REFERENCES produit (PRO_ID);