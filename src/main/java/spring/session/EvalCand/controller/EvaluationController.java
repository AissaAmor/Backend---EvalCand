package spring.session.EvalCand.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import spring.session.EvalCand.entities.Evaluation;
import spring.session.EvalCand.services.EvaluationService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/evaluation")
public class EvaluationController {

	@Autowired
	EvaluationService evaluationService;

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public void AjoutEvaluation(@RequestBody Evaluation evaluation) {
		evaluationService.AjoutEvaluation(evaluation);
	}

	// Path http://localhost:9200/evaluation/update-evaluation
	@PutMapping("/update-evaluation")
	@ResponseBody ResponseEntity<?> updateEvaluation(@RequestBody Evaluation newEvaluation) {
		evaluationService.updateEvaluation(newEvaluation);
		return new ResponseEntity<>("update done", HttpStatus.ACCEPTED);
	}
}