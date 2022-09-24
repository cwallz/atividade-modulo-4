package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import model.Cliente;

@WebServlet("/ClienteUpdate")
public class ClienteFindAndUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ClienteFindAndUpdate() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int clienteId = Integer.parseInt(request.getParameter("clienteId"));
		Cliente cliente = ClienteDAO.findByPk(clienteId);
		
		request.setAttribute("cliente", cliente);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("formUpdateCliente.jsp");
		requestDispatcher.forward(request,  response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cliente cliente = new Cliente();
		cliente.setIdCliente(Integer.parseInt(request.getParameter("idCliente")));
		cliente.setNome(request.getParameter("nome"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setSenha(request.getParameter("senha"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setDataDeNascimento(request.getParameter("dataDeNascimento"));
		
		ClienteDAO.update(cliente);
		
		ClienteCreateAndFind clienteCreateAndFind = new ClienteCreateAndFind();
		clienteCreateAndFind.doGet(request, response);
	}

}
