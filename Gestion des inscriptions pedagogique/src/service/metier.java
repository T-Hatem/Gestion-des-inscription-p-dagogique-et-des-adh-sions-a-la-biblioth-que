package service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.catalina.User;

import model.annee;
import model.etudiant;
import model.user;

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
				user.setCredentials(r.getInt("credential"));
				
				return user;
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
	
	
	public annee infoAnnee() {
		annee a=new annee();

		connection c= new connection();
		Statement s= connection.sqlStatement();
		try {
			ResultSet r=s.executeQuery("SELECT * FROM public.annee where etat=true ;");
			
			while(r.next()) {
					a.setAnnee(r.getString("annee"));
					a.setEtatAnnee(r.getBoolean("etat"));
					a.setEtatInscription(r.getBoolean("etatinscription"));
					a.setDateDebut(r.getDate("datedebut"));
					a.setDateFin(r.getDate("datefin"));
					return a;
				}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public boolean existeAnnee(String a) {
		connection c= new connection();
		Statement s= connection.sqlStatement();
		try {
			ResultSet r=s.executeQuery("SELECT * FROM public.annee where annee='"+a+"';");
			while(r.next()) {
			return true;	
			}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return false;
			}
	
	
	public void demareeAnnee(String a) {
		connection c= new connection();
		Statement s= connection.sqlStatement();
		Calendar d=Calendar.getInstance();
		int month=Calendar.getInstance().get(Calendar.MONTH)+1;
		try {
			ResultSet r=s.executeQuery("insert into public.annee (annee,etat,etatinscription,datedebut) values('"+a+"',true,false,'"+Calendar.getInstance().get(Calendar.YEAR)+"-"+month+"-"+Calendar.getInstance().get(Calendar.DAY_OF_MONTH)+"')");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	
	public void demareeInscription(annee a) {
		connection c= new connection();
		Statement s= connection.sqlStatement();
		try {
			ResultSet r=s.executeQuery("UPDATE public.annee SET etatinscription=true WHERE annee='"+a.getAnnee()+"';");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			}
	
	public void cloturerInscription(annee a) {
		connection c= new connection();
		Statement s= connection.sqlStatement();
		try {
			ResultSet r=s.executeQuery("UPDATE public.annee SET etatinscription=false WHERE annee='"+a.getAnnee()+"';");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			}
	
	public void cloturerAnnee(annee a) {
		connection c= new connection();
		Statement s= connection.sqlStatement();
		int month=Calendar.getInstance().get(Calendar.MONTH)+1;
		try {
			ResultSet r=s.executeQuery("UPDATE public.annee SET  etat=false, datefin='"+Calendar.getInstance().get(Calendar.YEAR)+"-"+month+"-"+Calendar.getInstance().get(Calendar.DAY_OF_MONTH)+"' WHERE annee='"+a.getAnnee()+"';");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}
	public void prolongerAnnee(annee a) {
		connection c= new connection();
		Statement s= connection.sqlStatement();

		try {
			int r=s.executeUpdate("UPDATE public.annee SET  etat=true WHERE annee='"+a.getAnnee()+"';");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public etudiant etudiantMinistere(String mat,String annee) {
		connection2 c= new connection2();
		Statement s= connection2.sqlStatement();
		try {
			ResultSet r=s.executeQuery("SELECT * FROM public.etudiant where anneebac='"+annee+"' and matriculebac='"+mat+"';");
			while(r.next()) {
			etudiant x=new etudiant();
			x.setMatriculeBac(r.getString("matriculebac"));
			x.setAnneeBac(r.getString("anneebac"));
			x.setNom(r.getString("nom"));
			x.setPrenom(r.getString("prenom"));
			x.setDateNaissance(r.getString("datenaissance"));
			
			return x;
			}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;
	}
	
	public etudiant getEtudiant(String id) {
		connection c= new connection();
		Statement s= connection.sqlStatement();
		try {
			ResultSet r=s.executeQuery("SELECT * FROM public.etudiant where identifiant='"+id+"';");
			while(r.next()) {
			etudiant x=new etudiant();
			x.setIdentifiant(r.getString("identifiant"));
			x.setNom(r.getString("nom"));
			x.setPrenom(r.getString("prenom"));
			x.setDateNaissance(r.getString("datenaissance"));
			x.setMail(r.getString("mail"));
			//x.setSpecialite(r.getString("specialite"));
			//x.setNiveau(r.getString("niveau"));
			x.setMatriculeBac(r.getString("matriculebac"));
			x.setAnneeBac(r.getString("anneebac"));
			//x.setCursus(r.getString("cursus"));
			x.setEtat(r.getBoolean("etat"));
			
			return x;
			}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;
	}
	public List<etudiant> getEtudiant() {
		List<etudiant> etudiants = new ArrayList<etudiant>();
		connection c= new connection();
		Statement s= connection.sqlStatement();
		try {
			ResultSet r=s.executeQuery("SELECT * FROM public.etudiant;");
			while(r.next()) {
			etudiant x=new etudiant();
			x.setIdentifiant(r.getString("identifiant"));
			x.setNom(r.getString("nom"));
			x.setPrenom(r.getString("prenom"));
			x.setDateNaissance(r.getString("datenaissance"));
			x.setMail(r.getString("mail"));
			//x.setSpecialite(r.getString("specialite"));
			//x.setNiveau(r.getString("niveau"));
			x.setMatriculeBac(r.getString("matriculebac"));
			x.setAnneeBac(r.getString("anneebac"));
			//x.setCursus(r.getString("cursus"));
			x.setEtat(r.getBoolean("etat"));
			
			etudiants.add(x);
			}
			return etudiants;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;
	}
	
	public void changeEtat() {
		connection c= new connection();
		Statement s= connection.sqlStatement();
		try {
			ResultSet r=s.executeQuery("UPDATE public.etudiant SET etat=false WHERE etat=true;");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void inscription(etudiant e,model.inscription i) {
		connection c= new connection();
		Statement s= connection.sqlStatement();
		Calendar d=Calendar.getInstance();
		try {
			System.out.println(i.getAnnee());

			int r=s.executeUpdate("insert into public.etudiant (identifiant, nom, prenom, datenaissance, mail, anneebac, matriculebac,etat) values('"+e.getIdentifiant()+"','"+e.getNom()+"','"+e.getPrenom()+"','"+e.getDateNaissance()+"','"+e.getMail()+"','"+e.getAnneeBac()+"','"+e.getMatriculeBac()+"',true);");
			int r2=s.executeUpdate("insert into public.inscription (idetudiant, idanne, niveau, specialite) values('"+i.getIdentifiant()+"','"+i.getAnnee()+"','"+i.getNiveau()+"','"+i.getSpecialite()+"');");

			System.out.println("debut insertion");
			//ResultSet r2=s.executeQuery("insert into public.inscription (idetudiant, idanne, niveau, specialite) values('"+i.getIdentifiant()+"','"+i.getAnnee()+"','"+i.getNiveau()+"','"+i.getSpecialite()+"');");
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
	
	public void reinscription(etudiant e,model.inscription i) {
		connection c= new connection();
		Statement s= connection.sqlStatement();
		String id=e.getIdentifiant();
		//String cursus =this.getEtudiant(id).getCursus()+" ,"+e.getCursus();
		try {
			int r2=s.executeUpdate("insert into public.inscription (idetudiant, idanne, niveau, specialite) values('"
					+i.getIdentifiant()+"','"+i.getAnnee()+"','"+i.getNiveau()+"','"+i.getSpecialite()+"');");

			int r=s.executeUpdate("UPDATE public.etudiant SET  etat=true WHERE identifiant='"+e.getIdentifiant()+"';");
			//ResultSet r=s.executeQuery("UPDATE public.etudiant SET  niveau='"+e.getNiveau()+"',specialite='"+e.getSpecialite()+"',cursus='"+cursus+"',etat=true WHERE identifiant='"+e.getIdentifiant()+"';");
			
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
	
}
