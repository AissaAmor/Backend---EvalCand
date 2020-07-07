package spring.session.EvalCand.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.session.EvalCand.entities.Projet;
import spring.session.EvalCand.repositories.ProjetRepository;

@Service("Projetservice")
public class ProjetServicelmpl implements ProjetService {

	@Autowired
	ProjetRepository Projetrepository;

	@Override
	public void ajoutListProjet(List<Projet> projet) {
		Projetrepository.saveAll(projet);
		
	}

	@Override
	public List<Projet> getAll() {
	
		return getAll();
	}

	@Override
	public void ajoutListProjet(Projet projet) {
		
		
	}
	
	

	

}
