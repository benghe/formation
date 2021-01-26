<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Liste des produits</title>
	</head>


	<body>
		<h3>Liste des produit</h3>
	
		<a href="produit-ajout"> Ajouter un produit</a>
		
		<c:forEach var="produit" items="${ applicationScope['listeProduitsInit'] }" varStatus="produitStatus">
			<%-- <p>	${ produit.getNom() } </p> --%>
			<p>	${ produitStatus.index } - ${ produit.nom } - ${ produit.fournisseur.nom }
			
				<a href="panier-ajout?id=${ produitStatus.index }"> Ajouter au panier</a>
				
				<a href="produit-retrait?id=${ produitStatus.index }"> Retirer le produit</a>
			</p> <!-- Transforme en getNom() grâce aux conventions de nommage -->
		</c:forEach>
		
		
		
	</body>
</html>