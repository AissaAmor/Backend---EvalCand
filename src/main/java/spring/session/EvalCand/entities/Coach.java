package spring.session.EvalCand.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coach {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id_coach;
	private String nom;
	private String prenom;
	private String Username;
	private String Password;
	private Evaluation evaluation;
	
	public Coach(int id_coach, String nom, String prenom, String username, String password, Evaluation evaluation) {
		super();
		Id_coach = id_coach;
		this.nom = nom;
		this.prenom = prenom;
		Username = username;
		Password = password;
		this.evaluation = evaluation;
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
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}

	@Override
	public String toString() {
		return "Coach [Id_coach=" + Id_coach + ", nom=" + nom + ", prenom=" + prenom + ", Username=" + Username
				+ ", Password=" + Password + ", evaluation=" + evaluation + "]";
	}
	
		
}
