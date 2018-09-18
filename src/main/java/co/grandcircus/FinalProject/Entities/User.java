package co.grandcircus.FinalProject.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String fearCurrent;
	@Column(name = "ranking")
	private Integer rank;
	private Long partnerId;
	private String fearCompleted;
	private Long previousPartnerId;
	private Integer fearProgress;
	private Long facebookId;
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getFearCurrent() {
		return fearCurrent;
	}

	public void setFearCurrent(String fearCurrent) {
		this.fearCurrent = fearCurrent;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Long getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}

	public String getFearCompleted() {
		return fearCompleted;
	}

	public void setFearCompleted(String fearCompleted) {
		this.fearCompleted = fearCompleted;
	}

	public Long getPreviousPartnerId() {
		return previousPartnerId;
	}

	public void setPreviousPartnerId(Long previousPartnerId) {
		this.previousPartnerId = previousPartnerId;
	}

	public Integer getFearProgress() {
		return fearProgress;
	}

	public void setFearProgress(Integer fearProgress) {
		this.fearProgress = fearProgress;
	}

	public Long getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(Long facebookId) {
		this.facebookId = facebookId;
	}

	public User(Long id, String username, String password, String firstName, String lastName, String email,
			String address, String city, String state, String zip, String fearCurrent, Integer rank, Long partnerId,
			String fearCompleted, Long previousPartnerId, Integer fearProgress, Long facebookId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.fearCurrent = fearCurrent;
		this.rank = rank;
		this.partnerId = partnerId;
		this.fearCompleted = fearCompleted;
		this.previousPartnerId = previousPartnerId;
		this.fearProgress = fearProgress;
		this.facebookId = facebookId;
	}

	public String getUserImageUrl() {
		return "https://graph.facebook.com/" + id + "/picture?type=large";
	}

	public void copyToUser(User user) {
		user.setFacebookId(id);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", address=" + address + ", city=" + city + ", state="
				+ state + ", zip=" + zip + ", fearCurrent=" + fearCurrent + ", rank=" + rank + ", partnerId="
				+ partnerId + ", fearCompleted=" + fearCompleted + ", previousPartnerId=" + previousPartnerId
				+ ", fearProgress=" + fearProgress + ", FacebookId=" + facebookId + "]";
	}

}