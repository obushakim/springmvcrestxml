package obus.test.springmvcrestxml.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import obus.test.springmvcrestxml.model.Obus;

@Repository("obusDao")
public class ObusDao {
	@Autowired
	private HibernateTemplate template;

	@PersistenceContext(unitName = "persistenceObus")
	@Qualifier("entityManagerFactory")
	private EntityManager entityManager;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public List<Obus> getObuses() {
		return getTemplate().loadAll(Obus.class);
	}

	public List<Obus> getObusData() {
		Query query = entityManager.createQuery("FROM Obus as obus ORDER BY obus.id ASC");

		return query.getResultList();
	}
}
