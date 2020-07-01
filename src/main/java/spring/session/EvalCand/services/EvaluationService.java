package spring.session.EvalCand.services;

import java.util.List;


import spring.session.EvalCand.entities.Evaluation;

public interface EvaluationService {

	public void AjoutEvaluation(Evaluation evaluation);

	public void deleteEvaluation(Evaluation evaluation);

	public void updateEvaluation(Evaluation evaluation);

	public void duplicateEval(Evaluation evaluation);
	public void ajoutRep(Evaluation evaluation);

	public Evaluation getEvalById(Integer id);
	
	public Evaluation getreponseById(Integer id);
	

	public void editEvaluation(Evaluation evaluation);

	public void saveAll(Evaluation evaluation);

	List<Evaluation> getAll();

	List<Evaluation> editEvaluation();

	public void AnswerEval(Evaluation newEvaluation);

//	public void UpdateReponse(Evaluation evaluationRep);

}
