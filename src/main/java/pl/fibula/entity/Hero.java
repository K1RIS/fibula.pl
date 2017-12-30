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
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Hero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private java.time.LocalDate created;
	
	private boolean onLine;
	
	@NotBlank
	@Column(nullable = false, unique = true)
	@Size(min = 5, max = 15)
	private String name;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "id_world")
	private World world;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "id_gender")
	private Gender gender;
	
	//@NotNull
	@OneToOne
	@JoinColumn(name = "id_profession")
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

	public java.time.LocalDate getCreated() {
		return created;
	}

	public void setCreated(java.time.LocalDate created) {
		this.created = created;
	}

	public boolean isOnLine() {
		return onLine;
	}

	public void setOnLine(boolean onLine) {
		this.onLine = onLine;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	
	
}
