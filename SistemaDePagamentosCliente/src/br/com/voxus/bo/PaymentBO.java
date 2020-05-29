package br.com.voxus.bo;

import br.com.voxus.servico.Servico;
import br.com.voxus.to.PaymentTO;

public class PaymentBO {

	private Servico servico = null;
	
	public PaymentBO() {
		servico = new Servico();
	}
	
	public void cadastrar(PaymentTO payment) {
		servico.servicePost(payment);
	}

	public PaymentTO[] listar() {
		return servico.serviceGetAll();
	}
	
	public void atualizar(PaymentTO payment) {
		servico.servicePut(payment, payment.getId());
	}
	
	public void excluir(int codigo) {
		servico.serviceDelete(codigo);
	}
}
