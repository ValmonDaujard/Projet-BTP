package btp.model;

public enum PhasePresta {

	//En Consultation : Créée par Maitre Oeuvre et envoyé à la consult à l'EG
	//Validé par EG: Réponse de l'EG et envoie du devis au Maitre d'oeuvre
	//Refusé par EG: Pas de devis envoyé par l'EG au Maitre d'oeuvre
	//Validé par Maitre oeuvre: devis recu et ajout de la prestation à l'offre
	//Refusé par Maitre d'oeuvre: devis recu maispas ajouté à l'offre 
	
	enConsult("En Consultation"), ValideEG("Validé par EG"),RefuseEG("Refusé par EG"), 
	ValideMOeuvre("Validé par Maitre Oeuvre"), RefuseMOeuvre("Refusé par Maitre Oeuvre");

	private final String label;
	
	private PhasePresta(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
}
