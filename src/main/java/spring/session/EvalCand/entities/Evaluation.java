package spring.session.EvalCand.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Evaluation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id_evaluation;
		
	private String Titre;
	private String Etat;
	private int Duree;
	private Coach coach;
	private QR QR;
	private Language language;
	private Projet projet;
	private Codage codage;
	
			
	public Evaluation(int id_evaluation, String titre, String etat, int duree, Coach coach,
			spring.session.EvalCand.entities.QR qR, Language language, Projet projet, Codage codage) {
		super();
		Id_evaluation = id_evaluation;
		Titre = titre;
		Etat = etat;
		Duree = duree;
		this.coach = coach;
		QR = qR;
		this.language = language;
		this.projet = projet;
		this.codage = codage;
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

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	public QR getQR() {
		return QR;
	}

	public void setQR(QR qR) {
		QR = qR;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public Codage getCodage() {
		return codage;
	}

	public void setCodage(Codage codage) {
		this.codage = codage;
	}

	@Override
	public String toString() {
		return "Evaluation [Id_evaluation=" + Id_evaluation + ", Titre=" + Titre + ", Etat=" + Etat + ", Duree=" + Duree
				+ ", coach=" + coach + ", QR=" + QR + ", language=" + language + ", projet=" + projet + ", codage="
				+ codage + "]";
	}

		
	
}
