<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<style type="text/css">
button {
	margin: 15px;
}
</style>
<meta charset="ISO-8859-1">
<title>conservateur de la bibliothèque</title>
</head>
<body>
	<script type="text/javascript" src="js/jquerry.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<%@ page import="model.user"%>
	<%@ page import="model.annee"%>
	<%@ page import="service.metier"%>
	<div class="container">

		<div class="row">
			<div class="col-sm"></div>
			<div class="col-sm">
				<div class="card" style="width: 18rem;">

					<div class="card-body">

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
							if (a.isEtatAnnee() == false) {
						%>

						<form method="post" action="./espaceChefServlet">
							<section align="center">
								<button name="choix" value="DAnnée"
									class="btn btn-primary  btn-block">Demarer Annee</button>
						</form>


						<%
							} else {
						%>
						<%
							if (a.isEtatInscription()) {
						%>
						<form method="post" action="./espaceChefServlet">
							<section align="center">

								<button name="choix" value="CInsc"
									class="btn btn-primary  btn-block">cloturer les
									inscriptions</button>
						</form>

						<%
							} else {
						%>
						<form method="post" action="./espaceChefServlet">
							<section align="center">
								<button name="choix" value="DInsc"
									class="btn btn-primary  btn-block">demarer les
									inscriptions</button>
						</form>


						<%
							}
						%>


						<form method="post" action="./espaceChefServlet">
							<section align="center">
								<button name="choix" value="CAnnée"
									class="btn btn-primary  btn-block">cloturer une année</button>
						</form>

						<%
							}
						%>

						<form method="post" action="./LogoutServlet">

							<button name="logout" value="logout"
								class="btn btn-danger  btn-block">Se deconnecter</button>
						</form>

						<%
							} else {

								this.getServletContext().getRequestDispatcher("/Connexion.jsp").forward(request, response);

							}
						%>
						<%
							if(request.getSession().getAttribute("message")!=null){%>
								<div class="alert alert-primary" role="alert">
							<%	out.print(request.getSession().getAttribute("message"));%>
								</div>
								<%
								request.getSession().setAttribute("message", null);
							}
							
							%>
					</div>
				</div>
			</div>
			<div class="col-sm"></div>
		</div>
	</div>
</body>
</html>