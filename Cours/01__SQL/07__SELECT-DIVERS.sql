SELECT ...
FROM ...
LEFT|INNER|RIGHT JOIN ...
WHERE ...
GROUP BY COL, COLB, COLC
HAVING ...
ORDER BY COL ASC|DESC, COLB ASC, COLC DESC
LIMIT debut, quantite;
	--> LIMIT 0, 2;
	--> LIMIT 2;

-- Sélectionner les personnes triées par prénom puis nom (affiche le prénom et le nom)
SELECT PER_PRENOM, PER_NOM
FROM personne
ORDER BY PER_PRENOM ASC,
		PER_NOM ASC;


-- Sélectionner la première commande (CMD_ID)
SELECT CMD_ID
FROM commande
-- LIMIT 1;
LIMIT 0, 1;

-- Sélectionner la dernière commande (CMD_ID)
SELECT CMD_ID
FROM commande
ORDER BY CMD_ID DESC
LIMIT 1;


-- Sélectionner la première commande et la dernière commande (CMD_ID)
(SELECT CMD_ID
FROM commande
LIMIT 1)
UNION --|INTERSECT
(SELECT CMD_ID
FROM commande
ORDER BY CMD_ID DESC
LIMIT 1);


-- Somme totale du prix des produits
SELECT SUM(PRO_PRIX) AS somme FROM produit;

-- Compter le nombre de produits
SELECT COUNT(PRO_ID) AS NBR FROM produit;

-- Compter le nombre de commandes pour chaque type de paiement (afficher l'id du type + le nombre)
SELECT CMD_PAIEMENT_ID, COUNT(CMD_ID) AS NBR
FROM commande
GROUP BY CMD_PAIEMENT_ID;



SELECT CMD_PAIEMENT_ID, COUNT(CMD_ID) AS NBR
FROM commande
GROUP BY CMD_PAIEMENT_ID
HAVING NBR > 2
ORDER BY COUNT(CMD_ID);