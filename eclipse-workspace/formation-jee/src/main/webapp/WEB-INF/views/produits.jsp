<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Liste des produits</title>
	</head>


	<body>
		<h3>Liste des produits</h3>
	
		<a href="produit-ajout"> Ajouter un produit</a>
		
	<%-- 	<c:forEach var="produit" items="${ applicationScope['listeProduitsInit'] }" varStatus="produitStatus"> --%>
		 	<%-- <c:forEach var="produit" items="${ produits }" varStatus="produitStatus"> --%>
		 	<c:forEach var="produit" items="${ produits }">
			<%-- <p>	${ produit.getNom() } </p> --%>
			<p>	${ produit.id } - ${ produit.libelle } - ${ produit.getFournisseur().getNom() }
			
				<a href="panier-ajout?id=${ produit.id }"> Ajouter au panier</a>
				
				<a href="produit-retrait?id=${ produit.id }"> Retirer le produit</a>
			</p> <!-- Transforme en getNom() grâce aux conventions de nommage -->
		</c:forEach>
		
		
		
	</body>
</html>