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
import spring.session.EvalCand.entities.Quiz;
import spring.session.EvalCand.repositories.EvaluationRepository;
import spring.session.EvalCand.services.CandidatService;
import spring.session.EvalCand.services.CoachService;
import spring.session.EvalCand.services.EvaluationService;

import spring.session.EvalCand.services.QRService;
import spring.session.EvalCand.services.QuizService;

//import spring.session.EvalCand.entities.Evaluation;
//import spring.session.EvalCand.entities.QR;
//import spring.session.EvalCand.services.EvaluationService;
//import spring.session.EvalCand.services.QRService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/evaluation")
public class EvaluationController {

	@Autowired
	EvaluationRepository evaluationrepository;

	@Autowired

	EvaluationService evaluationService;

	@Autowired

	QRService QRservice;
	@Autowired
	QuizService quizService;

	@Autowired
	CoachService Coachservice;

	@Autowired
	CandidatService Candidatservice;

//	@RequestMapping(path = "/add", method = RequestMethod.POST)
//	public void AjoutEvaluation(@RequestBody Evaluation evaluation ) {
//
//		evaluationService.AjoutEvaluation(evaluation);
//
//		for(int i = 0; i < evaluation.getQr().size(); i++) {
//			QR qr = evaluation.getQr().get(i);
//			qr.setEvaluation(evaluation);
//		}
//		QRservice.AjoutlistQR(evaluation.getQr());
//	}

	// Path htt p://localhost:9200/evaluation/update-evaluation

//	@RequestMapping(path = "/update-evaluation", method = RequestMethod.POST)

	@PutMapping("/update-evaluation")
	@ResponseBody
	ResponseEntity<?> updateEvaluation(@RequestBody Evaluation newEvaluation) {

		for (int i = 0; i < newEvaluation.getQr().size(); i++) {
			QR qr = newEvaluation.getQr().get(i);
			qr.setEvaluation(newEvaluation);
		}
		QRservice.AjoutlistQR(newEvaluation.getQr());
		return new ResponseEntity<>("update done", HttpStatus.ACCEPTED);
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public void AjoutEvaluation(@RequestBody Evaluation evaluation) {

		evaluationService.AjoutEvaluation(evaluation);

		for (int i = 0; i < evaluation.getQr().size(); i++) {
			QR qr = evaluation.getQr().get(i);
			qr.setEvaluation(evaluation);
		}
		QRservice.AjoutlistQR(evaluation.getQr());
	}

	// Path http://localhost:9200/evaluation/update-evaluation
//	@PutMapping("/update-evaluation")
//	@ResponseBody
//	ResponseEntity<?> updateEvaluation(@RequestBody Evaluation newEvaluation) {
//
//		evaluationService.updateEvaluation(newEvaluation);
//		return new ResponseEntity<>("update done", HttpStatus.ACCEPTED);
//		
//	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteEvaluation(@PathVariable("id") Integer id) {
		Evaluation evaluation = evaluationService.getEvalById(id);
		evaluationService.deleteEvaluation(evaluation);
	}

	@RequestMapping(path = "/duplicate", method = RequestMethod.POST)
	public Evaluation duplicateEval(@RequestBody Evaluation evaluation) {

		Evaluation newEvaluation = new Evaluation(evaluation.getTitre(), evaluation.getEtat(), evaluation.getDuree(),
				evaluation.getQr());

		// Liste qui va contenir les copies de QR
		List<QR> newListe = new ArrayList<QR>();

		for (int i = 0; i < newEvaluation.getQr().size(); i++) {
			QR ancienQR = evaluation.getQr().get(i);

			QR qr = new QR(ancienQR.getTitre(), ancienQR.getQuestion(), ancienQR.getRemarque(), ancienQR.getReponse(),
					ancienQR.getReponseCandidat());
			qr.setEvaluation(newEvaluation);
			newListe.add(qr);
		}

		newEvaluation.setQr(newListe);
		evaluationService.duplicateEval(newEvaluation);

		QRservice.AjoutNewlistQR((newEvaluation.getQr()));

		return newEvaluation;
	}

	@RequestMapping(path = "/answer/{idCand}", method = RequestMethod.POST)
	public Evaluation AnswerEval(@PathVariable("idCand") Integer id, @RequestBody Evaluation evaluation) {
		Candidat cand = Candidatservice.getCandidatById(id);// service

		Evaluation newEvaluation = new Evaluation(evaluation.getTitre(), evaluation.getEtat(), evaluation.getDuree(),
				evaluation.getQuiz(), cand);

		// Liste qui va contenir les copies de Quiz
		List<Quiz> newListe = new ArrayList<Quiz>();

		for (int i = 0; i < newEvaluation.getQuiz().size(); i++) {
			Quiz ancienquiz = evaluation.getQuiz().get(i);

			Quiz quiz = new Quiz(ancienquiz.getTitre(), ancienquiz.getQuestion(), ancienquiz.getListChoice(),
					ancienquiz.getReponse(), ancienquiz.getReponseCandidat());
			quiz.setEvaluation(newEvaluation);
			newListe.add(quiz);
		}

		newEvaluation.setQuiz(newListe);
		evaluationService.AnswerEval(newEvaluation);

		quizService.AjoutNewlistQuiz(newEvaluation.getQuiz());

		return newEvaluation;
	}

	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public List<Evaluation> getAll() {
		return evaluationService.getAll();
	}

	@RequestMapping(path = "/updateRep/{id}", method = RequestMethod.POST)
	public Evaluation update(@PathVariable("id") Integer id, @RequestBody Evaluation evaluation) {
		Candidat candidat = Candidatservice.getCandidatById(id);

		Evaluation newEvaluation = new Evaluation(evaluation.getTitre(), evaluation.getEtat(), evaluation.getDuree(),
				evaluation.getQr());

		// Liste qui va contenir les copies de QR
		List<QR> newListe = new ArrayList<QR>();

		for (int i = 0; i < newEvaluation.getQr().size(); i++) {
			QR ancienQR = evaluation.getQr().get(i);

			QR qr = new QR(ancienQR.getTitre(), ancienQR.getQuestion(), ancienQR.getRemarque(), ancienQR.getReponse(),
					ancienQR.getReponseCandidat());
			qr.setEvaluation(newEvaluation);
			newListe.add(qr);
		}

		newEvaluation.setQr(newListe);
		//
		Candidatservice.updateCandidat(candidat);
		evaluationService.ajoutRep(newEvaluation);

		QRservice.AjoutNewlistQR((newEvaluation.getQr()));

		return newEvaluation;

	}

	@RequestMapping(path = "/getEval/{id}", method = RequestMethod.GET)

	public Evaluation getEvaluation(@PathVariable("id") Integer id) {
		System.out.println(id);
		return evaluationService.getEvalById(id);
	}

	@RequestMapping("/edit")
	@ResponseBody
	public ResponseEntity<String> editEvaluation(@RequestBody Evaluation newEvaluation) {

		evaluationService.saveAll(newEvaluation);
		return new ResponseEntity<>("edit done", HttpStatus.ACCEPTED);
	}
}




//	@RequestMapping(value = "/reponseCandidat/{id}", method = RequestMethod.POST)
//	public ResponseEntity<?> UpdateReponse(@PathVariable("id") Integer id, @RequestBody Evaluation evaluation) {
//
////		ReponseCand reponse = evaluationService.getreponseById(id);
//	List<QR> newListe = new ArrayList<QR>();
////	.setReponseCandidat(evaluation.getQr());
//
//		evaluationService.UpdateReponse(evaluation);
//	
//	

//	@RequestMapping("/edit")
//	@ResponseBody
//	public ResponseEntity<String> editEvaluation(@RequestBody Evaluation newEvaluation ) {
//
//		evaluationService.saveAll(newEvaluation);
//		return new ResponseEntity<>("edit done", HttpStatus.ACCEPTED); 
//	}

//	
//	@RequestMapping("/edit")
//	@ResponseBody
//	public ResponseEntity<String> editEvaluation(@RequestBody Evaluation newEvaluation ) {
//		
//		evaluationService.updateEvaluation(newEvaluation);
//		return new ResponseEntity<>("edit done", HttpStatus.ACCEPTED);
//	}
//	

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

//	@RequestMapping(path = "/duplicate", method = RequestMethod.POST)
//	public void duplicateEval(@RequestBody Evaluation evaluation) { 
//		
//		Evaluation newEvaluation = new Evaluation(evaluation.getTitre(), evaluation.getEtat(),evaluation.getDuree(), evaluation.getQr());
//		List<QR> newListe = new ArrayList<QR>();
//		for(int i = 0; i < newEvaluation.getQr().size(); i++) {
//			QR qr = new QR(evaluation.getQr().get(i).getTitre(), evaluation.getQr().get(i).getQuestion(), evaluation.getQr().get(i).getRemarque(), evaluation.getQr().get(i).getReponse(), evaluation.getQr().get(i).getReponseCandidat());
//			qr.setEvaluation(newEvaluation);
//			newListe.add(qr);
//		}
//		newEvaluation.setQr(newListe);
//		evaluationService.duplicateEval(newEvaluation);
//		
//		qrservice.AjoutNewlistQR((newEvaluation.getQr()));
//		
//	}
