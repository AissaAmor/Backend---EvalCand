package spring.session.EvalCand.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.session.EvalCand.entities.Evaluation;
import spring.session.EvalCand.entities.Projet;
import spring.session.EvalCand.entities.QR;
import spring.session.EvalCand.repositories.EvaluationRepository;


@Service("EvaluationService")
public class EvaluationServicelmpl implements EvaluationService {
	@Autowired
	EvaluationRepository Evaluationrepository;
	@PersistenceContext
	EntityManager em;

	@Autowired
	ProjetService projetService;

	@Autowired
	QRService QRservice;

	@Override
	public void AjoutEvaluation(Evaluation evaluation) {
		Evaluationrepository.save(evaluation);
		
	}

	@Override
	public void deleteEvaluation(Evaluation evaluation) {
		Evaluationrepository.delete(evaluation);
		
	}

	@Override
	public void updateEvaluation(Evaluation evaluation) {
		Evaluationrepository.save(evaluation);
	}

	@Override
	public Evaluation getEvalById(Integer id) {
		return Evaluationrepository.getOne(id);
	}


	@Override
	public List<Evaluation> getAll() {
		
		return Evaluationrepository.findAll() ;
	}
	
	
	
	@Override
	public List<Evaluation> editEvaluation() {
		
		return Evaluationrepository.saveAll(editEvaluation()) ;
	}
	
	
	@Override
	public void duplicateEval(Evaluation evaluation ) {
		Evaluationrepository.save(evaluation);
	}

	@Override
	public void editEvaluation (Evaluation evaluation) {
		Evaluationrepository.save(evaluation);
	}

	@Override
	public void saveAll(Evaluation evaluations) {

		Evaluationrepository.save(evaluations);

		// Projets
		List<Projet> projets = evaluations.getProjet();
		for(int i = 0; i < projets.size(); i++) {
			Projet projet = projets.get(i);
			// Liaison projet - evalution
			projet.setEvaluation(evaluations);
			projetService.AjoutProjet(projet);
			
		}
	
		// List QR
		List<QR> listQR = evaluations.getQr();
		for(int i = 0; i < listQR.size(); i++) {
			QR qr = listQR.get(i);
			qr.setEvaluation(evaluations);
			QRservice.AjoutQR(qr);
		}
	}
}
