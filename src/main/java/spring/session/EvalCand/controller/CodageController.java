package spring.session.EvalCand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring.session.EvalCand.entities.Codage;
import spring.session.EvalCand.repositories.CodageRepository;
import spring.session.EvalCand.services.CodageService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/codage")


public class CodageController {
	@Autowired
	CodageRepository Codagerepository ; 
	@Autowired
	CodageService codageService;
	
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public void addCodage(@RequestBody Codage Codage) {
		codageService.AjoutCodage(Codage);
	}
}
