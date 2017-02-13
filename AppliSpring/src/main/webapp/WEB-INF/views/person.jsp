<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OK</title>
</head>
<body>

<c:url var="url" value="/person" />

<form action="${url}/save" >
	<label for="firstname">Prénom</label>
	<input name="firstname" value="" />
	<label for="lastname">Nom</label>
	<input name="lastname" value="" />
	<button type="submit">Valider</button>
</form>

<c:forEach items="${data}" var="person">
	<c:out value="${person.firstname} ${person.lastname}" />
</c:forEach>

</body>
</html>
