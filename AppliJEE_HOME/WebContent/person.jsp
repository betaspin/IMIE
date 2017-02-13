<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Person</title>
<link rel="stylesheet" type="text/css" href="css/font-awesome/css/font-awesome.min.css">
</head>
<body>
<c:url var="url" value="person"/>

<form action="${url}/save" method="get">
	<label for="firstname">Prénom</label>
	<input type="text" name="firstname" value="${data.firstname}" />
	<label for="lastname">Nom</label>
	<input type="text" name="lastname" value="${data.lastname}" />
	<input type="hidden" name="id" value="${data.id}" />
	<button type="submit" name="submit" value="${test}">Enregistrer</button>
</form>

<c:forEach items="${list}" var="item">
	<tr>
		<td><a href="${url}/select?id=${item.id}"><i class="fa ${item.id == data.id ? 'fa-check-square-o' : 'fa-square-o'}"></i></a></td>
		<td></td>
		<td>${item.id}</td>
		<td>${item.firstname}</td>
		<td>${item.lastname}<td>
	</tr>
</c:forEach>
</body>
</html>