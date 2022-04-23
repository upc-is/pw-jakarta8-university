package pe.edu.upc.university.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.university.model.entity.Career;
import pe.edu.upc.university.model.repository.CareerRepository;

@Named
@ApplicationScoped
public class CareerRepositoryImpl implements CareerRepository {

	@PersistenceContext(unitName = "universityPU")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	@Override
	public Optional<Career> findById(String id) throws Exception {
		return this.findById(id, Career.class);
	}

	@Override
	public List<Career> findAll() throws Exception {
		String jpql = "SELECT career FROM Career career";
		return this.findByQuery(Career.class, jpql);
	}

	@Override
	public List<Career> findByName(String name) throws Exception {
		String jpql = "SELECT career FROM Career career WHERE career.name = '" + name  + "'";
		return this.findByQuery(Career.class, jpql);
	}

}
