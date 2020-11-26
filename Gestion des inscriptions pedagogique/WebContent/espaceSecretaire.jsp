<%@page import="org.eclipse.jdt.internal.compiler.ast.ForeachStatement"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
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
<title>agent de scolarité</title>
</head>
<body>
	<script type="text/javascript" src="js/jquerry.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/script.js"></script>
	<%@ page import="service.metier"%>
	<%@ page import="model.etudiant"%>

	<%@ page import="model.annee"%>
	<%@ page import="model.user"%>
	<div class="container">

		<div class="row">
			<div class="col-sm"></div>
			<div class="col-sm">
				<%
					annee a = (annee) request.getSession().getAttribute("annee");
				%>
				<%
					user u = (user) request.getSession().getAttribute("user");
				%>
				<%
					if (u != null) {
				%>
				<%
					if (a == null) {
				%>
				<div class="alert alert-primary" role="alert">
					<%
						out.println("l'année universitaire n'as pas encore demarré");
					%>
				</div>
				<%
					} else {
							if (a.isEtatInscription() == false) {
				%>
				<div class="alert alert-primary" role="alert">
					<%
						out.println("les inscriptions n'ont pas encore commencé");
					%>
				</div>

				<%
					} else {
				%>
				<div class="card card-body">
					<a class="btn btn-primary" data-toggle="collapse" href="#inscrire"
						role="button" aria-expanded="false" aria-controls="inscrire ">
						inscrire un nouvel etudiant </a> <a class="btn btn-primary"
						data-toggle="collapse" href="#reinscrire" role="button"
						aria-expanded="false" aria-controls="reinscrire "> Reinscrire
						un etudiant</a>
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
						<h1 align="center">inscrire un nouvel etudiant</h1>
						<form method="post" action="./espaceSecretaire">
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
								<label for="exampleInputEmail1">matricule Bac</label> <input
									required="required" type="text" class="form-control"
									id="exampleInputEmail1" name="mat">
							</div>
							<br>
							<div class="form-group">
								<label for="exampleInputEmail1">annee Bac</label> <input
									required="required" type="text" class="form-control"
									id="exampleInputEmail1" name="annbac">
							</div>

							<br>
							<div class="form-group">
								<label for="exampleInputEmail1">mail</label> <input type="email"
									required="required" class="form-control"
									id="exampleInputEmail1" name="mail">
							</div>

							<br>

							<div class="form-group">
								<label for="exampleFormControlSelect1">niveau</label> <select
									class="form-control" id="nvinsc" name="nv">
									<option value="" selected>Niveau</option>
									<option value="licence1">Licence 1</option>
									<option value="master1">Master 1</option>

								</select>
							</div>
							<div class="form-group">
								<label for="exampleFormControlSelect1">specialité</label> <select
									class="form-control" id="specinsc" name="spec">


								</select>
							</div>

							<br> <br>
							<section align="center">
								<input type="submit" class="btn btn-primary" value="Envoyer">
							</section>

						</form>
					</div>
				</div>
				<div class="collapse card" id="reinscrire">

					<div class="card-body">
						<h1 align="center">Reinscrire un etudiant</h1>
						<form method="get" action="./espaceSecretaire">

							<div class="form-group">
								<label for="exampleInputEmail1">numero de la carte
									d'etudiant</label> <input type="text" class="form-control"
									required="required" id="exampleInputEmail1" name="num">
							</div>
							<br>

							<div class="form-group">
								<label for="exampleFormControlSelect1">niveau</label> <select
									required="required" class="form-control" id="nvreinsc"
									name="nv">
									<option value="" selected>Niveau</option>
									<option value="licence1">Licence 1</option>
									<option value="licence2">Licence 2</option>
									<option value="licence3">Licence 3</option>

									<option value="master1">Master 1</option>
									<option value="master2">Master 2</option>


								</select>
							</div>
							<div class="form-group">
								<label for="exampleFormControlSelect1">specialité</label> <select
									required="required" class="form-control" id="specreinsc"
									name="sps">


								</select>
							</div>


							<section align="center">
								<input type="submit" class="btn btn-primary" value="Envoyer">
							</section>
							<br>
						</form>
						<%
							}
								}
						%>
						<%
							} else {
								this.getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);

							}
						%>
					</div>
				</div>

				<div>
					<%
						metier m = new metier();
						List<etudiant> etudiants = m.getEtudiant();
					%>
					<table class="table">
						<thead>
							<tr>
								<th scope="col">numero de la carte </th>
								<th scope="col">nom</th>
								<th scope="col">prenom</th>
								<th scope="col">mail</th>
								
								
								<th scope="col">date de naissance</th>
								<th scope="col">etat cursus</th>

							</tr>
						</thead>
						<tbody>
						<%for(etudiant e:etudiants){%>
							<tr>
								<th scope="row"><%out.print(e.getIdentifiant()) ;%></th>
								<td><%out.print(e.getNom()) ;%></td>
								<td><%out.print(e.getPrenom()) ;%></td>
								<td><%out.print(e.getMail()) ;%></td>
								
								
								<td><%out.print(e.getDateNaissance()) ;%></td>
								<td><%if(e.isEtat())
								out.print("inscrit") ;
								else
									out.print("non inscrit") ;

								%></td>
								
								
							</tr>
							<%} %>
						</tbody>
					</table>
				</div>

			</div>
			<div class="col-sm"></div>
		</div>
	</div>
</body>
</html>