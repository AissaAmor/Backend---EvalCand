package spring.session.EvalCand.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Candidat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id_Candidat;
	private String Email;
	private int niveau;
	private String nom;
	private String prenom;
	
	
	public Candidat(int id_Candidat, String email, int niveau, String nom, String prenom) {
		super();
		Id_Candidat = id_Candidat;
		Email = email;
		this.niveau = niveau;
		this.nom = nom;
		this.prenom = prenom;
	}


	public Candidat() {
		super();
	}


	public int getId_Candidat() {
		return Id_Candidat;
	}


	public void setId_Candidat(int id_Candidat) {
		Id_Candidat = id_Candidat;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public int getNiveau() {
		return niveau;
	}


	public void setNiveau(int niveau) {
		this.niveau = niveau;
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


	@Override
	public String toString() {
		return "Candidat [Id_Candidat=" + Id_Candidat + ", Email=" + Email + ", niveau=" + niveau + ", nom=" + nom
				+ ", prenom=" + prenom + "]";
	}
	
		
}
