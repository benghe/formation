<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Bienvenue</title>
	</head>


	<body>
	
		<c:if test="${ errorMessage != null }">
		
			<div>CA S'AFFICHE SI C'EST VRAI</div>
			
		</c:if>
		
	<%-- 	${ param.error } --%>
		
	<%-- 	<c:forEach var="a" items=${list }>
		
		
		</c:forEach> --%>
		
		
		
		<c:forEach var="i" begin="0" end="7" step="1">
			<p>CA SE REPETE ${ i }
			 </p>		
		</c:forEach>
		
	
		<h2> 
			${ errorMessage }
		
		</h2>
		
		<form method="POST">
		
			<p>
				<label for="username">Username</label>
				<input type="text" name="username" id="username">
			</p>
			
			<p>
				<label for="password">Password</label>
				<input type="password" name="password" id="password">
			</p>
			
			<p>
				<input type="submit" value="OK">
			</p>

			
		</form>
	

	</body>
</html>