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

import lombok.Getter;
import lombok.Setter;

@Entity
public class Hero {

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;
	
	@Getter
	@Setter
	@NotNull
	@Column(nullable = false, unique = true)
	private String name;
	
	@Getter
	@Setter
	@OneToOne
	@JoinColumn(name = "gender_id")
	private Gender gender;
	
	@Getter
	@Setter
	@OneToOne
	@JoinColumn(name = "profession_id")
	private Profession profession = new Profession("no profession");
	
	@Getter
	@Setter
	@NotNull
	@Column(nullable = false)
	private int level = 1;
	
	@Getter
	@Setter
	@NotNull
	@Column(nullable = false)
	private int swordFighting = 10;
	
	@Getter
	@Setter
	@NotNull
	@Column(nullable = false)
	private int axeFighting = 10;
	
	@Getter
	@Setter
	@NotNull
	@Column(nullable = false)
	private int spellCasting = 1;

	//usun
	@Override
	public String toString() {
		return "Hero [id=" + id + ", name=" + name + ", gender=" + gender + ", profession="
				+ profession + ", level=" + level + ", swordFighting=" + swordFighting + ", axeFighting=" + axeFighting
				+ ", spellCasting=" + spellCasting + "]";
	}
	
	
}
