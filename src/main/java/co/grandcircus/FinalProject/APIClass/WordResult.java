package co.grandcircus.FinalProject.APIClass;

import java.util.List;

public class WordResult {
	
	private List<Results> results;

	public List<Results> getResults() {
		return results;
	}

	public void setResults(List<Results> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "WordResult [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public WordResult(List<Results> results) {
		super();
		this.results = results;
	}
	
	public WordResult() {

	}


	
	

}
