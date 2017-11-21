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
public class Gender {

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

	//usun
	@Override
	public String toString() {
		return "Gender [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
