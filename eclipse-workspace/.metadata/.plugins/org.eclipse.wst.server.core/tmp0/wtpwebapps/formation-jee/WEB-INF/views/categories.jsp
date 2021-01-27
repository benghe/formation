<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Liste des catégories</title>
	</head>


	<body>
		<h3>Liste des catégories</h3>
	
		<a href="categorie-ajout"> Ajouter une catégorie</a>
	

		 	<c:forEach var="categorie" items="${ categories }">
			<%-- <p>	${ produit.getNom() } </p> --%>
			<p>	${ categorie.id } - ${ categorie.libelle }
			
				
				<a href="categorie-retrait?id=${ categorie.id }"> Retirer la catégorie</a>
				
				<a href="categorie-modifier?id=${ categorie.id }"> Modifier la catégorie</a>
			</p>
		</c:forEach>
		
		
		
	</body>
</html>