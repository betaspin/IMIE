<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<form action="login" method="post">
	<input type="text" name="login" value="" />
	<input type="password" name="password" value="" />
	<button type="submit">Envoyer</button>
</form>
<br/>

<c:if test="${!empty error}">
	<c:out value="${error}"></c:out>
</c:if>

</body>
</html>