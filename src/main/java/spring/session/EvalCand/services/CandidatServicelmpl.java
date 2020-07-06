package spring.session.EvalCand.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.session.EvalCand.entities.Candidat;

import spring.session.EvalCand.repositories.CandidatRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Service("Candidatservice")
public class CandidatServicelmpl implements CandidatService {

	@Autowired
	CandidatRepository candidatrepository;

	@PersistenceContext
	EntityManager em;

	@Override
	public void AjoutCandidat(Candidat candidat) {
		candidatrepository.save(candidat);

	}

	@Override
	public void deleteCandidat(Candidat candidat) {
		candidatrepository.delete(candidat);

	}

	@Override
	public Candidat getCandidatById(Integer id) {

		return candidatrepository.findById(id).get();
	}

	@Override
	public Candidat loadByEmailCand(String email) {

		TypedQuery<Candidat> query = (TypedQuery<Candidat>) em
				.createQuery("SELECT c FROM Candidat c WHERE c.Email = :email", Candidat.class);
		Candidat candidat = query.setParameter("email", email).getSingleResult();
		return candidat;
	}

	@Override
	public List<Candidat> getAll() {

		return candidatrepository.findAll();

	}

	@Override
	public void updateCandidat(Candidat candidat) {
		candidatrepository.save(candidat);

	}

}
