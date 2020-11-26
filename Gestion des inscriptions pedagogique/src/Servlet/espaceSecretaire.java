package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import model.annee;
import model.etudiant;
import model.inscription;
import model.user;
import service.metier;

/**
 * Servlet implementation class espaceSecretaire
 */
@WebServlet("/espaceSecretaire")
public class espaceSecretaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public espaceSecretaire() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message="";

		//	response.getWriter().append("Served at: ").append(request.getContextPath());
		String numEtud=request.getParameter("num");
		String niveau=request.getParameter("nv");
		String specialite=request.getParameter("sps");
		System.out.println(niveau);
		System.out.println(specialite);
		if(niveau=="master 1" && specialite=="MI") {
			message="verifier le niveau et specialité saissie";
		}else {
		metier m=new metier();
		etudiant et=m.getEtudiant(numEtud);
		if(et!=null) {
			if(et.isEtat()) {
				message="l'etudiant est déja réinscrit";
			}else {
				etudiant ed=new etudiant();
				inscription in = new inscription();
				ed.setIdentifiant(numEtud);
				in.setIdentifiant(numEtud);
				in.setNiveau(niveau);
				in.setSpecialite(specialite);
				in.setAnnee(m.infoAnnee().getAnnee());
				String cursus=niveau+" "+m.infoAnnee().getAnnee();
				//ed.setCursus(cursus);
				m.reinscription(ed,in);		
				message="l'etudiant a ete réinscrit avec succes";

			}
		}else {
			message="l'etudiant n'existe pas !!";
		}
		}

		request.getSession().setAttribute("message", message);
		this.getServletContext().getRequestDispatcher("/espaceSecretaire.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		metier m=new metier();
		String message="";

		etudiant ed=new etudiant();
		inscription in = new inscription();
			ed.setNom(request.getParameter("nom"));
			ed.setPrenom(request.getParameter("pren"));
			ed.setDateNaissance(request.getParameter("daten"));
			ed.setMatriculeBac(request.getParameter("mat"));
			ed.setAnneeBac(request.getParameter("annbac"));
			ed.setMail(request.getParameter("mail"));
			in.setSpecialite(request.getParameter("spec"));
			in.setNiveau(request.getParameter("nv"));
			in.setAnnee(m.infoAnnee().getAnnee());
			
			String id=ed.getAnneeBac()+ed.getMatriculeBac();
			
			ed.setIdentifiant(id);
			in.setIdentifiant(id);
			annee aa=m.infoAnnee();
			//String cursus=ed.getNiveau()+" "+aa.getAnnee();
			//ed.setCursus(cursus);
		/*	if (ed.getSpecialite()=="MI" ) {
				if(ed.getNiveau()=="master 1") {
					
				
				response.getWriter().print("verifier le niveau et specialité saissie");
			}
			}else{*/
			
			
			etudiant e= m.etudiantMinistere(ed.getMatriculeBac(), ed.getAnneeBac());
			if(e!=null) {
				if((e.getNom().equals(ed.getNom()))&&(e.getPrenom().equals(ed.getPrenom()))&&(e.getDateNaissance().equals(ed.getDateNaissance()))) {
					
					if(m.getEtudiant(ed.getIdentifiant())!=null ) {
						message="cet etudiant est déja inscrit !!";
					}else {
						
					
						message="etudiant : " +e.getNom() +" "+e.getPrenom() +" inscrit avec succes";
						m.inscription(ed,in);
					}
				}else {
					message="veuillez verifier la cohérance de vos informations";
				}
			}else {
				message="l'etudiant n'est pas inscrit au niveau du ministere";
			}
			request.getSession().setAttribute("message", message);
			this.getServletContext().getRequestDispatcher("/espaceSecretaire.jsp").forward(request, response);
			}
		
		
	
		
		
		//doGet(request, response);
	//}

}
