package br.com.voxus.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.voxus.bo.PaymentBO;
import br.com.voxus.to.PaymentTO;

@Path("/payment/api/v1")
public class PaymentResource {
	
	private PaymentBO bo = new PaymentBO();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(PaymentTO payment, @Context UriInfo uriInfo) {
		bo.cadastrarPagamento(payment);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(payment.getId()));
		return Response.created(builder.build()).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PaymentTO> listar() {
		return bo.listarPagamentos();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(PaymentTO payment, @PathParam("id") int codigo) {
		payment.setId(codigo);
		bo.atualizarPagamentos(payment);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public void remover(@PathParam("id") int codigo) {
		bo.deletarPagamento(codigo);
	}
}
