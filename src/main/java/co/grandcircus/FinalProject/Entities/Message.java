package co.grandcircus.FinalProject.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	
	
	private Long id;
	private Long user1id;
	private String message;
	private Long user2id;
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(Long id, Long user1id, String message, Long user2id) {
		super();
		this.id = id;
		this.user1id = user1id;
		this.message = message;
		this.user2id = user2id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUser1id() {
		return user1id;
	}

	public void setUser1id(Long user1id) {
		this.user1id = user1id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getUser2id() {
		return user2id;
	}

	public void setUser2id(Long user2id) {
		this.user2id = user2id;
	}

	@Override
	public String toString() {
		return "Messages [id=" + id + ", user1id=" + user1id + ", message=" + message + ", user2id=" + user2id + "]";
	}
	
	
	
}
