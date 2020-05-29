package br.com.voxus.servico;

import java.net.URI;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.voxus.to.PaymentTO;

public class Servico {
	
	private Client client = Client.create();
	private WebResource resource = null;
	private ClientResponse response = null;
	
	public URI servicePost(PaymentTO payment) {
		resource = client.resource("http://localhost:8080/SistemaDePagamentos/payment/api/v1");
		response = resource.type("application/json").post(ClientResponse.class, payment);
		
		if(response.getStatus() == 201) {
			return response.getLocation();
		} else {
			return null;
		}
	}

	public PaymentTO[] serviceGetAll() {
		resource = client.resource("http://localhost:8080/SistemaDePagamentos/payment/api/v1");
		response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if(response.getStatus() == 200) {
			return response.getEntity(PaymentTO[].class);
		} else {
			return null;
		}
	}
	
	
	public boolean servicePut(PaymentTO payment, int codigo) {
		resource = client.resource("http://localhost:8080/SistemaDePagamentos/payment/api/v1/" + codigo);
		response = resource.type("application/json").put(ClientResponse.class, payment);
		
		if(response.getStatus() == 200) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean serviceDelete(int codigo) {
		resource = client.resource("http://localhost:8080/SistemaDePagamentos/payment/api/v1/" + codigo);
		response = resource.delete(ClientResponse.class);
	
		if(response.getStatus() == 204) {
			return true;
		} else {
			return false;
		}
	}
}
