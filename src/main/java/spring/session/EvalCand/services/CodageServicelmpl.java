package spring.session.EvalCand.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.session.EvalCand.entities.Codage;
import spring.session.EvalCand.repositories.CodageRepository;

@Service("Codageservice")
public class CodageServicelmpl implements CodageService{

	@Autowired
	CodageRepository Codagerepository ; 
	
	
	@Override
	public void AjoutCodage(Codage Codage) {
			Codagerepository.save(Codage);	
	}

	@Override
	public void deleteCodage(Codage Codage) {
			Codagerepository.delete(Codage);
		
	}

}
