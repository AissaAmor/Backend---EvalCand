package spring.session.EvalCand.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;



@Entity
//@JsonIgnoreType
@JsonIgnoreProperties({ "id" })
public class Evaluation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	  @JsonIgnore
	private int Id_evaluation;

	private String Titre;
	private String Etat;
	private int Duree;
	 @JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Id_Candidat")
	private Candidat candidat;

	@OneToMany(mappedBy = "evaluation", cascade = { CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.REFRESH,
			CascadeType.MERGE, CascadeType.DETACH })
	private List<QR> qr;

	@OneToMany(mappedBy = "evaluation", cascade = { CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.REFRESH,
			CascadeType.MERGE, CascadeType.DETACH })
	private List<Projet> projet;

	@OneToMany(mappedBy = "evaluation", cascade = { CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.REFRESH,
			CascadeType.MERGE, CascadeType.DETACH })
	private List<Quiz> quiz;

//	@OneToMany(mappedBy = "evaluation", cascade = { CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.REFRESH,
//			CascadeType.MERGE, CascadeType.DETACH })
//	private List<Quiz> quiz;

	// Default constructor
	// --> Always define a default constructor for any entity
	public Evaluation() {
		super();
	}



	public Evaluation(int id_evaluation, String titre, String etat, int duree, Candidat candidat, List<QR> qr,
			List<Projet> projet, List<Quiz> quiz) {
		super();
		Id_evaluation = id_evaluation;
		Titre = titre;
		Etat = etat;
		Duree = duree;
		this.candidat = candidat;
		this.qr = qr;
		this.projet = projet;
		this.quiz = quiz;
	}
	public Evaluation(int id_evaluation, String titre, String etat, int duree, Candidat candidat, List<QR> qr,
			List<Projet> projet, List<Quiz> quiz, Candidat cand) {
		super();
		Id_evaluation = id_evaluation;
		Titre = titre;
		Etat = etat;
		Duree = duree;
		this.candidat = candidat;
		this.qr = qr;
		this.projet = projet;
		this.quiz = quiz;
		this.candidat = cand;
	}


	public Evaluation(String titre, String etat, int duree, List<QR> qr) {
		super();
		Titre = titre;
		Etat = etat;
		Duree = duree;
		this.qr = qr;
	}
	public Evaluation(String titre, String etat, int duree, List<Quiz> quiz,  Candidat candidat) {
		super();
		Titre = titre;
		Etat = etat;
		Duree = duree;
		this.quiz = quiz;
		this.candidat = candidat;
	}
	

	public Evaluation( List<QR> qr) {
		super();
		
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



	public Candidat getCandidat() {
		return candidat;
	}



	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}



	public List<QR> getQr() {
		return qr;
	}



	public void setQr(List<QR> qr) {
		this.qr = qr;
	}



	public List<Projet> getProjet() {
		return projet;
	}



	public void setProjet(List<Projet> projet) {
		this.projet = projet;
	}



	public List<Quiz> getQuiz() {
		return quiz;
	}



	public void setQuiz(List<Quiz> quiz) {
		this.quiz = quiz;
	}



	@Override
	public String toString() {
		return "Evaluation [Id_evaluation=" + Id_evaluation + ", Titre=" + Titre + ", Etat=" + Etat + ", Duree=" + Duree
				+ ", qr=" + qr + ", projet=" + projet + ", quiz=" + quiz + " ]";
	}

	public void AjoutEvaluation(String string, Evaluation evaluation) {

	}

//	public void put(String string, Evaluation evalById) {
//	
//		return   ;
//	}

}
