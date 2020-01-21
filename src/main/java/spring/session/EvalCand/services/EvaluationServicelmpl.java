package spring.session.EvalCand.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.session.EvalCand.entities.Evaluation;
import spring.session.EvalCand.repositories.EvaluationRepository;


@Service("Codageservice")
public class EvaluationServicelmpl implements EvaluationService {

	@Autowired
	EvaluationRepository Evaluationrepository ; 
	
	@Override
	public void AjoutEvaluation(Evaluation evaluation) {
		Evaluationrepository.save(evaluation);
		
	}

	@Override
	public void deleteEvaluation(Evaluation evaluation) {
		Evaluationrepository.delete(evaluation);
		
	}

	@Override
	public Evaluation getEvalById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Evaluation> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
