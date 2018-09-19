package co.grandcircus.FinalProject.Entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
@Entity
public class Message {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	
	private Long id;
	@Column(name = "user_message")
	private String userMessage;
	private Long senderId;
	private Long receiverId;
	@Temporal(TemporalType.DATE)
	@Column(name = "message_sent")
	@CreationTimestamp
	private Date messageSent;
	@Column(name = "sender_name")
	private String senderName;
	@Column(name = "receiver_name")
	private String receiverName;
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(Long id, String userMessage, Long senderId, Long receiverId, Date messageSent, String senderName, String receiverName) {
		super();
		this.id = id;
		this.userMessage = userMessage;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.messageSent = messageSent;
		this.senderName = senderName;
		this.receiverName = receiverName;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public Date getMessageSent() {
		return messageSent;
	}
	public void setMessageSent(Date messageSent) {
		this.messageSent = messageSent;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSenderId() {
		return senderId;
	}

	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	public Long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}

	@Override
	public String toString() {
		return "Messages [id=" + id + ", senderId=" + senderId + ", userMessage=" + userMessage + ", receiverId=" + receiverId + ", messageSent=" + messageSent + ", senderName=" + senderName + ", receiverName=" + receiverName + "]";
	}
	
	
	
}
