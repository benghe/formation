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