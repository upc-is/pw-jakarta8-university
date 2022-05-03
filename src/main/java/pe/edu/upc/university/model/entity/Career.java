package pe.edu.upc.university.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "career", indexes = {@Index(columnList = "name", name = "career_index_name")})
public class Career {
	@Id
	@Column(name = "id", length = 3)
	private String id;
	
	@Column(name = "name", length = 100, nullable = false)
	private String name;
	
	@Column(name = "facultad", length = 100, nullable = false)
	private String facultad;
	
	@Column(name = "tiempo", nullable = false)
	private int tiempo;
	
	@Column(name = "price", nullable = false)
	private float price;
	
	@OneToMany(mappedBy = "career")
	private List<Student> students;
	
	public Career() {
		students = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public String getFacultad() {
		return facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
}

