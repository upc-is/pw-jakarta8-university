package pe.edu.upc.university.model.repository;

import java.util.List;

import pe.edu.upc.university.model.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	List<Student> findByLastNameAndFirstName(String lastName, String firstName) throws Exception;
}
