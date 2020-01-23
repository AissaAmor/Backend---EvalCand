package spring.session.EvalCand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.session.EvalCand.entities.Evaluation;
import spring.session.EvalCand.repositories.EvaluationRepository;
import spring.session.EvalCand.services.EvaluationService;


public class EvaluationController {
	@Autowired
	EvaluationRepository Evaluationrepository ;

	@Autowired
	EvaluationService Evaluationservice;

	
	
	@RequestMapping(path = "add", method = RequestMethod.POST)
	public void addCoach(@RequestBody Evaluation evaluation) {
		Evaluationservice.AjoutEvaluation(evaluation);
	}
	
}
