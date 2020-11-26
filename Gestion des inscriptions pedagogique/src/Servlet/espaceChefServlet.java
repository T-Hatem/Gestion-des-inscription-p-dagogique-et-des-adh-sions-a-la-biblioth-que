package Servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.annee;
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
		metier m=new metier();
		String choix = request.getParameter("choix");
		String message="";
		switch(choix) {
		case "DAnn�e" : 
			int ann=Calendar.getInstance().get(Calendar.YEAR);
			int annpr =ann+1;
			String a=ann+"-"+annpr;
			if(m.existeAnnee(a)) {
				message="cette ann�e a ete cloturer ";

			}else {

				m.demareeAnnee(a);
				message="ann� demar�";
			}
		break;

		case "CAnn�e" :
			annee anne=m.infoAnnee();

			m.cloturerAnnee(anne);
			m.changeEtat();

			message="l'ann�e universitaire a ete clotur�" ; break;
			
		case "DInsc" :

			m.demareeInscription(m.infoAnnee());
			message="inscription demarer"; break;
		
		case "CInsc" : 
			m.cloturerInscription(m.infoAnnee());
			message="inscription clotur�";break;

		}
		request.getSession().setAttribute("annee", m.infoAnnee());
		request.getSession().setAttribute("message", message);
		this.getServletContext().getRequestDispatcher("/espaceChef.jsp").forward(request, response);

		//doGet(request, response);
	}

}
