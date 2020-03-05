package spring.session.EvalCand.services;

import java.util.List;

import spring.session.EvalCand.entities.QR;


public interface QRService {
	public void AjoutQR(QR QR);
	public void deleteQR(QR QR);
	public void AjoutlistQR(List<QR> LQR);	
	public void AjoutNewlistQR(List<QR> LQR);
       
    

}
