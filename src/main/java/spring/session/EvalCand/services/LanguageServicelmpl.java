package spring.session.EvalCand.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.session.EvalCand.entities.Language;
import spring.session.EvalCand.repositories.LanguageRepository;

@Service("languageservice")
public class LanguageServicelmpl implements LanguageService {

	@Autowired
	LanguageRepository languagerepository;
	
	@Override
	public void AjoutLanguage(Language Language) {
		languagerepository.save(Language);
		
	}

	@Override
	public void deleteLanguage(Language Language) {
		languagerepository.delete(Language);
		
	}

}
