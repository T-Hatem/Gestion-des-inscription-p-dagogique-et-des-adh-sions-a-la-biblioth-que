package model;

import java.sql.Date;

public class annee {
	private String annee;
	private boolean etatAnnee;
	private boolean etatInscription;
	private Date dateDebut;
	private Date dateFin;
	public String getAnnee() {
		return annee;
	}
	public void setAnnee(String annee) {
		this.annee = annee;
	}
	public boolean isEtatAnnee() {
		return etatAnnee;
	}
	public void setEtatAnnee(boolean etatAnnee) {
		this.etatAnnee = etatAnnee;
	}
	public boolean isEtatInscription() {
		return etatInscription;
	}
	public void setEtatInscription(boolean etatInscription) {
		this.etatInscription = etatInscription;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	
}
