<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<body>
<c:out value="${user.firstName} ${user.lastName}" /><br/><br/>
<button onclick="document.location.href='logout'">Déconnexion</button>
</body>
</html>