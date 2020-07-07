package spring.session.EvalCand.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.session.EvalCand.entities.Quiz;
import spring.session.EvalCand.repositories.QuizRepository;

@Service("Quizservice")
public class QuizServiceImpl implements QuizService {

	@Autowired
	QuizRepository Quizrepository;

	@Override
	public void AjoutQuiz(Quiz quiz) {
		Quizrepository.save(quiz);
	}

	@Override
	public void deleteQuiz(Quiz quiz) {
		Quizrepository.delete(quiz);

	}

	@Override
	public void ajoutListQuiz(List<Quiz> Lquiz) {
		Quizrepository.saveAll(Lquiz);
	}

	@Override
	public List<Quiz> getAll() {
		return Quizrepository.findAll();
	}

	@Override
	public Quiz submitAnser(Quiz quiz) {

		return Quizrepository.save(quiz);
	}

	@Override
	public void AjoutNewlistQuiz(List<Quiz> Lquiz) {
		Quizrepository.saveAll(Lquiz);
	}

}