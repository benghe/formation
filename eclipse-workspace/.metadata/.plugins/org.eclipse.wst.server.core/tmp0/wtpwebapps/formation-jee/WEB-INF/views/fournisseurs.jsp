<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Liste des fournisseurs</title>
	</head>


	<body>
		<h3>Liste des fournisseurs</h3>
		
		
		<a href="fournisseur-ajout"> Ajouter un fournisseur</a>
		
		<c:forEach var="fournisseur" items="${ applicationScope['listeFournisseursInit'] }" varStatus="fournisseurStatus">
			<%-- <p>	${ produit.getNom() } </p> --%>
			<p>	${ fournisseurStatus.index } - ${ fournisseur.nom } 
			
						
				<a href="fournisseur-retrait?id=${ fournisseurStatus.index }"> Retirer le fournisseur</a>
			</p> <!-- Transforme en getNom() gr�ce aux conventions de nommage -->
		</c:forEach>
		
		
		
	</body>
</html>