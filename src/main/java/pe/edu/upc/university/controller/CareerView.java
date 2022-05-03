package pe.edu.upc.university.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.university.business.crud.CareerService;
import pe.edu.upc.university.business.crud.CrudService;
import pe.edu.upc.university.model.entity.Career;


@Named("careerView")
@ViewScoped
public class CareerView implements Serializable, EntityView<Career, String> {

	private static final long serialVersionUID = 1L;

	private List<Career> entities;
	private Career entitySelected;
	private List<Career> entitiesSelected;
	private Career entitySearch;
	
	@Inject
	private CareerService entityService;
	
	@PostConstruct
	public void init() {
		this.entitiesSelected = new ArrayList<>();
		this.entitySearch = new Career();
		getAllEntities();
	}
	
	@Override
	public CrudService<Career, String> getCrudService() {
		return this.entityService;
	}

	@Override
	public void createNew() {
		this.entitySelected = new Career();		
	}

	@Override
	public String getIdFromEntitySelected() {
		return this.entitySelected.getId();
	}

	@Override
	public void searchEntity() {
		try {	// Modificar de acuerdo al atributo a buscar
			this.entities = this.entityService.search(this.entitySearch.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Career> getEntities() {
		return entities;
	}

	public void setEntities(List<Career> entities) {
		this.entities = entities;
	}

	public Career getEntitySelected() {
		return entitySelected;
	}

	public void setEntitySelected(Career entitySelected) {
		this.entitySelected = entitySelected;
	}

	public List<Career> getEntitiesSelected() {
		return entitiesSelected;
	}

	public void setEntitiesSelected(List<Career> entitiesSelected) {
		this.entitiesSelected = entitiesSelected;
	}

	public Career getEntitySearch() {
		return entitySearch;
	}

	public void setEntitySearch(Career entitySearch) {
		this.entitySearch = entitySearch;
	}

	public CareerService getEntityService() {
		return entityService;
	}

	public void setEntityService(CareerService entityService) {
		this.entityService = entityService;
	}

}
