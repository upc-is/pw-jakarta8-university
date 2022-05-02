package pe.edu.upc.university.controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import pe.edu.upc.university.business.crud.StudentService;
import pe.edu.upc.university.model.entity.Career;
import pe.edu.upc.university.model.entity.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named("originalView")
@ViewScoped
public class OriginalView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Student> entities;
	private Student entitySelected;
	private List<Student> entitiesSelected;
	private Student entitySearch;
	
	@Inject
	private StudentService entityService;
	
	@PostConstruct
	public void init() {
		entitiesSelected = new ArrayList<>();
		entitySearch = new Student();
		getAllEntities();
	}
	
	public boolean hasEntitiesSelected() {
		if (entitiesSelected.isEmpty()) {
			return false;
		}
		return true;
	}
	public boolean hasEntitySelected() {
		if (entitiesSelected.size() == 1) {
			return true;
		}
		return false;
	}
	public void createNew() {
		entitySelected = new Student();		
		entitySelected.setCareer(new Career()); 
	}
	public void editEntitySelected() {
		entitySelected = entitiesSelected.get(0);
	}
	public void saveEntity() {
		try {
			if (entitySelected.getId() == null) {
				entityService.create(entitySelected);
				entities.add(entitySelected);
			} 
			else {
				entityService.update(entitySelected);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		PrimeFaces.current().executeScript("PF('entityDialog').hide()");
        PrimeFaces.current().ajax().update("entityDataTable");
	}
	public void deleteEntity() {
		try {
			this.entities.remove(entitySelected);
			entityService.deleteById(this.entitySelected.getId());
			this.entitySelected = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Remove", "Item Removed"));
		PrimeFaces.current().ajax().update("form:messages", "entityDataTable");
	}
	public void searchEntity() {
		try {	// MOdificar de acuerdo al Entity
			entities = entityService.search(entitySearch.getLastName());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	public void getAllEntities() {
		try {
			entities = entityService.getAll();
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
