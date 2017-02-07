<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<%
Integer i = 5;
for(i=1; i<=5; i++){
	%>
		<tr>
			<td>Nombre</td>
			<td><%=i%></td>
		<tr>
	<%
}
%>
</table>
</body>
</html>