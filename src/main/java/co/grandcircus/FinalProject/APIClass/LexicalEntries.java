package co.grandcircus.FinalProject.APIClass;

import java.util.List;

public class LexicalEntries {
	private List<Entries> entries;

	public LexicalEntries() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LexicalEntries(List<Entries> entries) {
		super();
		this.entries = entries;
	}

	public List<Entries> getEntries() {
		return entries;
	}

	public void setEntries(List<Entries> entries) {
		this.entries = entries;
	}

	@Override
	public String toString() {
		return "LexicalEntries [entries=" + entries + "]";
	}

	
	
}
