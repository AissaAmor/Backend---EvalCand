package spring.session.EvalCand.services;

import java.util.List;

import spring.session.EvalCand.entities.Candidat;


public interface CandidatService {
	
	public void AjoutCandidat(Candidat candidat);

	public void deleteCandidat(Candidat candidat);

	public Candidat getCandidatById(Integer id);

	public Candidat loadByEmailCand(String email);

	public List<Candidat> getAll();

}