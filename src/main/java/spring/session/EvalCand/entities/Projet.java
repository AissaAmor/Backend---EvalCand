
package spring.session.EvalCand.entities;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Projet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id_Projet;
	private String Titre;
	private String enonce;
	private String lienGit;
	  @JsonIgnore
	  @ManyToOne
	private Evaluation evaluation;
	
	
	public Projet() {
		super();
		
	}


	public Projet(int id_Projet, String titre, String enonce, String lienGit) {
	super();
	Id_Projet = id_Projet;
	Titre = titre;
	this.enonce = enonce;
	this.lienGit = lienGit;
}


	public Evaluation getEvaluation() {
		return evaluation;
	}


	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}



	public String getTitre() {
		return Titre;
	}


	public void setTitre(String titre) {
		Titre = titre;
	}

	public int getId_Projet() {
		return Id_Projet;
	}


	public void setId_Projet(int id_Projet) {
		Id_Projet = id_Projet;
	}





	public String getEnonce() {
		return enonce;
	}



	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}

	public String getLienGit() {
		return lienGit;
	}

	public void setLienGit(String lienGit) {
		this.lienGit = lienGit;
	}


	@Override
	public String toString() {
		return "Projet [Id_Projet=" + Id_Projet + ", Titre=" + Titre + ", enonce=" + enonce + ", lienGit=" + lienGit
				+ ", evaluation=" + evaluation + "]";
	}


		
	
}

