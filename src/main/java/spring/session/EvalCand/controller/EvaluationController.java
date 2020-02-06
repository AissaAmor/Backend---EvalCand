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
	QRService QRservice;

	
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public void AjoutEvaluation(@RequestBody Evaluation evaluation ) {

		evaluationService.AjoutEvaluation(evaluation);

		for(int i = 0; i < evaluation.getQr().size(); i++) {
			QR qr = evaluation.getQr().get(i);
			qr.setEvaluation(evaluation);
		}
		QRservice.AjoutlistQR(evaluation.getQr());
	}


	// Path http://localhost:9200/evaluation/update-evaluation
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
			QR qr = new QR(evaluation.getQr().get(i).getTitre(), evaluation.getQr().get(i).getQuestion(), evaluation.getQr().get(i).getRemarque(), evaluation.getQr().get(i).getReponse(), evaluation.getQr().get(i).getReponseCandidat())
					;
			qr.setEvaluation(newEvaluation);
			newListe.add(qr);
		}
		newEvaluation.setQr(newListe);
		evaluationService.duplicateEval(newEvaluation);
		
		QRservice.AjoutNewlistQR((newEvaluation.getQr()));
		
	}

//	@RequestMapping(path = "/duplicate2/{id}", method = RequestMethod.POST)
//	public void duplicateEval(@PathVariable("id") int evaluationId) {
//
//		// Récuperation d'une evaluation par id
//		Evaluation evaluation = evaluationService.getEvalById(evaluationId);
//
//		// Copie d'un objet
//		Evaluation evaluation2 = new Evaluation(evaluation);
//		evaluation2.setId_evaluation(0);
//
//		evaluationService.duplicateEval(evaluation2);
//	}
}