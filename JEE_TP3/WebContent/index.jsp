<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat,java.text.DateFormat,java.util.Date,java.util.Locale"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Date dateDuJour;
dateDuJour = new Date();
DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
DateFormat shortDateFormatFR = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, new Locale("FR","fr"));
DateFormat simpleFormat = new SimpleDateFormat("dd/MM/yyyy");
%>
<%=simpleFormat.format(dateDuJour)%>
</body>
</html>