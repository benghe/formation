<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Ajouter ou modifier une catégorie</title>
	</head>


	<body>
		
		<form method="POST">
		
			<p>
				<label for="addorModifyCategorieName">${ textModifyOrAdd }</label>
				<input type="text" name="addorModifyCategorieName" id="addorModifyCategorieName" placeholder="${ categorieAModifier.getLibelle() }">
			</p>

	
			<p>
				<input type="submit" value="OK">
			</p>

			
		</form>
		
	
	</body>
</html>