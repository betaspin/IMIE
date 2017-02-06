<!DOCTYPE html>
<%@page import="fr.imie.seasons"%>
<html>
<head>
<meta charset="UTF-8">
<title>TP2 Bis</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>
<body>
<div class="container col-sm-12">
	<form action="season" method="post">
		<%
		for (seasons season : seasons.values()){
		%>
			<div class="radio">
				<label>
					<input type="radio" name="season" value="<%=season.name()%>" />
					<%=season.name()%>
				</label>
			</div>
		<%
		}
		%>
		<button type="submit" class="btn btn-primary">Envoyer</button>
	</form>
</div>
</body>
</html>