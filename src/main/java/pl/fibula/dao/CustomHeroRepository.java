package pl.fibula.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import pl.fibula.entity.Hero;

@Component
public class CustomHeroRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Hero> findTheBestIn(String skill) {
		Query query = entityManager.createQuery("select h from Hero h order by " + skill + " desc");
		return query.getResultList();
	}

}
