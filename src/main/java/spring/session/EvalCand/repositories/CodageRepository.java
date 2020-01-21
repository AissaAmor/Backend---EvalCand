package spring.session.EvalCand.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.session.EvalCand.entities.Codage;

@Repository("CodageRepository")
public interface CodageRepository extends  JpaRepository<Codage, Integer>{

}
