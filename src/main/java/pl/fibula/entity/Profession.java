package pl.fibula.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Profession {
	
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Getter
	@Setter
	@NotNull
	@Column(nullable = false, unique = true)
	private String name;
	
	public Profession(String name) {
		this.name = name;
	}
	
	public Profession() {
		
	}

	//usun
	@Override
	public String toString() {
		return "Profession [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
