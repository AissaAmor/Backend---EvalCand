package spring.session.EvalCand.services;

import java.util.List;

import spring.session.EvalCand.entities.Coach;

public interface CoachService {

	Coach findbyUsername(String usernameOrEmail);

	public void AjoutCoach(Coach coach);

	public void UpdateCoach(Coach coach);

	public void deleteCoach(Coach coach);

	public List<Coach> getAll();

	public Coach getCoachById(Integer id);

	public Coach loadByUsername(String username);

	public Coach loadByEmail(String email);
	
	public Coach loadbyPassword(String password);

	public Coach getConnectedCoach(String username);

}
