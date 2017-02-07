<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>
<body>
	<form action="hello" method="get">
		<div class="form-group col-sm-2">
			<label class="control-label" for="prenom">Prénom:</label>
			<input class="form-control" type="text" name="prenom" value="" />
		</div>
		<div class="clearfix"></div>
		<div class="form-group col-sm-2">
			<label class="control-label" for="prenom">Nom:</label>
			<input class="form-control" type="text" name="nom" value="" />
		</div>
		<div class="clearfix"></div>
		<div class="form-group col-sm-2">
			<button type="submit" class="btn btn-primary">Envoyer</button>
		</div>
	</form>
</body>
</html>