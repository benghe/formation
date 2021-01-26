-- Sélectionner la personne ID 1
SELECT PER_ID, PER_NOM, PER_PRENOM FROM personne WHERE PER_ID = 1;

-- Sélectionner le produit dont le nom est égal à une valeur
SELECT * FROM produit WHERE PRO_LIBELLE = 'Combinaison coton';

-- Sélectionner les produits contenant « o »
SELECT * FROM produit WHERE PRO_LIBELLE LIKE '%o%';

-- Sélectionner la personne ID 1 ET la personne ID 2 (AND/OR)
SELECT * FROM personne WHERE PER_ID <= 2;
SELECT * FROM personne WHERE PER_ID = 1 OR PER_ID = 2;

-- Sélectionner la personne ID 1 ET la personne ID 2 (IN)
SELECT * FROM personne WHERE PER_ID IN (1, 2);

-- Sélectionner la personne ID contenu entre 2 et 10
SELECT * FROM personne WHERE PER_ID >= 2 AND PER_ID <= 10;
SELECT * FROM personne WHERE PER_ID BETWEEN 2 AND 10;


-- Selection plusieurs tables (produit cartésien)
SELECT * FROM produit, commande, commande_detail; --Toutes les possibilités

SELECT * FROM produit, commande, commande_detail
WHERE CMD_ID = CDET_COMMANDE_ID; --Restriction sur liaison entre commande et commande_detail

SELECT * FROM produit, commande, commande_detail
WHERE PRO_ID = CDET_PRODUIT_ID; --Restriction sur liaison entre produit et commande_detail

SELECT * FROM produit, commande, commande_detail
WHERE PRO_ID = CDET_PRODUIT_ID AND CMD_ID = CDET_COMMANDE_ID; --Restriction sur liaison entre produit et commande_detail et commande

SELECT PRO_ID, CMD_ID FROM produit, commande, commande_detail
WHERE PRO_ID = CDET_PRODUIT_ID AND CMD_ID = CDET_COMMANDE_ID;


-- Les moyens de paiements qui ont été utilisés (en partant de paiement)
SELECT PAIE_ID, PAIE_TYPE FROM paiement p
INNER JOIN commande c ON p.PAIE_ID = c.CMD_PAIEMENT_ID;

SELECT PAIE_ID, PAIE_TYPE FROM paiement p
RIGHT JOIN commande c ON p.PAIE_ID = c.CMD_PAIEMENT_ID;

-- Les moyens de paiements qui ont été utilisés (en partant de commande)
SELECT * FROM commande c
LEFT JOIN paiement p ON p.PAIE_ID = c.CMD_PAIEMENT_ID;

SELECT * FROM commande c
INNER JOIN paiement p ON p.PAIE_ID = c.CMD_PAIEMENT_ID;


-- Le texte des commentaires avec le nom du client
SELECT COM_TEXTE, PER_NOM, PER_PRENOM
FROM commentaire c
INNER JOIN personne p ON p.PER_ID = c.COM_CLIENT_ID;


-- Le nom du client avec les dates de ses commmandes
SELECT PER_NOM, CMD_DATE
FROM commande c
INNER JOIN personne p ON p.PER_ID = c.CMD_CLIENT_ID;

SELECT PER_NOM, CMD_DATE
FROM personne p
INNER JOIN commande c ON p.PER_ID = c.CMD_CLIENT_ID;


-- Le texte des commentaires avec le nom du client et le nom du produit
SELECT COM_TEXTE, PER_NOM, PER_PRENOM, PRO_LIBELLE
FROM commentaire c
INNER JOIN personne p ON p.PER_ID = c.COM_CLIENT_ID
INNER JOIN produit pro ON pro.PRO_ID = c.COM_PRODUIT_ID;


-- La date de commande, le nom du client + le type de paiement
SELECT CMD_DATE, PER_NOM, PER_PRENOM, PAIE_TYPE
FROM commande c
INNER JOIN personne p ON p.PER_ID = c.CMD_CLIENT_ID
INNER JOIN paiement pa ON pa.PAIE_ID = c.CMD_PAIEMENT_ID;

SELECT CMD_DATE, PER_NOM, PER_PRENOM, PAIE_TYPE
FROM paiement pa
INNER JOIN commande c ON pa.PAIE_ID = c.CMD_PAIEMENT_ID
INNER JOIN personne p ON p.PER_ID = c.CMD_CLIENT_ID;

SELECT CMD_DATE, PER_NOM, PER_PRENOM, PAIE_TYPE
FROM personne p
INNER JOIN commande c ON p.PER_ID = c.CMD_CLIENT_ID
INNER JOIN paiement pa ON pa.PAIE_ID = c.CMD_PAIEMENT_ID;


-- Afficher le nom du produit et le libellé des catégories dans lesquelles il se trouve
SELECT PRO_LIBELLE, CAT_LIBELLE
FROM produit p
INNER JOIN produit_categorie procat ON procat.PRCA_PRODUIT_ID = p.PRO_ID
INNER JOIN categorie c ON c.CAT_ID = procat.PRCA_CATEGORIE_ID;

SELECT PRO_LIBELLE, CAT_LIBELLE
FROM produit_categorie procat
INNER JOIN produit p ON procat.PRCA_PRODUIT_ID = p.PRO_ID
INNER JOIN categorie c ON c.CAT_ID = procat.PRCA_CATEGORIE_ID;




		A				|				B
SELECT * FROM commande | LEFT JOIN personne ON ....;
SELECT * FROM personne | RIGHT JOIN commande ON ....;


		A				|				B			|				C
SELECT * FROM commande | LEFT JOIN personne ON .... | LEFT JOIN commentaire ON ...;

						A							|				B
SELECT * FROM commande | LEFT JOIN personne ON .... | LEFT JOIN commentaire ON ...;



-- Sélectionner tous les achats
-- avec les infos du client
-- avec les infos du produit
SELECT PER_ID, PER_NOM, PER_PRENOM, PRO_ID, PRO_LIBELLE, PRO_PRIX
FROM commande_detail cd
INNER JOIN produit p ON p.PRO_ID = cd.CDET_PRODUIT_ID
INNER JOIN commande c ON c.CMD_ID = cd.CDET_COMMANDE_ID
INNER JOIN personne pers ON pers.PER_ID = c.CMD_CLIENT_ID;


-- Sélectionner tous les clients, et leurs achats
-- si disponible, avec les informations du produit


-- Sélectionner uniquement les clients qui ont fait des achats


-- Les produits commentés dont le prix est entre 10 et 30 euros
-- avec le texte, le nom du client, le nom du produit, la date de commentaire

-- Les produits commandés contenus dans la catégorie #1