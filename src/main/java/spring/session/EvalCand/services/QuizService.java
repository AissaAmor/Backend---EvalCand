package spring.session.EvalCand.services;

import java.util.List;


import spring.session.EvalCand.entities.Quiz;

public interface QuizService {
	public void AjoutQuiz(Quiz quiz);

	public void deleteQuiz(Quiz quiz);

	public void ajoutListQuiz(List<Quiz> Lquiz);

	List<Quiz> getAll();

	Quiz submitAnser(Quiz quiz);

	public void AjoutNewlistQuiz(List<Quiz> Lquiz);
}
