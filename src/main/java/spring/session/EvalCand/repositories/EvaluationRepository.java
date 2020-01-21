package spring.session.EvalCand.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.session.EvalCand.entities.Evaluation;

public interface EvaluationRepository extends  JpaRepository<Evaluation, Integer> {

}
