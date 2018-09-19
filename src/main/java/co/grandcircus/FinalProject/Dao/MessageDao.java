package co.grandcircus.FinalProject.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.grandcircus.FinalProject.Entities.Message;

@Repository
@Transactional
public class MessageDao {

	@PersistenceContext
	private EntityManager em;
	
	public Message findMessageById(Long id) {
		return em.find(Message.class, id);
	}

	public void create(Message message) {
		em.persist(message);
	}

	// access complete list of users
	public List<Message> listAll() {
		return em.createQuery("FROM Message", Message.class).getResultList();
	}

	public void update(Message message){
		em.merge(message);
	}	
	
	//list of messages based on senderId
	public List<Message> findMessageBySenderId(Long senderId){
		try {
		return em.createQuery("FROM Message WHERE sender_id = :sender_id", Message.class).setParameter("sender_id", senderId).getResultList();
	} catch (NoResultException e)  {
		return null;
	}
	}
	
	//list of messages based on receiverId
	public List<Message> findMessageByReceiverId(Long receiverId) {
		try {
		return em.createQuery("FROM Message WHERE receiver_id = :receiver_id", Message.class).setParameter("receiver_id", receiverId).getResultList();
	} catch (NoResultException e)  {
		return null;
		
	}
}
	//find all messages ordered by date
	public List<Message> findMessageByDate() {
		try {
		return em.createQuery("FROM Message ORDER BY message_sent" , Message.class).getResultList();
	} catch (NoResultException e)  {
		return null;
		
	}
	}
	

}