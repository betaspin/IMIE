<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/myTagLib.tld" prefix="imie" %>
<html>
<head>
<meta charset="UTF-8">
<title>Exo 8</title>
</head>
<body>
<c:set var="a" value="4" />
<c:set var="b" value="4" />

<imie:somme a="${a}" b="${b}" />

<imie:tableAltern />

<imie:premier />

<br/><br/>

<jsp:useBean id="voitures" class="java.util.HashMap" />
<c:set target="${voitures}" property="Renaul Clio" value="Citadine" />
<c:set target="${voitures}" property="Ferrari" value="Sportive" />
<c:set target="${voitures}" property="Toyota version" value="Monospace" />
<c:forEach var="entry" items="${voitures}">
	${entry.key} : ${entry.value}
</c:forEach>
${voitures["Ferrari"]}

</body>
</html>