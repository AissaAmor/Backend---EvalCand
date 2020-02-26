package spring.session.EvalCand.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.session.EvalCand.entities.QR;
@Repository("QRRepository")
public interface QRRepository extends JpaRepository<QR, Integer>{

}
