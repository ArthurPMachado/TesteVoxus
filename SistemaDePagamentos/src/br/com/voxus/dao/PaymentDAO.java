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
}
