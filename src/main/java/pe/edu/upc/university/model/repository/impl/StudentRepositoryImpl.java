package pe.edu.upc.university.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.university.model.entity.Student;
import pe.edu.upc.university.model.repository.StudentRepository;

@Named // StudentRepositoryImpl studentRepositoryImpl = new StudentRepositoryImpl();
@ApplicationScoped
public class StudentRepositoryImpl implements StudentRepository {

	@PersistenceContext(unitName = "universityPU")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	@Override
	public Optional<Student> findById(Integer id) throws Exception {
		return this.findById(id, Student.class);
	}

	@Override
	public List<Student> findAll() throws Exception {
		String jpql = "SELECT student FROM Student student";
		return this.findByQuery(Student.class, jpql);
	}

	@Override
	public List<Student> findByLastNameAndFirstName(String lastName, String firstName) throws Exception {
		String jpql = "SELECT student FROM Student student WHERE student.lastName = '" + lastName + "' and student.firstName = '" + firstName + "'";
		return this.findByQuery(Student.class, jpql);
	}

	@Override
	public List<Student> findByData(String data) throws Exception {
		String jpql = "SELECT student FROM Student student WHERE student.lastName LIKE '%" + data + "%'";
		return this.findByQuery(Student.class, jpql);
	}

}
