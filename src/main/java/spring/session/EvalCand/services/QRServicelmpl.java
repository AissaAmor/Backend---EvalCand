package spring.session.EvalCand.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.session.EvalCand.entities.QR;
import spring.session.EvalCand.repositories.QRRepository;

@Service("QRservice")
public class QRServicelmpl implements QRService {

	@Autowired
	QRRepository QRrepository;

	@Override
	public void AjoutQR(QR QR) {
		QRrepository.save(QR);
		
	}
	
	@Override
	public void AjoutlistQR(List<QR> LQR) {
		QRrepository.saveAll(LQR);	
	}
	
	@Override
	public void AjoutNewlistQR(List<QR> LQR) {
		QRrepository.saveAll(LQR);	
	}
	@Override
	public void deleteQR(QR QR) {
		QRrepository.delete(QR);
	}
}
