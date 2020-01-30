package spring.session.EvalCand.services;


import java.util.List;

import spring.session.EvalCand.entities.Evaluation;



public interface EvaluationService {
	
	public void AjoutEvaluation (Evaluation evaluation);
	public void deleteEvaluation (Evaluation evaluation);
	public void updateEvaluation (Evaluation evaluation);
	public Evaluation getEvalById(Integer id);
	List<Evaluation> getAll();
}
