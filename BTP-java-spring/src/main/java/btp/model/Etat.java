package btp.model;

public enum Etat {
	consult("Consultable"), ref("Refuse"), val("Valide"), clot("Cloture");
	
	private final String label;
	
	private Etat(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
}
