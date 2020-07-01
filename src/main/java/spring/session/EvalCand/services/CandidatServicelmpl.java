package spring.session.EvalCand.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.session.EvalCand.entities.Candidat;
import spring.session.EvalCand.entities.Coach;
import spring.session.EvalCand.entities.Evaluation;
import spring.session.EvalCand.entities.Quiz;
import spring.session.EvalCand.repositories.CandidatRepository;

@Service("Candidatservice")
public class CandidatServicelmpl implements CandidatService{

	
	@Autowired
	CandidatRepository candidatrepository ;

	
	@Override
	public void AjoutCandidat(Candidat candidat) {
		candidatrepository.save(candidat);
		
	}

	@Override
	public void deleteCandidat(Candidat candidat) {
		candidatrepository.delete(candidat);
		
	}

	@Override
	public List<Candidat> getAll() {

		return candidatrepository.findAll();
		
	}
	
	@Override
	public void updateCandidat(Candidat candidat) {
		candidatrepository.save(candidat);
	
	}
	
	
	
	
	@Override
	public Candidat getCandidatById(Integer id) {

		return candidatrepository.findById(id).get();
	}

	
	
//	@Override
//	public Evaluation AnswerEval(candidat cand) {
//		return candidatrepository.findById(id).get();
//	}
	
	
//	@Override
//	public void validateEval(Evaluation evaluation) {
//		candidatrepository.save(evaluation);
//	}
}
