package spring.session.EvalCand.controller;

import java.util.List;

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
import spring.session.EvalCand.entities.Projet;
import spring.session.EvalCand.repositories.ProjetRepository;
import spring.session.EvalCand.services.EvaluationService;
import spring.session.EvalCand.services.ProjetService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/projet")
public class ProjetController {

	@Autowired
	ProjetRepository projetrepository;

	@Autowired
	ProjetService projetservice;

	@Autowired
	EvaluationService evaluationService;

	@RequestMapping(path = "/addProject", method = RequestMethod.POST)
	public void AjoutEvaluation(@RequestBody Evaluation evaluation) {

		evaluationService.AjoutEvaluation(evaluation);

		for (int i = 0; i < evaluation.getProjet().size(); i++) {
			Projet projet = evaluation.getProjet().get(i);
			projet.setEvaluation(evaluation);
		}
		projetservice.ajoutListProjet(evaluation.getProjet());
	}

	@PutMapping("/updateProjet")
	@ResponseBody
	ResponseEntity<?> updateEvaluation(@RequestBody Evaluation newEvaluation) {

		for (int i = 0; i < newEvaluation.getProjet().size(); i++) {
			Projet projet = newEvaluation.getProjet().get(i);
			projet.setEvaluation(newEvaluation);
		}
		projetservice.ajoutListProjet(newEvaluation.getProjet());
		return new ResponseEntity<>("update done", HttpStatus.ACCEPTED);
	}

	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public List<Projet> getAll() {
		return projetservice.getAll();
	}

}
