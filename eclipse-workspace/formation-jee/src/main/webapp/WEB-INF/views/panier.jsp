<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Contenu de votre panier</title>
	</head>


	<body>
		
		<h3> Votre panier:</h3>
		
		<c:forEach var="produit" items="${ panier }" varStatus="panierStatus">
			<%-- <p>	${ produit.getNom() } </p> --%>
			<p>	${ produit.nom } 
			
			<a href="panier-retrait?id=${ panierStatus.index }"> Retirer du panier</a>
			
			</p>
		</c:forEach>
		
		
		
	</body>
</html>