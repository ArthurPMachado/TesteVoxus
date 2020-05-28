package br.com.voxus.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.voxus.to.PaymentTO;

public class PaymentDAO {
	
	public static List<PaymentTO> payments = null;
	
	public PaymentDAO() {
		if(payments == null) {
			payments = new ArrayList<PaymentTO>();
		}
	}
	
	public boolean create(PaymentTO payment) {
		if(payment != null) {
			payment.setId(payments.size()+1);
			return payments.add(payment);
		}
		
		return false;
	}
	
	public List<PaymentTO> readPayments() {
		return payments;
	}
	
	
	public boolean update(PaymentTO payment) {
		if(payment != null) {
			for (int i = 0; i < payments.size(); i++) {
				if(payments.get(i).getId() == payment.getId()) {
					payments.set(i, payment);
					return true;
				}
			}
		}
		return false;
	}
	
	public void delete(int id) {
		for (int i = 0; i < payments.size(); i++) {
			if(payments.get(i).getId() == id) {
				payments.remove(i);
			}
		}
	}
}
