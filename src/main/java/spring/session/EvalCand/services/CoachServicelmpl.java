package spring.session.EvalCand.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.session.EvalCand.entities.Coach;
import spring.session.EvalCand.repositories.CoachRepository;



@Service("Coachservice")
public class CoachServicelmpl implements CoachService {

	@Autowired
	CoachRepository coachrepository ; 
	
	
	@Override
	public void AjoutCoach(Coach coach) {
		coachrepository.save(coach);
		
	}

	@Override
	public void deleteCoach(Coach coach) {
		coachrepository.delete(coach);
		
	}

}
