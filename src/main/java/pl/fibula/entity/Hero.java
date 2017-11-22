package pl.fibula.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Hero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;
	
	@NotBlank
	@Column(nullable = false, unique = true)
	private String name;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "gender_id")
	private Gender gender;
		
	@OneToOne
	@JoinColumn(name = "profession_id")
	private Profession profession;
	
	@NotNull
	@Column(nullable = false)
	private int level = 1;
	
	@NotNull
	@Column(nullable = false)
	private int swordFighting = 10;
	
	@NotNull
	@Column(nullable = false)
	private int axeFighting = 10;
	
	@NotNull
	@Column(nullable = false)
	private int spellCasting = 1;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Profession getProfession() {
		return profession;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getSwordFighting() {
		return swordFighting;
	}

	public void setSwordFighting(int swordFighting) {
		this.swordFighting = swordFighting;
	}

	public int getAxeFighting() {
		return axeFighting;
	}

	public void setAxeFighting(int axeFighting) {
		this.axeFighting = axeFighting;
	}

	public int getSpellCasting() {
		return spellCasting;
	}

	public void setSpellCasting(int spellCasting) {
		this.spellCasting = spellCasting;
	}

	@Override
	public String toString() {
		return "Hero [id=" + id + ", name=" + name + ", gender=" + gender + ", profession=" + profession + ", level="
				+ level + ", swordFighting=" + swordFighting + ", axeFighting=" + axeFighting + ", spellCasting="
				+ spellCasting + "]";
	}

}