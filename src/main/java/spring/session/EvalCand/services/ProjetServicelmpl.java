package spring.session.EvalCand.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.session.EvalCand.entities.Projet;
import spring.session.EvalCand.repositories.ProjetRepository;

@Service("Projetservice")
public class ProjetServicelmpl implements ProjetService {

	@Autowired
	ProjetRepository Projetrepository;
	
	@Override
	public void AjoutProjet(Projet Projet) {
		Projetrepository.save(Projet);
		
	}

	@Override
	public void deleteProjet(Projet Projet) {
		Projetrepository.delete(Projet);
		
	}

}
