package pl.fibula.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import lombok.Getter;
import lombok.Setter;

@Entity
public class User {

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Getter
	@Setter
	@NotNull
	@Column(nullable = false)
	private String login;
	
	@Getter
	@Setter
	@NotNull
	@Column(nullable = false)
	private String password;
	
	@Getter
	@Setter
	@NotNull
	@Column(nullable = false)
	@Email
	private String email;
	
	@Getter
	@Setter
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List <Hero> heroes = new ArrayList<>();

	//usun
	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + ", email=" + email + ", heroes="
				+ heroes + "]";
	}
	
	
	
}
