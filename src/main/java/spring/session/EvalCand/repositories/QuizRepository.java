package spring.session.EvalCand.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.session.EvalCand.entities.Quiz;

@Repository("QuizRepository")
public interface QuizRepository extends  JpaRepository<Quiz, Integer>{

}
