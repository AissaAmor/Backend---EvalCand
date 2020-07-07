package spring.session.EvalCand.services;

import java.util.List;

import spring.session.EvalCand.entities.Candidat;




public interface CandidatService {
	
	public void AjoutCandidat(Candidat candidat);

	public void deleteCandidat(Candidat candidat);

	public List<Candidat> getAll();	
	public  Candidat getCandidatById(Integer id);
	public void updateCandidat(Candidat candidat);
   
	public Candidat loadByEmailCand(String email);

	


}