package spring.session.EvalCand.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.session.EvalCand.entities.Coach;
import spring.session.EvalCand.entities.Evaluation;
import spring.session.EvalCand.repositories.EvaluationRepository;


@Service("EvaluationService")
public class EvaluationServicelmpl implements EvaluationService {
	@Autowired
	EvaluationRepository Evaluationrepository;
	@PersistenceContext
	EntityManager em;

	
	
	@Override
	public void AjoutEvaluation(Evaluation evaluation) {
		Evaluationrepository.save(evaluation);
		
	}

	@Override
	public void deleteEvaluation(Evaluation evaluation) {
		Evaluationrepository.delete(evaluation);
		
	}

	@Override
	public void updateEvaluation(Evaluation evaluation) {
		Evaluationrepository.save(evaluation);
	}

	@Override
	public Evaluation getEvalById(Integer id) {
		return Evaluationrepository.findById(id).get();
	}
	
	@Override
	public List<Evaluation> getAll() {
		
		return Evaluationrepository.findAll() ;
	}
	
	@Override
	public void duplicateEval(Evaluation evaluation ) {
		Evaluationrepository.save(evaluation);
	}
//	@Override
//	public Object clone() {
//	    try {
//	        return (Evaluation) super.clone();
//	    } catch (CloneNotSupportedException e) {
//	        return new Evaluation(this.projet, this.getCodage(), this.getLanguage());
//	    }
//	}

	
}
