package br.com.voxus.resource;

import javax.ws.rs.Path;

import br.com.voxus.bo.PaymentBO;

@Path("payment/api/v1")
public class PaymentResource {
	
	private PaymentBO bo = new PaymentBO();
}
