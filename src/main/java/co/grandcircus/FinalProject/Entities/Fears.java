package co.grandcircus.FinalProject.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fears {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private  String shortFear;
	private String longFear;
	private String step1;
	private String step2;
	private String step3;
	private String step4;
	private String webMDLink;
	
	public Fears() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fears(Long id, String shortFear, String longFear, String step1, String step2, String step3, String step4,
			String webMDLink) {
		super();
		this.id = id;
		this.shortFear = shortFear;
		this.longFear = longFear;
		this.step1 = step1;
		this.step2 = step2;
		this.step3 = step3;
		this.step4 = step4;
		this.webMDLink = webMDLink;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShortFear() {
		return shortFear;
	}

	public void setShortFear(String shortFear) {
		this.shortFear = shortFear;
	}

	public String getLongFear() {
		return longFear;
	}

	public void setLongFear(String longFear) {
		this.longFear = longFear;
	}

	public String getStep1() {
		return step1;
	}

	public void setStep1(String step1) {
		this.step1 = step1;
	}

	public String getStep2() {
		return step2;
	}

	public void setStep2(String step2) {
		this.step2 = step2;
	}

	public String getStep3() {
		return step3;
	}

	public void setStep3(String step3) {
		this.step3 = step3;
	}

	public String getStep4() {
		return step4;
	}

	public void setStep4(String step4) {
		this.step4 = step4;
	}

	public String getWebMDLink() {
		return webMDLink;
	}

	public void setWebMDLink(String webMDLink) {
		this.webMDLink = webMDLink;
	}

	@Override
	public String toString() {
		return "Fears [id=" + id + ", shortFear=" + shortFear + ", longFear=" + longFear + ", step1=" + step1
				+ ", step2=" + step2 + ", step3=" + step3 + ", step4=" + step4 + ", webMDLink=" + webMDLink + "]";
	}
		
	
	
}
