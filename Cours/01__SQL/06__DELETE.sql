-- Supprimer le produit 1
DELETE FROM produit WHERE PRO_ID = 1;

-- Supprimer les produits qui n’ont pas été achetés
	-- delete a from table1 a left join table2 b ... where ...
DELETE p
FROM produit p
LEFT JOIN commande_detail cd ON cd.CDET_PRODUIT_ID = p.PRO_ID
WHERE cdet_commande_id IS NULL;