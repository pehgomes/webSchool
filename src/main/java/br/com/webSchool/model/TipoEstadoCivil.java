package br.com.webSchool.model;

public enum TipoEstadoCivil {
	
	CASADO("Casado"),
	SOLTEIRO("Solteiro");
	
	private String label;
	
	TipoEstadoCivil(String label) {
		this.label = label;
	}
	
	public String getLabel(){
		return label;
	}
}
