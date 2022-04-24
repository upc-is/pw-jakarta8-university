package pe.edu.upc.university.business.crud.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.university.business.crud.CareerService;
import pe.edu.upc.university.model.entity.Career;
import pe.edu.upc.university.model.repository.CareerRepository;
import pe.edu.upc.university.model.repository.JpaRepository;

@Named
@ApplicationScoped
public class CareerServiceImpl implements CareerService {

	@Inject
	private CareerRepository careerRepository;
	
	@Override
	public JpaRepository<Career, String> getJpaRepository() {
		return this.careerRepository;
	}

	@Override
	public List<Career> findByName(String name) throws Exception {
		return this.careerRepository.findByName(name);
	}
}
