package spring.session.EvalCand.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.session.EvalCand.entities.Coach;
import spring.session.EvalCand.repositories.CoachRepository;

@Service("Coachservice")
public class CoachServicelmpl implements CoachService {

	@Autowired
	CoachRepository coachrepository;
	@PersistenceContext
	EntityManager em;

	@Override
	public void AjoutCoach(Coach coach) {
		coachrepository.save(coach);

	}

	@Override
	public void deleteCoach(Coach coach) {
		coachrepository.delete(coach);

	}

	@Override
	public List<Coach> getAll() {

		return coachrepository.findAll();
	}

	@Override
	public Coach getCoachById(Integer id) {

		return coachrepository.getOne(id);
	}

	@Override
	public Coach loadByUsername(String username) {

		TypedQuery<Coach> query = (TypedQuery<Coach>) em
				.createQuery("SELECT u FROM Employe u WHERE u.username = :username", Coach.class);
		Coach coach = query.setParameter("username", username).getSingleResult();
		return coach;

	}

	@Override
	public Coach findbyUsername(String usernameOrEmail) {
	
		return null;
	}

	@Override
	public Coach getConnectedCoach(String username) {
		
		return null;
	}
}
