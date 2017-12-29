package pl.fibula.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private java.time.LocalDate created = LocalDate.now();
	
	private java.time.LocalDate lastLogin;
	
	@NotBlank
	@Column(nullable = false, unique = true)
	private String name;

	@NotBlank
	@Column(nullable = false)
	private String password;

	@NotBlank
	@Column(nullable = false, unique = true)
	@Email
	private String email;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List <Hero> heroes = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Hero> getHeroes() {
		return heroes;
	}

	public void setHeroes(List<Hero> heroes) {
		this.heroes = heroes;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", heroes="
				+ heroes + "]";
	}

	public java.time.LocalDate getCreated() {
		return created;
	}

	public void setCreated(java.time.LocalDate created) {
		this.created = created;
	}

	public java.time.LocalDate getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(java.time.LocalDate lastLogin) {
		this.lastLogin = lastLogin;
	}

}
