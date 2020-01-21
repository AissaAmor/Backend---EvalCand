package spring.session.EvalCand.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.session.EvalCand.entities.Language;

public interface LanguageRepository extends  JpaRepository<Language, Integer> {

}
