package spring.session.EvalCand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.session.EvalCand.entities.Evaluation;
import spring.session.EvalCand.entities.QR;
import spring.session.EvalCand.repositories.EvaluationRepository;
import spring.session.EvalCand.services.EvaluationService;
import spring.session.EvalCand.services.QRService;


public class EvaluationController {
	@Autowired
	EvaluationRepository evaluationrepository ;

	@Autowired
	EvaluationService evaluationService;

	@Autowired
	QRService QRservice;
	
	
	@RequestMapping(path = "/add", method = RequestMethod.POST)
    public void AjoutEvaluation(@RequestBody Evaluation evaluation ) {

    evaluationService.AjoutEvaluation(evaluation);

    for(int i = 0; i < evaluation.getQr().size(); i++) {
        QR qr = evaluation.getQr().get(i);
        qr.setEvaluation(evaluation);
    }
    QRservice.AjoutlistQR(evaluation.getQr());
}
	
}
