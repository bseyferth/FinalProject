package co.grandcircus.FinalProject.APIClass;

import java.util.List;

public class Entries {

	private List<Senses> senses;

	public Entries() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Entries(List<Senses> senses) {
		super();
		this.senses = senses;
	}

	public List<Senses> getSenses() {
		return senses;
	}

	public void setSenses(List<Senses> senses) {
		this.senses = senses;
	}

	@Override
	public String toString() {
		return "Entries [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
		
}
