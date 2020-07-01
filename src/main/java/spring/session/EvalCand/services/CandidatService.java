package spring.session.EvalCand.services;

import java.util.List;

import spring.session.EvalCand.entities.Candidat;
import spring.session.EvalCand.entities.Coach;
import spring.session.EvalCand.entities.Evaluation;
import spring.session.EvalCand.entities.Quiz;


public interface CandidatService {
	
	public void AjoutCandidat(Candidat candidat);
	public void deleteCandidat(Candidat candidat);
	public List<Candidat> getAll();	
//    public void validateEval (Evaluation evaluation);
	public  Candidat getCandidatById(Integer id);
	public void updateCandidat(Candidat candidat);
   
 
}