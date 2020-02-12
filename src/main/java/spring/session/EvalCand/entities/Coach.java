package spring.session.EvalCand.entities;

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
	private String email;
	@NotNull
	private String username;
	private String password;

	
	public Coach() {
	}



	public Coach(int id_coach, String nom, String prenom, String email, @NotNull String username, String password) {
		super();
		Id_coach = id_coach;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.username = username;
		this.password = password;

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



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
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
		return "Coach [Id_coach=" + Id_coach + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
				+ ", username=" + username + ", password=" + password + "]";
	}
}
