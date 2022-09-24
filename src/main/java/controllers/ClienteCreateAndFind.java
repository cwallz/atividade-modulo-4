package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import model.Cliente;


@WebServlet("/ClienteMakeAndSearch")
public class ClienteCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ClienteCreateAndFind() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pesquisa = request.getParameter("pesquisa");

		if(pesquisa == null) {
			pesquisa="";
		}
		
		List<Cliente> clientes = ClienteDAO.find(pesquisa);
		
		request.setAttribute("clientes", clientes);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaCliente.jsp");
		requestDispatcher.forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cliente = new Cliente();
		
		cliente.setNome(request.getParameter("nome"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setSenha(request.getParameter("senha"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setDataDeNascimento(request.getParameter("dataDeNascimento"));
		
		ClienteDAO.create(cliente);
		
		ClienteCreateAndFind clienteCreateAndFind = new ClienteCreateAndFind();
		clienteCreateAndFind.doGet(request, response);
	}

}
