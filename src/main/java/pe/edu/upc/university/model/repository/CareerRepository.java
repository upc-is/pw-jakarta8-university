package pe.edu.upc.university.model.repository;

import java.util.List;

import pe.edu.upc.university.model.entity.Career;

public interface CareerRepository extends JpaRepository<Career, String> {
	List<Career> findByName(String name) throws Exception;
}
