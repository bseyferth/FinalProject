package co.grandcircus.FinalProject.Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.grandcircus.FinalProject.Entities.Fear;
import co.grandcircus.FinalProject.Entities.User;

@Repository
@Transactional
public class FearDao {

	@PersistenceContext
	private EntityManager em;

	public Fear findByShort(String fearCurrent) {
		 return em.createQuery("FROM Fear WHERE short_fear = :fear", Fear.class)
				 .setParameter("fear", fearCurrent)
				 .getSingleResult();
	}
}
