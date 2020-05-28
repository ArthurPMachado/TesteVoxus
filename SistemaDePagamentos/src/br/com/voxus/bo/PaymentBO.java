package br.com.voxus.bo;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.voxus.dao.PaymentDAO;
import br.com.voxus.to.PaymentTO;

public class PaymentBO {

	private PaymentDAO dao;
	
	public PaymentBO() {
		dao = new PaymentDAO();
	}
	
	public boolean cadastrarPagamento(PaymentTO payment) {
		// Valida o tamanho do titulo do pagamento
		if(payment.getTitle().length() < 5 || payment.getTitle().length() > 100) {
			JOptionPane.showMessageDialog(null, "Tamanho inválido para o título, tente colocar entre 5 e 100 caracteres");
			return false;
		}
		
		// Formatar a data para  ano/mes/dia
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		sdf.format(payment.getDate());
		
		// A taxa é um valor fixo de 5% do valor do pagamento
		double tax = payment.getValue() * 0.05;
		payment.setTax(tax);
		
		return dao.create(payment);
	}
	
	public List<PaymentTO> listarPagamentos() {
		return dao.readPayments();
	}
	
	public boolean atualizarPagamentos(PaymentTO payment) {
		return dao.update(payment);
	}
	
	public void deletarPagamentos(int código) {
		dao.delete(código);
	}
}
