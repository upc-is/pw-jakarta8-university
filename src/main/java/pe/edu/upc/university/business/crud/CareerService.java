package pe.edu.upc.university.business.crud;

import java.util.List;

import pe.edu.upc.university.model.entity.Career;

public interface CareerService extends CrudService<Career, String> {
	List<Career> findByName(String name) throws Exception;
}
