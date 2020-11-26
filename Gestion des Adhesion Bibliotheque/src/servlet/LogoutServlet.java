package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
		//if (request.getSession().getAttribute("conx")=="1") {

			PrintWriter out=response.getWriter();
			//this.getServletContext().getRequestDispatcher("/WEB-INF/Logout.jsp").include(request, response);
			HttpSession session=request.getSession();
			
			session.invalidate();
			this.getServletContext().getRequestDispatcher("/Connexion.jsp").forward(request, response);

	//		}
	//		else
		//		response.getWriter().println("vous n'etes pas connecte");
			//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		}
		
	

}
