package co.grandcircus.FinalProject.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Quote {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String quote;
	
	public Quote() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Quote(Long id, String quote) {
		super();
		this.id = id;
		this.quote = quote;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	@Override
	public String toString() {
		return "Quotes [id=" + id + ", quote=" + quote + "]";
	}

	
	
}
