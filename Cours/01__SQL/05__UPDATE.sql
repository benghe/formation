-- Modifier le nom de la personne ID 1
UPDATE personne
SET PER_NOM = 'TOTO'
WHERE PER_ID = 1;

-- Modifier le prix du produit 1 (augmentation du prix de 10%)
UPDATE produit
SET PRO_PRIX = PRO_PRIX * 1.1
WHERE PRO_ID = 1;


-- Modifier le prix des produits qui n’ont pas été achetés (diminution du prix de 20%)
-- #1 rechercher les produits qui n'ont pas été achetés
SELECT * FROM produit p
LEFT JOIN commande_detail cd ON cd.CDET_PRODUIT_ID = p.PRO_ID
WHERE cdet_commande_id IS NULL;

-- #2 update avec la bonne syntaxe (jointure)
	-- update table1 a inner join table2 ... set ... where ...
UPDATE produit p
LEFT JOIN commande_detail cd ON cd.CDET_PRODUIT_ID = p.PRO_ID
SET PRO_PRIX = PRO_PRIX * 0.8
WHERE cdet_commande_id IS NULL;