package pe.edu.upc.university.controller;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.university.business.crud.CrudService;
import pe.edu.upc.university.business.crud.StudentService;
import pe.edu.upc.university.model.entity.Career;
import pe.edu.upc.university.model.entity.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named("studentView")
@ViewScoped
public class StudentView implements Serializable, EntityView<Student, Integer> {

	private static final long serialVersionUID = 1L;
	
	private List<Student> entities;
	private Student entitySelected;
	private List<Student> entitiesSelected;
	private Student entitySearch;
	
	@Inject
	private StudentService entityService;
	
	@PostConstruct
	public void init() {
		this.entitiesSelected = new ArrayList<>();
		this.entitySearch = new Student();
		getAllEntities();
	}
	
	@Override
	public CrudService<Student, Integer> getCrudService() {
		return this.entityService;
	}

	@Override
	public void createNew() {
		this.entitySelected = new Student();		
		this.entitySelected.setCareer(new Career());
	}

	@Override
	public Integer getIdFromEntitySelected() {
		return this.entitySelected.getId();
	}

	public void searchEntity() {
		try {	// Modificar de acuerdo al atributo a buscar
			this.entities = this.entityService.search(this.entitySearch.getLastName());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public List<Student> getEntities() {
		return entities;
	}

	public void setEntities(List<Student> entities) {
		this.entities = entities;
	}

	public Student getEntitySelected() {
		return entitySelected;
	}

	public void setEntitySelected(Student entitySelected) {
		this.entitySelected = entitySelected;
	}

	public List<Student> getEntitiesSelected() {
		return entitiesSelected;
	}

	public void setEntitiesSelected(List<Student> entitiesSelected) {
		this.entitiesSelected = entitiesSelected;
	}

	public Student getEntitySearch() {
		return entitySearch;
	}

	public void setEntitySearch(Student entitySearch) {
		this.entitySearch = entitySearch;
	}

	public StudentService getEntityService() {
		return entityService;
	}

	public void setEntityService(StudentService entityService) {
		this.entityService = entityService;
	}
	
		
	
}
