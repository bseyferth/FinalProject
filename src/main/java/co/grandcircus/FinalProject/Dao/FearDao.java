package co.grandcircus.FinalProject.Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class FearDao {

	@PersistenceContext
	private EntityManager em;
}
