<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>	
	<jsp:useBean id="p1" class="fr.imie.Person"/>
	Prénom : <jsp:getProperty property="firstName" name="p1"/><br/>
	Nom : <jsp:getProperty property="lastName" name="p1"/><br/>
	<jsp:setProperty property="firstName" name="p1" value="Jérôme"/>
	<jsp:setProperty property="lastName" name="p1" value="Lamy"/>
	Prénom : <jsp:getProperty property="firstName" name="p1"/><br/>
	Nom : <jsp:getProperty property="lastName" name="p1"/><br/>
</body>
</html>