package spring.session.EvalCand.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;




@Entity
public class Evaluation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id_evaluation;
		
	private String Titre;
	private String Etat;
	private int Duree;
	
	
	@OneToMany(mappedBy = "evaluation" , cascade = CascadeType.ALL)
	private List<QR> qr;
	
	@OneToMany( mappedBy = "evaluation" , cascade = CascadeType.ALL)
	private List<Projet> projet;
	
	@OneToMany( mappedBy = "evaluation" , cascade = CascadeType.ALL)
	private List<Codage> codage;

	@OneToMany( mappedBy = "evaluation" , cascade = CascadeType.ALL)
	private List<Language> language;
	
	
	public List<Projet> getProjet() {
		return projet;
	}



	public void setProjet(List<Projet> projet) {
		this.projet = projet;
	}



	public List<Codage> getCodage() {
		return codage;
	}



	public void setCodage(List<Codage> codage) {
		this.codage = codage;
	}



	public List<Language> getLanguage() {
		return language;
	}



	public void setLanguage(List<Language> language) {
		this.language = language;
	}



	public Evaluation(int id_evaluation, String titre, String etat, int duree, List<QR> qr, List<Projet> projet,
			List<Codage> codage, List<Language> language) {
		super();
		Id_evaluation = id_evaluation;
		Titre = titre;
		Etat = etat;
		Duree = duree;
		this.qr = qr;
		this.projet = projet;
		this.codage = codage;
		this.language = language;
	}



	public List<QR> getQr() {
		return qr;
	}



	public void setQr(List<QR> qr) {
		this.qr = qr;
	}

	public int getId_evaluation() {
		return Id_evaluation;
	}

	public void setId_evaluation(int id_evaluation) {
		Id_evaluation = id_evaluation;
	}

	public String getTitre() {
		return Titre;
	}

	public void setTitre(String titre) {
		Titre = titre;
	}

	public String getEtat() {
		return Etat;
	}

	public void setEtat(String etat) {
		Etat = etat;
	}

	public int getDuree() {
		return Duree;
	}

	public void setDuree(int duree) {
		Duree = duree;
	}



	@Override
	public String toString() {
		return "Evaluation [Id_evaluation=" + Id_evaluation + ", Titre=" + Titre + ", Etat=" + Etat + ", Duree=" + Duree
				+ ", qr=" + qr + ", projet=" + projet + ", codage=" + codage + ", language=" + language + "]";
	}

	

	
	
}
