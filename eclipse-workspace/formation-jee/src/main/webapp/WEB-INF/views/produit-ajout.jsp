<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Ajouter un produit</title>
	</head>


	<body>
		
		<form method="POST">
		
			<p>
				<label for="addProductName">Nom du produit à ajouter</label>
				<input type="text" name="addProductName" id="addProductName">
			</p>
			
			
			<p>
				<label for="addProductPrice">Prix du produit à ajouter</label>
				<input type="text" name="addProductPrice" id="addProductPrice">
			</p>
			
			<p>
				<label for="addProductStock">Stock du produit à ajouter</label>
				<input type="text" name="addProductStock" id="addProductStock">
			</p>
			
			
			<p> 
			
			 	<label for="fournisseur">Selectionnez un fournisseur:</label>

				<select name="fournisseurName" id="fournisseurName">
				
					<c:forEach var="fournisseur" items="${ applicationScope['listeFournisseursInit'] }" varStatus="fournisseurStatus">
										 
						<option value=${ fournisseur.nom }>${ fournisseur.nom }</option>
			
					</c:forEach>

				</select> 
			
			</p>
			
			<p>
				<input type="submit" value="OK">
			</p>

			
		</form>
	

	</body>
</html>