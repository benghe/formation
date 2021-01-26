-- Afficher le nom du produit + le nom d'une des catégories
SELECT
	PRO_LIBELLE,
	(
		SELECT MIN(CAT_LIBELLE)
		FROM categorie c
		INNER JOIN produit_categorie pc ON pc.PRCA_CATEGORIE_ID = c.CAT_ID
		WHERE pc.PRCA_PRODUIT_ID = p.PRO_ID
	) AS PRO_CATEGORIE
FROM produit p;


SELECT
	PRO_LIBELLE,
	(
		SELECT MIN(CMD_DATE)
		FROM commande c
	) AS PREMIERE_DATE
FROM produit p;


SELECT CMD_DATE, PER_NOM
FROM (
	SELECT
		CMD_DATE,
		CMD_CLIENT_ID AS CLIENT_ID
	FROM commande
	WHERE CMD_DATE >= '2021-01-01'
) t
INNER JOIN personne p ON p.PER_ID = t.CLIENT_ID;



-- Afficher la date de la commande + le type de paiement (sans jointure)
SELECT PAIE_TYPE FROM paiement WHERE PAIE_ID = ?;

SELECT
	CMD_DATE,
	(SELECT PAIE_TYPE FROM paiement WHERE PAIE_ID = CMD_PAIEMENT_ID) AS PAIE_TYPE
FROM commande;

-- OU

SELECT
	CMD_DATE,
	PAIE_TYPE
FROM (SELECT CMD_DATE, CMD_PAIEMENT_ID AS PAIEMENT_ID FROM commande) t
INNER JOIN paiement p ON p.PAIE_ID = t.PAIEMENT_ID;

SELECT
	CMD_DATE,
	(
		SELECT PAIE_ID FROM paiement WHERE PAIE_ID = CMD_PAIEMENT_ID
	) AS PAIE_TYPE
FROM commande;


-- Le nom des clients qui ont commandés (sans jointure)
SELECT PER_NOM
FROM personne
WHERE PER_ID IN (SELECT CMD_CLIENT_ID FROM commande);

-- OU

SELECT DISTINCT
	(SELECT PER_NOM FROM personne WHERE PER_ID = CMD_CLIENT_ID) AS CLIENT
FROM commande;