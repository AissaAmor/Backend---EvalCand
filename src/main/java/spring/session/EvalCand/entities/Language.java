package spring.session.EvalCand.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id_Language;
	private String Titre;
	private String enonce;
	private String reponse;
	private String ReponseCandidat;
	@ManyToOne
	private Evaluation evaluation;
	
	
	public Evaluation getEvaluation() {
		return evaluation;
	}


	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}


	public Language(int id_Language, String titre, String enonce, String reponse, String reponseCandidat,
			Evaluation evaluation) {
		super();
		Id_Language = id_Language;
		Titre = titre;
		this.enonce = enonce;
		this.reponse = reponse;
		ReponseCandidat = reponseCandidat;
		this.evaluation = evaluation;
	}


	public String getReponseCandidat() {
		return ReponseCandidat;
	}


	public void setReponseCandidat(String reponseCandidat) {
		ReponseCandidat = reponseCandidat;
	}


	public int getId_Language() {
		return Id_Language;
	}


	public void setId_Language(int id_Language) {
		Id_Language = id_Language;
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


	public String getReponse() {
		return reponse;
	}


	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	

	@Override
	public String toString() {
		return "Language [Id_Language=" + Id_Language + ", Titre=" + Titre + ", enonce=" + enonce + ", reponse="
				+ reponse + ", ReponseCandidat=" + ReponseCandidat + ", evaluation=" + evaluation + "]";
	}
		
	
}
