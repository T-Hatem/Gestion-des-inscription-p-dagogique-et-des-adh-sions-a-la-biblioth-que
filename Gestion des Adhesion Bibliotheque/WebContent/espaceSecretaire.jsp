<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<style type="text/css">
a, button {
	margin: 15px;
}

.card {
	margin: 15px;
}
</style>
<meta charset="ISO-8859-1">
<title>agent de la bibliothèque</title>
</head>
<body>
	<script type="text/javascript" src="js/jquerry.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<%@ page import="model.user"%>
	<%@ page import="model.annee"%>
	<%@ page import="service.metier"%>


	<%
		user u = (user) request.getSession().getAttribute("user");
	%>
	<%
		if (u != null) {
	%>
	<%
		metier m = new metier();
	%>
	<%
		annee a = m.getAnnee();
	%>
	<%
		if ((a.isEtatAnnee() == false) || (a.isEtatInscription() == false)) {
	%>

	<%
		out.print("la periode d'adhesion des membre est fermé pour le moment ");
	%>

	<%
		} else {
	%>

	<div class="container">

		<div class="row">
			<div class="col-sm"></div>
			<div class="col-sm">

				<div class="card card-body">
					<a class="btn btn-primary" data-toggle="collapse" href="#inscrire"
						role="button" aria-expanded="false" aria-controls="inscrire ">
						inscrire un nouvel adherent </a> <a class="btn btn-primary"
						data-toggle="collapse" href="#reinscrire" role="button"
						aria-expanded="false" aria-controls="reinscrire "> Reinscrire
						un adherent</a>
					<form method="post" action="./LogoutServlet">

						<button name="logout" role="button" value="logout"
							class="btn btn-danger">Se deconnecter</button>
					</form>

				</div>
				<%
					if (request.getSession().getAttribute("message") != null) {
				%>
				<div class="alert alert-primary" role="alert">
					<%
						out.print(request.getSession().getAttribute("message"));
					%>
				</div>
				<%
					request.getSession().setAttribute("message", null);
							}
				%>

				<div class="collapse card" id="inscrire">

					<div class="card-body">
						<h1 align="center">inscrire un nouvel adherant</h1>
						<form method="post" action="./espaceSecretaireServlet">
							<div class="form-group">
								<label for="exampleInputEmail1">Nom</label> <input type="text"
									required="required" class="form-control"
									id="exampleInputEmail1" name="nom">
							</div>
							<br>
							<div class="form-group">
								<label for="exampleInputEmail1">Prénom</label> <input
									required="required" type="text" class="form-control"
									id="exampleInputEmail1" name="pren">
							</div>
							<br>
							<div class="form-group">
								<label for="exampleInputEmail1">date de naissance</label> <input
									required="required" type="date" class="form-control"
									id="exampleInputEmail1" name="daten">
							</div>
							<br>

							<div class="form-group">
								<label for="exampleInputEmail1">numero de la carte
									d'etudiant</label> <input required="required" type="text"
									class="form-control" id="exampleInputEmail1" name="cid">
							</div>
							<br>
							<section align="center">
								<input type="submit" class="btn btn-primary" value="Envoyer">
							</section>

						</form>
					</div>
				</div>
				<div class="collapse card" id="reinscrire">

					<div class="card-body">
						<h1 align="center">reinscrire un adherant</h1>
						<form method="get" action="./espaceSecretaireServlet">

							<div class="form-group">
								<label for="exampleInputEmail1">numero de la carte
									d'etudiant</label> <input required="required" type="text"
									class="form-control" id="exampleInputEmail1" name="numc">
							</div>
							<br>
							<section align="center">
								<input type="submit" class="btn btn-primary" value="Envoyer">
							</section>

						</form>
					</div>
				</div>
				<%
					}
				%>
				<%
					} else {

						this.getServletContext().getRequestDispatcher("/Connexion.jsp").forward(request, response);

					}
				%>
			</div>
			<div class="col-sm"></div>
		</div>
	</div>

</body>
</html>