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
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Id_evaluation")
	private int Id_evaluation;
	
	
	public Language(int id_Language, String titre, String enonce, String reponse, String reponseCandidat,
			int id_evaluation) {
		super();
		Id_Language = id_Language;
		Titre = titre;
		this.enonce = enonce;
		this.reponse = reponse;
		ReponseCandidat = reponseCandidat;
		Id_evaluation = id_evaluation;
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


	public String getReponseCandidat() {
		return ReponseCandidat;
	}


	public void setReponseCandidat(String reponseCandidat) {
		ReponseCandidat = reponseCandidat;
	}


	public int getId_evaluation() {
		return Id_evaluation;
	}


	public void setId_evaluation(int id_evaluation) {
		Id_evaluation = id_evaluation;
	}


	@Override
	public String toString() {
		return "Language [Id_Language=" + Id_Language + ", Titre=" + Titre + ", enonce=" + enonce + ", reponse="
				+ reponse + ", ReponseCandidat=" + ReponseCandidat + ", Id_evaluation=" + Id_evaluation + "]";
	}
	
	
}
