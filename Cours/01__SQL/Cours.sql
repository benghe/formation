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

CREATE TABLE categorie (
    CAT_ID INT NOT NULL AUTO_INCREMENT,
    CAT_LIBELLE VARCHAR(50) NOT NULL,
    CAT_PARENT_ID INT, -- future clé étrangère qui sera référencée sur categorie (CAT_ID)
    PRIMARY KEY (CAT_ID)
) ENGINE = InnoDb;

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

CREATE TABLE produit_categorie (
    PRCA_CATEGORIE_ID INT NOT NULL, -- future clé étrangère qui sera référencée sur categorie (CAT_ID)
    PRCA_PRODUIT_ID INT NOT NULL, -- future clé étrangère qui sera référencée sur produit (PRO_ID)
    PRIMARY KEY (PRCA_CATEGORIE_ID, PRCA_PRODUIT_ID)
) ENGINE = InnoDb;

CREATE TABLE paiement (
    PAIE_ID INT NOT NULL AUTO_INCREMENT,
    PAIE_TYPE ENUM('VISA', 'MASTERCARD', 'CHEQUE', 'LIQUIDE', 'AUTRE') NOT NULL DEFAULT 'AUTRE',
    PRIMARY KEY (PAIE_ID)
) ENGINE = InnoDb;

CREATE TABLE commande (
    CMD_ID INT NOT NULL AUTO_INCREMENT,
    CMD_DATE DATETIME NOT NULL DEFAULT NOW(),
    CMD_CLIENT_ID INT NOT NULL, -- future clé étrangère qui sera référencée sur personne (PER_ID)
    CMD_PAIEMENT_ID INT NOT NULL, -- future clé étrangère qui sera référencée sur paiement (PAIE_ID)
    CMD_PAIEMENT_AUTORISE BIT NOT NULL DEFAULT 0,
    PRIMARY KEY (CMD_ID)
) ENGINE = InnoDb;

CREATE TABLE commande_detail (
    CDET_COMMANDE_ID INT NOT NULL, -- future clé étrangère qui sera référencée sur commande (CMD_ID)
    CDET_PRODUIT_ID INT NOT NULL, -- future clé étrangère qui sera référencée sur produit (PRO_ID)
    CDET_QUANTITE INT NOT NULL DEFAULT 1,
    PRIMARY KEY (CDET_COMMANDE_ID, CDET_PRODUIT_ID)
) ENGINE = InnoDb;

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

ALTER TABLE categorie --Modification de table dans laquelle se trouve la clé étrangère
    ADD CONSTRAINT FK_CategorieParent --Ajout d'une contrainte, avec son nom
    FOREIGN KEY (CAT_PARENT_ID) --Type de contrainte (clé étrangère), et sur quelle colonne de la table modifiée
    REFERENCES categorie (CAT_ID) --On fait référence à quelle table (clé primaire sur laquelle on veut se lier)
    ON DELETE CASCADE --Comportement à faire si on supprime l'enregistrement sur lequel on est lié
    ON UPDATE CASCADE; --Comportement à faire si on supprime l'enregistrement sur lequel on est lié


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
    
-- Insertion de données dans personne (fournisseur)
INSERT INTO personne (PER_NOM, PER_PRENOM, PER_MAIL, PER_TELEPHONE, PER_ADRESSE, PER_SIRET, PER_TYPE)
VALUES ('BABAR', 'Fournisseur', 'babar@fournisseur.fr', '0123457896', '23 rue des Environs, 35000 RENNES', '12345678910', 'F');

-- Insertion de données dans personne (client)
INSERT INTO personne (PER_NOM, PER_PRENOM, PER_MAIL, PER_TELEPHONE, PER_ADRESSE, PER_PASSWORD, PER_DATE_NAISSANCE, PER_TYPE)
VALUES ('PERROUAULT', 'Jérémy', 'jeremy@gmail.com', '0666254185', '25 rue des Environs, 35000 RENNES', '123456', '1997-11-02', 'C');


-- Insertion de données dans categorie
INSERT INTO categorie (CAT_LIBELLE)
VALUES
('Parachutes'),
('Combinaisons');


-- Insertion de données dans produit
INSERT INTO produit (PRO_LIBELLE, PRO_PRIX, PRO_STOCK, PRO_FOURNISSEUR_ID)
VALUES
('Parachute de France', 7000.50, 2, 1),
('Combinaison coton', '500', 20, 1),
('Casque vidéo', '1000', 5, 1);

-- Insertion de données dans produit_categorie
INSERT INTO produit_categorie (PRCA_CATEGORIE_ID, PRCA_PRODUIT_ID)
VALUES
(1, 1),
(2, 2),
(2, 3);

-- Insertion de données dans paiement (exemple sans colonne)
INSERT INTO paiement
VALUES
(NULL, 'VISA'),
(10, 'MASTERCARD');


-- Insertion de données dans commande
INSERT INTO commande (CMD_CLIENT_ID, CMD_PAIEMENT_ID, CMD_PAIEMENT_AUTORISE)
VALUES
(2, 1, 1),
(2, 10, 0);


-- Insertion de données dans commande_detail
INSERT INTO commande_detail (CDET_COMMANDE_ID, CDET_PRODUIT_ID, CDET_QUANTITE)
VALUES
(1, 2, 1),
(1, 3, 5),
(2, 1, 1);


-- Insertion de données dans commentaire
INSERT INTO commentaire (COM_CLIENT_ID, COM_COMMANDE_ID, COM_PRODUIT_ID, COM_TEXTE, COM_ANONYMOUS)
VALUES
(1, 1, 2, 'Ceci est un commentaire.', True);