<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<meta charset="ISO-8859-1">
<title>Authentification</title>
</head>
<body>
	<script type="text/javascript" src="js/jquerry.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<div class="container">

		<div class="row">
			<div class="col-sm"></div>
			<div class="col-sm">

				<div class="card">

					<div class="card-body">
						<h1 align="center">Authentification</h1>
						<form method="post" action="./LoginServlet">
							<div class="form-group">
								<label for="exampleInputEmail1">Nom d'utlisateur</label> 
								<input required="required"
									type="text" class="form-control" id="exampleInputEmail1" name="nom"
									> 
							</div>
							
							<br>
							<div class="form-group">
								<label for="exampleInputEmail1"> Mot de passe</label> 
								<input required="required"
									type="password" class="form-control" id="exampleInputEmail1" name="pass"
									> 
							</div>
							
							<br>
							<section align="center">
								<input type="submit" class="btn btn-primary" value="Envoyer">
							</section>

						</form>
					</div>
				</div>


			</div>
			<div class="col-sm"></div>
		</div>

	</div>
</body>
</html>