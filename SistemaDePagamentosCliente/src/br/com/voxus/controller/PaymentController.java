package br.com.voxus.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.voxus.bo.PaymentBO;
import br.com.voxus.to.PaymentTO;

/**
 * Servlet implementation class PaymentController
 */
@WebServlet({ "/cadastrar", "/listar", "/atualizar", "/excluir" })
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private PaymentBO bo = new PaymentBO();
	private PaymentTO payment = null;
	
    public PaymentController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getRequestURI().equals("/SistemaDePagamentosCliente/listar")) {
			
			listar(request, response);
			
		} else if(request.getRequestURI().equals("/SistemaDePagamentosCliente/cadastrar")) {
			
			cadastrar(request, response);
			
		} else if(request.getRequestURI().equals("/SistemaDePagamentosCliente/alterar")) {
			
			alterar(request, response);
		
		} else if(request.getRequestURI().equals("/SistemaDePagamentosCliente/excluir")) {
			
			remover(request, response);
			
		}
	}
	
	
	protected void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		payment = new PaymentTO();
		payment.setTitle(request.getParameter("title"));
		payment.setValue(Double.parseDouble(request.getParameter("value")));
		payment.setDate(request.getParameter("date"));
		payment.setComments(request.getParameter("comments"));
		
		bo.cadastrar(payment);
		
		request.setAttribute("controle", "lista-pagamento");
		
		request.getRequestDispatcher("listar").forward(request, response);
	}

	protected void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PaymentTO[] paymentArray = bo.listar();
		
		request.setAttribute("listaDePagamentos", paymentArray);
		
		request.setAttribute("controle", "lista-pagamento");
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	protected void alterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		payment.setId(Integer.parseInt(request.getParameter("paymentIdPut")));
		payment.setTitle(request.getParameter("title"));
		payment.setValue(Double.parseDouble(request.getParameter("value")));
		payment.setDate(request.getParameter("date"));
		payment.setComments(request.getParameter("comments"));
		
		bo.atualizar(payment);
		
		request.setAttribute("controle", "lista-pagamento");
		
		request.getRequestDispatcher("listar").forward(request, response);
	}
	
	protected void remover(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("paymentIdDelete"));
		
		bo.excluir(codigo);
		
		request.setAttribute("controle", "lista-pagamento");
		
		request.getRequestDispatcher("listar").forward(request, response);
	}
}
