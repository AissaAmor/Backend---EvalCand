package spring.session.EvalCand.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.session.EvalCand.entities.Coach;


@Repository("CoachRepository")
public interface CoachRepository extends JpaRepository<Coach, Integer> {

}
