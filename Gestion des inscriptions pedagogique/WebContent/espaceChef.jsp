<%@page import="java.sql.Date"%>
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
<title>Espace Chef departement</title>
</head>
<body>

	<script type="text/javascript" src="js/jquerry.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<%@ page import="model.annee"%>
	<%@ page import="model.user"%>
	<%@ page import="java.util.Calendar"%>
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
							int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
						%>
						<h2>
							Date :
							<%
							out.println(Calendar.getInstance().get(Calendar.YEAR) + "/" + month + "/"
										+ Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
						%>
						</h2>
						<%
							annee a = (annee) request.getSession().getAttribute("annee");
						%>
						<%
							request.getSession().setAttribute("conx", "1");
						%>


						<%
							if (a == null) {
						%>
						<form method="post" action="./espaceChefServlet">

							<%
								int ann = Calendar.getInstance().get(Calendar.YEAR);
										int annpr = ann + 1;
							%>
							<button name="choix" class="btn btn-primary  btn-block"
								value="DAnnée">
								demarer l'année
								<%
								out.print(ann + "-" + annpr);
							%>
							</button>
						</form>
						<%
							} else {
						%>

						<%
							out.println("année en cours : " + a.getAnnee());
						%>
						<form method="post" action="./espaceChefServlet">

							<button name="choix" class="btn btn-primary  btn-block"
								value="CAnnée">cloturer une année</button>
						</form>

						<%
							if (a.isEtatInscription()) {
						%>
						<form method="post" action="./espaceChefServlet">

							<button name="choix" value="CInsc"
								class="btn btn-primary  btn-block">cloturer les
								inscriptions</button>
						</form>
						<%
							} else {
						%>
						<form method="post" action="./espaceChefServlet">

							<button name="choix" value="DInsc"
								class="btn btn-primary  btn-block">demarer les
								inscriptions</button>
						</form>

						<%
							}
						%>
						<%
							}
						%>

						<form method="post" action="./LogoutServlet">

							<button name="logout" value="logout"
								class="btn btn-danger  btn-block">Se deconnecter</button>
						</form>

						<%
							} else {
								this.getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);

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