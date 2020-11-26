package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.user;
import service.metier;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		// TODO Auto-generated method stub
	//	doGet(request, response);
		String us = request.getParameter("nom");
		String pw = request.getParameter("pass");
		
		metier m =new metier();
		user u=m.getUser(us, pw);
		if(u!=null) {
		HttpSession session = request.getSession(true);
		request.getSession().setAttribute("user", u);
		
		

		if(u.getGrade()==1) {		
			
			this.getServletContext().getRequestDispatcher("/espaceChef.jsp").forward(request, response);


		}else {
			

			this.getServletContext().getRequestDispatcher("/espaceSecretaire.jsp").forward(request, response);

		}
	
	}else {
		this.getServletContext().getRequestDispatcher("/Connexion.jsp").forward(request, response);
	}
		
	}

}
