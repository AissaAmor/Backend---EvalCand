package spring.session.EvalCand.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import spring.session.EvalCand.entities.Candidat;
import spring.session.EvalCand.entities.Evaluation;
import spring.session.EvalCand.entities.QR;
import spring.session.EvalCand.services.EvaluationService;
import spring.session.EvalCand.services.QRService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/evaluation")
public class EvaluationController {

	@Autowired
	EvaluationService evaluationService;

	@Autowired
	QRService qrservice;
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public void AjoutEvaluation(@RequestBody Evaluation evaluation) {

		evaluationService.AjoutEvaluation(evaluation);

		for(int i = 0; i < evaluation.getQr().size(); i++) {
			QR qr = evaluation.getQr().get(i);
			qr.setEvaluation(evaluation);
		}
		qrservice.AjoutlistQR(evaluation.getQr());
	}
	
	
	// Path htt p://localhost:9200/evaluation/update-evaluation
	
	
	@PutMapping("/update-evaluation")
	@ResponseBody
	ResponseEntity<?> updateEvaluation(@RequestBody Evaluation newEvaluation) {
		evaluationService.updateEvaluation(newEvaluation);
		return new ResponseEntity<>("update done", HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteEvaluation(@PathVariable("id") Integer id) {
		Evaluation evaluation = evaluationService.getEvalById(id);
		evaluationService.deleteEvaluation(evaluation);
	}

	
	
	@RequestMapping(path = "/duplicate", method = RequestMethod.POST)
	public void duplicateEval(@RequestBody Evaluation evaluation) { 
		
		Evaluation newEvaluation = new Evaluation(evaluation.getTitre(), evaluation.getEtat(),evaluation.getDuree(), evaluation.getQr());
		List<QR> newListe = new ArrayList<QR>();
		for(int i = 0; i < newEvaluation.getQr().size(); i++) {
			QR qr = new QR(evaluation.getQr().get(i).getTitre(), evaluation.getQr().get(i).getQuestion(), evaluation.getQr().get(i).getRemarque(), evaluation.getQr().get(i).getReponse(), evaluation.getQr().get(i).getReponseCandidat());
			qr.setEvaluation(newEvaluation);
			newListe.add(qr);
		}
		newEvaluation.setQr(newListe);
		evaluationService.duplicateEval(newEvaluation);
		
		qrservice.AjoutNewlistQR((newEvaluation.getQr()));
		
	}
	
	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public List<Evaluation> getAll() {
		return evaluationService.getAll();

	}
	@RequestMapping(path="/getEval/{id}", method = RequestMethod.GET)
	public Evaluation getEvaluation(@PathVariable("id") Integer id) {
		System.out.println(id);
		return evaluationService.getEvalById(id);
	}
}