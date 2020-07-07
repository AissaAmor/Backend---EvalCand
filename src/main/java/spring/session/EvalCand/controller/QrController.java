package spring.session.EvalCand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import spring.session.EvalCand.repositories.EvaluationRepository;
import spring.session.EvalCand.repositories.QRRepository;
import spring.session.EvalCand.services.QRService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/qr")
public class QrController {
	@Autowired
	EvaluationRepository evaluationrepository;
	@Autowired
	QRService QRservice;
	@Autowired
	QRRepository qrRepository;	
	
//	@RequestMapping(value = "/reponseCandidat/{id}", method = RequestMethod.POST)
//	public ResponseEntity<?> UpdateReponse(@PathVariable("id") Integer id, @RequestBody ReponseCand reponse) {
//	
//	}
}
