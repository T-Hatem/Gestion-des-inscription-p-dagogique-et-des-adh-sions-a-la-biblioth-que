package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.adherant;
import model.annee;
import model.user;
import service.ServiceOffertStub.Etudiant;

public class metier {

	public user getUser(String u,String p) {
		connection c= new connection();
		Statement s= connection.sqlStatement();
		user user=new user();
		try {
			ResultSet r=s.executeQuery("SELECT * FROM public.user WHERE username='"+u+"'");
			while(r.next()) {
				if(r.getString("password").equals(p)) {

				user.setUsername(r.getString("username"));
				user.setPassword(r.getString("password"));
				user.setGrade(r.getInt("grade"));
				
				return user;
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public annee getAnnee() {
		connection c= new connection();
		Statement s= connection.sqlStatement();
		annee a=new annee();
		try {
			ResultSet r=s.executeQuery("SELECT * FROM public.annee WHERE annee='biblio'");
			while(r.next()) {
			a.setAnnee(r.getString("annee"));
			a.setEtatAnnee(r.getBoolean("etatannee"));
			a.setEtatInscription(r.getBoolean("etatinscription"));
			
			return a;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public adherant getMembre(String mat) {
		connection c= new connection();
		Statement s= connection.sqlStatement();
		adherant a=new adherant();
		try {
			ResultSet r=s.executeQuery("SELECT * FROM public.adherant WHERE numcarteetudiant='"+mat+"'");
			while(r.next()) {
			a.setId(r.getInt("id"));	
			a.setNom(r.getString("nom"));
			a.setPrenom(r.getString("prenom"));
			a.setDateNaissance(r.getString("datenaissance"));
			a.setNumCarteEtudiant(r.getString("numcarteetudiant"));
			a.setEtat(r.getBoolean("etat"));
			
			return a;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public void demarerAnnee() {
		connection c= new connection();
		Statement s= connection.sqlStatement();
		try {
			ResultSet r=s.executeQuery("UPDATE public.annee SET etatannee=true WHERE annee='biblio';");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void cloturerAnnee() {
		connection c= new connection();
		Statement s= connection.sqlStatement();
		try {
			ResultSet r=s.executeQuery("UPDATE public.annee SET etatannee=false WHERE annee='biblio';");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void demareradhesion() {
		connection c= new connection();
		Statement s= connection.sqlStatement();
		try {
			ResultSet r=s.executeQuery("UPDATE public.annee SET etatinscription=true WHERE annee='biblio';");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void cloturerAdhesion() {
		connection c= new connection();
		Statement s= connection.sqlStatement();
		try {
			ResultSet r=s.executeQuery("UPDATE public.annee SET etatinscription=false WHERE annee='biblio';");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void reinscrire(String mat) {
		connection c= new connection();
		Statement s= connection.sqlStatement();
		try {
			ResultSet r=s.executeQuery("UPDATE public.adherant SET etat=true WHERE numcarteetudiant='"+mat+"';");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void inscrire(adherant ad) {
		
		
		connection c= new connection();
		Statement s= connection.sqlStatement();
		try {
			// creation du stub 
			ServiceOffertStub sos=new ServiceOffertStub();
			//creation de la requete
			ServiceOffertStub.EtudiantInscrit request=new ServiceOffertStub.EtudiantInscrit();
			//parametre de la requette
			request.setIden(ad.getNumCarteEtudiant());
			
			ServiceOffertStub.EtudiantInscritResponse reponse=sos.etudiantInscrit(request);
			 Etudiant rep=reponse.get_return();
			 
			
			
			
			ResultSet r=s.executeQuery("insert into public.adherant (nom,prenom,datenaissance,numcarteetudiant,etat) values('"+ad.getNom()+"','"+ad.getPrenom()+"','"+ad.getDateNaissance()+"','"+ad.getNumCarteEtudiant()+"',true);");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void changeEtat() {
		connection c= new connection();
		Statement s= connection.sqlStatement();
		try {
			ResultSet r=s.executeQuery("UPDATE public.adherant SET etat=false WHERE etat=true;");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
