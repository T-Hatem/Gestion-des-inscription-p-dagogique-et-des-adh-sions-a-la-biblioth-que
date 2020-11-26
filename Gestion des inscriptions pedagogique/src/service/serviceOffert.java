package service;

import model.etudiant;

public class serviceOffert {
	public etudiant etudiantInscrit(String iden) {
		
		metier m= new metier();
		return m.getEtudiant(iden);
		
	}

}
