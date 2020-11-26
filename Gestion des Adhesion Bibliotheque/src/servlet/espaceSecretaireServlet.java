package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.adherant;
import model.user;
import service.metier;


@WebServlet("/espaceSecretaireServlet")
public class espaceSecretaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public espaceSecretaireServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		user u=(user)request.getSession().getAttribute("user");
		String message="";
		if(u!=null) {
		
		
		String mat=request.getParameter("numc");
		metier m=new metier();
		adherant a=m.getMembre(mat);
		if(a!=null) {
			if(a.isEtat()) {
				message="le membre est déja inscrit";

			}else {
				m.reinscrire(mat);
				message="le membre a ete réinscrie avec succes";
			}
		}else {
			message="le membre n'existe pas";
		}
		
		}else {
			message="vous n'etes pas connecté";
		}
		request.getSession().setAttribute("message", message);
		this.getServletContext().getRequestDispatcher("/espaceSecretaire.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		String message="";
		user u=(user)request.getSession().getAttribute("user");
		if(u!=null) {
		
		adherant ad=new adherant();
		ad.setNom(request.getParameter("nom"));
		ad.setPrenom(request.getParameter("pren"));
		ad.setDateNaissance(request.getParameter("daten"));
		ad.setNumCarteEtudiant(request.getParameter("cid"));
		
		metier m=new metier();
		adherant a=m.getMembre(ad.getNumCarteEtudiant());
		if(a!=null) {
			 message = "cet membre existe déja";
		}else {
			m.inscrire(ad);
		adherant aa=	m.getMembre(ad.getNumCarteEtudiant());
		message="le numero interne de cet adherant "+aa.getId();
		}
	
		}else {
			message="vous n'etes pas connecté";
		}
		request.getSession().setAttribute("message", message);
		this.getServletContext().getRequestDispatcher("/espaceSecretaire.jsp").forward(request, response);
	}

}
