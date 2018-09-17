package co.grandcircus.FinalProject.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
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
		System.out.println(username);
		try {
			return em.createQuery("FROM User WHERE username = :name", User.class).setParameter("name", username)
					.getSingleResult();
		} catch (NoResultException e)  {
			return null;
		}
	}

	public User findUserById(Long id) {
		return em.find(User.class, id);
	}

	public void create(User user) {
		em.persist(user);
	}

	// access complete list of users
	public List<User> listAll() {
		return em.createQuery("FROM User", User.class).getResultList();
	}

	public void update(User user){
		em.merge(user);
	}
	
	public User findbyEmail(String email) {
		try {
			return em.createQuery("FROM User WHERE email = :name", User.class).setParameter("name", email)
					.getSingleResult();
		} catch (NoResultException e)  {
			return null;
		}catch (NonUniqueResultException e)  {
			return null;
		}catch (NullPointerException e)  {
			return null;
		}
	}
}
