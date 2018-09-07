package co.grandcircus.FinalProject.APIClass;


public class Definitions {

	private String definition;

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	@Override
	public String toString() {
		return "Definitions [definition=" + definition + "]";
	}

	public Definitions(String definition) {
		super();
		this.definition = definition;
	}
	
	public Definitions() {

	}

}
