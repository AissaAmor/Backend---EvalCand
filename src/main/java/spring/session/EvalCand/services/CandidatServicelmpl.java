package spring.session.EvalCand.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.session.EvalCand.entities.Candidat;
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

}
