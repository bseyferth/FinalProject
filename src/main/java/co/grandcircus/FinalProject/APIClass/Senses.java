package co.grandcircus.FinalProject.APIClass;

import java.util.List;

public class Senses {

	private List <Definitions> definitions;

	public List<Definitions> getDefinitions() {
		return definitions;
	}

	public void setDefinitions(List<Definitions> definitions) {
		this.definitions = definitions;
	}

	public Senses() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Senses [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
