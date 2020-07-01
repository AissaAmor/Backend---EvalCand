package spring.session.EvalCand.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int idQuiz;
	private String Titre;
	private String question;
	private String listChoice;
	private String reponse;
	private String reponseCandidat;
	@ManyToOne
	  @JsonIgnore
	private Evaluation evaluation;




	public Quiz(String titre, String question, String listChoice, String reponse, String reponseCandidat) {
		super();
		Titre = titre;
		this.question = question;
		this.listChoice = listChoice;
		this.reponse = reponse;
		this.reponseCandidat = reponseCandidat;
		
	}

	public Quiz() {
		super();
	}

	public Quiz(int idQuiz, String titre, String question, String reponse, String reponseCandidat,
			Evaluation evaluation,List<Quiz> listQuiz) {
		super();
		this.idQuiz = idQuiz;
		Titre = titre;
		this.question = question;
		this.reponse = reponse;
		this.reponseCandidat = reponseCandidat;
		this.evaluation = evaluation;
	}
	

	public Quiz(int idQuiz, String titre, String question, ArrayList<String> listchoice, String reponse,
			String reponseCandidat, Evaluation evaluation) {
		super();
		this.idQuiz = idQuiz;
		Titre = titre;
		this.question = question;
		//this.listchoice = listchoice;
		this.reponse = reponse;
		this.reponseCandidat = reponseCandidat;
		this.evaluation = evaluation;
	}

	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}

	

	public int getIdQuiz() {
		return idQuiz;
	}

	public void setIdQuiz(int idQuiz) {
		this.idQuiz = idQuiz;
	}

	public String getTitre() {
		return Titre;
	}

	public void setTitre(String titre) {
		Titre = titre;
	}

	

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public String getReponseCandidat() {
		return reponseCandidat;
	}

	public void setReponseCandidat(String reponseCandidat) {
		this.reponseCandidat = reponseCandidat;
	}

//	public ArrayList<String> getListchoice() {
//		return listchoice;
//	}
//
//	public void setListchoice(ArrayList<String> listchoice) {
//		this.listchoice = listchoice;
//	}

	
	@Override
	public String toString() {
		return "Quiz [idQuiz=" + idQuiz + ", Titre=" + Titre + ", question=" + question
				+ ", reponse=" + reponse + ", reponseCandidat=" + reponseCandidat + ", evaluation=" + evaluation + "]";
	}

	public String getListChoice() {
		return listChoice;
	}

	public void setListChoice(String listChoice) {
		this.listChoice = listChoice;
	}



}
