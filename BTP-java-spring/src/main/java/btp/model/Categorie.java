package btp.model;

public enum Categorie {
	vrd ("VRD"),grosOeuvre ("Gros Oeuvre"),secondOeuvre ("Second Oeuvre"),cvc ("CVC"),autre ("Autre");

	private final String label;
	
	private Categorie(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
}
