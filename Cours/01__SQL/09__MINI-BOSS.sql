-- Sélectionner les clients
	-- Le prix minimum d’un produit acheté, et son libellé
	-- Le prix maximum d’un produit acheté, et son libellé
	-- Son panier moyen
	-- Sa première date d’achat
	-- Sa dernière date d’achat

SELECT
	PER_ID, PER_NOM, PER_PRENOM,
	
	MIN(PRO_PRIX) AS PRIX_MINI,
	(
		SELECT PRO_LIBELLE
		FROM produit pro
		INNER JOIN commande_detail cd ON cd.CDET_PRODUIT_ID = pro.PRO_ID
		INNER JOIN commande c ON c.CMD_ID = cd.CDET_COMMANDE_ID
		WHERE c.CMD_CLIENT_ID = cmd.CMD_CLIENT_ID
		ORDER BY PRO_PRIX ASC
		LIMIT 1
	) AS PRODUIT_MINI,

	MAX(PRO_PRIX) AS PRIX_MAXI,
	(
		SELECT PRO_LIBELLE
		FROM produit pro
		INNER JOIN commande_detail cd ON cd.CDET_PRODUIT_ID = pro.PRO_ID
		INNER JOIN commande c ON c.CMD_ID = cd.CDET_COMMANDE_ID
		WHERE c.CMD_CLIENT_ID = cmd.CMD_CLIENT_ID
		ORDER BY PRO_PRIX DESC
		LIMIT 1
	) AS PRODUIT_MAXI,

	AVG(PRO_PRIX) AS PANIER_MOYEN,
	MIN(CMD_DATE) AS PREMIERE_DATE,
	MAX(CMD_DATE) AS DERNIERE_DATE

FROM commande cmd
INNER JOIN personne p ON p.PER_ID = cmd.CMD_CLIENT_ID
INNER JOIN commande_detail cd ON cd.CDET_COMMANDE_ID = cmd.CMD_ID
INNER JOIN produit pro ON pro.PRO_ID = cd.CDET_PRODUIT_ID
GROUP BY PER_ID, PER_NOM, PER_PRENOM;



SELECT PRO_LIBELLE
FROM produit pro
INNER JOIN commande_detail cd ON cd.CDET_PRODUIT_ID = pro.PRO_ID
INNER JOIN commande c ON c.CMD_ID = cd.CDET_COMMANDE_ID
WHERE c.CMD_CLIENT_ID = 2
ORDER BY PRO_PRIX ASC
LIMIT 1;