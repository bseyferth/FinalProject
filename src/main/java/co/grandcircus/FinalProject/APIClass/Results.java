package co.grandcircus.FinalProject.APIClass;

import java.util.List;

public class Results {
	
	private List<LexicalEntries> lexicalEntries;

	public List<LexicalEntries> getLexicalEntries() {
		return lexicalEntries;
	}

	public void setLexicalEntries(List<LexicalEntries> lexicalEntries) {
		this.lexicalEntries = lexicalEntries;
	}

	@Override
	public String toString() {
		return "Results [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	public Results(List<LexicalEntries> lexicalEntries) {
		super();
		this.lexicalEntries = lexicalEntries;
	}
	
	public Results() {

	}

}
