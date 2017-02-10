<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@ page import="imie.Person" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>TPJSP2</title>
</head>
<body>
<jsp:scriptlet>
	Person personne = (Person) request.getAttribute("person");
	List loisirs = (List) request.getAttribute("loisirs");
</jsp:scriptlet>

1 : <jsp:expression>personne.getFirstName()</jsp:expression> <jsp:expression>personne.getLastName()</jsp:expression><br/>
2 : ${person.firstName} ${person.lastName}<br/>
3 : <c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/>
<br/>

<c:forEach var="loisir" items="${loisirs}" varStatus="loopStatus">
	<c:out value="${loisir}"/><br/>
</c:forEach>

</body>
</html>