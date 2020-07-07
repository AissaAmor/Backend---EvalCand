package spring.session.EvalCand.controller;

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
import spring.session.EvalCand.repositories.QuizRepository;
import spring.session.EvalCand.services.EvaluationService;
import spring.session.EvalCand.services.QuizService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	EvaluationRepository evaluationrepository;
	@Autowired
	QuizRepository Quizrepository;
	@Autowired
	QuizService quizService;
	@Autowired
	EvaluationService evaluationService;

	@RequestMapping(path = "/addQuiz", method = RequestMethod.POST)
	public void AjoutEvaluation(@RequestBody Evaluation evaluation) {

		evaluationService.AjoutEvaluation(evaluation);

		for (int i = 0; i < evaluation.getQuiz().size(); i++) {
			Quiz quiz = evaluation.getQuiz().get(i);
			quiz.setEvaluation(evaluation);
		}
		quizService.ajoutListQuiz(evaluation.getQuiz());
	}

	@PutMapping("/updateQuiz")
	@ResponseBody
	ResponseEntity<?> updateEvaluation(@RequestBody Evaluation newEvaluation) {

		for (int i = 0; i < newEvaluation.getQuiz().size(); i++) {
			Quiz quiz = newEvaluation.getQuiz().get(i);
			quiz.setEvaluation(newEvaluation);
		}
		quizService.ajoutListQuiz(newEvaluation.getQuiz());
		return new ResponseEntity<>("update done", HttpStatus.ACCEPTED);
	}

	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public List<Quiz> getAll() {
		return quizService.getAll();
	}

//	@RequestMapping(path = "/getQuiz/{id}", method = RequestMethod.GET)
//
//	public Evaluation getEvaluation(@PathVariable("id") Integer id) {
//		System.out.println(id);
//		return quizService.getEvaluation(id);
//	}
//	@RequestMapping(path = "/submitAnswer", method = RequestMethod.POST)
//    public Quiz submitAnser(@RequestBody Quiz quiz){
//		
//      return quizService.submitAnser(quiz);
//    }
}
