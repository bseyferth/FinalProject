package co.grandcircus.FinalProject.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.grandcircus.FinalProject.Entities.User;

@Repository
@Transactional
public class UserDao {

	@PersistenceContext
	private EntityManager em;
	
	public User findbyUsername(String username) {
		 return em.createQuery("FROM User WHERE username = :name", User.class)
				 .setParameter("name", username)
				 .getSingleResult();
	}
		 
	public User findUserById(Long id) {
		return em.find(User.class, id);
	}
		 
}
