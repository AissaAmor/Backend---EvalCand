package spring.session.EvalCand.services;

import java.util.List;

import spring.session.EvalCand.entities.Candidat;
import spring.session.EvalCand.entities.Coach;


public interface CandidatService {
	
	public void AjoutCandidat(Candidat candidat);
	public void deleteCandidat(Candidat candidat);
	public List<Candidat> getAll();	

}