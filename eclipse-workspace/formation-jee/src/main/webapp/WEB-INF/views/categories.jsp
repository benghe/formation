<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Liste des cat�gories</title>
	</head>


	<body>
		<h3>Liste des cat�gories</h3>
	
		<a href="categorie-ajout"> Ajouter une cat�gorie</a>
	

		 	<c:forEach var="categorie" items="${ categories }">
			<%-- <p>	${ produit.getNom() } </p> --%>
			<p>	${ categorie.id } - ${ categorie.libelle }
			
				
				<a href="categorie-retrait?id=${ categorie.id }"> Retirer la cat�gorie</a>
				
				<a href="categorie-modifier?id=${ categorie.id }"> Modifier la cat�gorie</a>
			</p>
		</c:forEach>
		
		
		
	</body>
</html>