package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import service.metier;

/**
 * Servlet implementation class espaceChefServlet
 */
@WebServlet("/espaceChefServlet")
public class espaceChefServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public espaceChefServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	//	doGet(request, response);
		String choix=request.getParameter("choix");
		metier m=new metier();
		String message="";
		switch(choix) {
		case "DAnnée": 
			m.demarerAnnee();
			message="anné demaré";

		break;
		case "CInsc": 
			m.cloturerAdhesion();
			message="cloturer adhesion";

		break;
		case "DInsc": 
			m.demareradhesion();
			message="demarer adhesion";

		break;
		case "CAnnée": 
			m.cloturerAnnee();
			m.changeEtat();
			message="anné cloturé";
		break;
		
		
		
		}
		request.getSession().setAttribute("annee", m.getAnnee());

		request.getSession().setAttribute("message", message);
		this.getServletContext().getRequestDispatcher("/espaceChef.jsp").forward(request, response);

		
	}

}
