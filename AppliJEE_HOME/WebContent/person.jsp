<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="root" value="/" context="/AppliJEE_HOME"/>
<html>
<head>
<meta charset="UTF-8">
<title>Person</title>

<link rel="stylesheet" type="text/css" href="${root}css/font-awesome/css/font-awesome.min.css">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

</head>
<body>

<c:url var="url" value="/person" context="/AppliJEE_HOME"/>

<div id="container" class="container-fluid">
	<h2>Formulaire d'ajout/modification</h2>
	<div class="col-sm-4">
		<form action="${url}/save" method="post">
			<div class="form-group">
				<label for="firstname">Prénom</label><br/>
				<input type="text" name="firstname" value="${data.firstname}" />
			</div>
			<div class="form-group">
				<label for="lastname">Nom</label><br/>
				<input type="text" name="lastname" value="${data.lastname}" />
			</div>
			<input type="hidden" name="id" value="${data.id}" />
			<button class="btn btn-primary" type="submit" name="submit" value="${empty data.id ? 'insert' : 'update'}">Enregistrer</button>
		</form>
	</div>
	<div class="clearfix"></div>
	<h2>Liste des personnes</h2>
	<div class="col-sm-4">
		<table class="table">
			<thead>
				<tr>
					<th>update</th>
					<th>delete</th>
					<th>Id</th>
					<th>Prénom</th>
					<th>Nom</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="item">			
					<tr>
						<td><a href="${url}/select?id=${item.id}"><i class="fa ${item.id == data.id ? 'fa-check-square-o' : 'fa-square-o'}"></i></a></td>
						<td><a href="${url}/delete?id=${item.id}"><i class="fa fa-square-o"></i></a></td>
						<td>${item.id}</td>
						<td>${item.firstname}</td>
						<td>${item.lastname}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</body>
</html>