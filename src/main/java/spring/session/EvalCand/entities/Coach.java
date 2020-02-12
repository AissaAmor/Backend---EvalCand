package spring.session.EvalCand.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import spring.session.EvalCand.configuration.BCryptManagerUtil;

@Entity
public class Coach {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id_coach;
	private String nom;
	private String prenom;
	@NotNull
	private String username;
	private String password;

	// Default constructor
	// --> Always define a default constructor for any entity
	public Coach() {
		super();
	}

	public Coach(int id_coach, String nom, String prenom, String username, String password, Evaluation evaluation,
			List<Coach> listCoach) {
		super();
		Id_coach = id_coach;
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.password = password;

		// ListCoach = listCoach;
	}

	public int getId_coach() {
		return Id_coach;
	}

	public void setId_coach(int id_coach) {
		Id_coach = id_coach;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = BCryptManagerUtil.passwordEncoder().encode(password);
	}

	@Override
	public String toString() {
		return "Coach [Id_coach=" + Id_coach + ", nom=" + nom + ", prenom=" + prenom + ", username=" + username
				+ ", password=" + password + "]";
	}

}
