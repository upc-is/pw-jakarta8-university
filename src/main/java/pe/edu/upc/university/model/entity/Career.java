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
	
}

