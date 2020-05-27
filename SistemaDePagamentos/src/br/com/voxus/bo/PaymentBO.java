package br.com.voxus.bo;

import br.com.voxus.dao.PaymentDAO;
import br.com.voxus.to.PaymentTO;

public class PaymentBO {

	private PaymentDAO dao;
	
	public PaymentBO() {
		dao = new PaymentDAO();
	}
	
	public boolean cadastrarPagamento(PaymentTO payment) {
		if(payment.getTitle() < 5)
		
		return dao.create(payment);
	}
}
