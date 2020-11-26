package model;

import java.sql.Date;

public class adherant {

	private int id;
	private String nom;
	private String prenom;
	private String dateNaissance;
	private String numCarteEtudiant;
	private boolean etat;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getNumCarteEtudiant() {
		return numCarteEtudiant;
	}
	public void setNumCarteEtudiant(String numCarteEtudiant) {
		this.numCarteEtudiant = numCarteEtudiant;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	
	
	
}
