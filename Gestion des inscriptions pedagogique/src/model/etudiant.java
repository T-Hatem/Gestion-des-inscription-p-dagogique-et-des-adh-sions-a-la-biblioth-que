package model;

import java.sql.Date;

public class etudiant {
	
	private String identifiant;
	private String nom;
	private String prenom;
	private String dateNaissance;
	private String matriculeBac;
	private String anneeBac;
	private String mail;
	
	
	private boolean etat;
	
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	


	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getMatriculeBac() {
		return matriculeBac;
	}
	public void setMatriculeBac(String string) {
		this.matriculeBac = string;
	}
	public String getAnneeBac() {
		return anneeBac;
	}
	public void setAnneeBac(String anneeBac) {
		this.anneeBac = anneeBac;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	
	
	
}
