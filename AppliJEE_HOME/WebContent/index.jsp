<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Personnes</title>
</head>
<body>
<form action="person" method="post">
	<label for="firstname">Prénom</label>
	<input type="text" name="firstname" value="${data.fitsname}" />
	<label for="lastname">Nom</label>
	<input type="text" name="lastname" value="${data.lastname}" />
	<button type="submit" value="${empty data.id ? 'insert' : 'update'}" name="submit">Envoyer</button>
</form>
<table>
	<tr>
		<td>update</td>
		<td>delete</td>
		<td>id</td>
		<td>prénom</td>
		<td>nom</td>
	</tr>
</table>

</body>
</html>