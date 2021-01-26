-- Clé étrangère Catégorie -> Catégorie
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