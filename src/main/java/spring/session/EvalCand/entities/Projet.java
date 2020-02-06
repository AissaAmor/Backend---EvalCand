package spring.session.EvalCand.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Projet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id_QR;
	private String Titre;
	private String enonce;
	private String lienGit;
	@ManyToOne
	private Evaluation evaluation;
	
	
	public Projet(int id_QR, String titre, String enonce, String lienGit, Evaluation evaluation) {
		super();
		Id_QR = id_QR;
		Titre = titre;
		this.enonce = enonce;
		this.lienGit = lienGit;
		this.evaluation = evaluation;
	}


	public Evaluation getEvaluation() {
		return evaluation;
	}


	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}


	public int getId_QR() {
		return Id_QR;
	}



	public void setId_QR(int id_QR) {
		Id_QR = id_QR;
	}



	public String getTitre() {
		return Titre;
	}



	public void setTitre(String titre) {
		Titre = titre;
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
		return "Projet [Id_QR=" + Id_QR + ", Titre=" + Titre + ", enonce=" + enonce + ", lienGit=" + lienGit
				+ ", evaluation=" + evaluation + "]";
	}

	
}
