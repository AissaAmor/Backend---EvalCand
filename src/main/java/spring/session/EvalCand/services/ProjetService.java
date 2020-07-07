package spring.session.EvalCand.services;

import java.util.List;

import spring.session.EvalCand.entities.Projet;

public interface ProjetService {

	
	public void ajoutListProjet(Projet projet);

	public List<Projet> getAll();

	void ajoutListProjet(List<Projet> projet);

	

	

}
