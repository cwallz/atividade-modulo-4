package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FuncionarioDAO;
import model.Funcionario;


@WebServlet("/FuncionarioMakeAndSearch")
public class FuncionarioCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FuncionarioCreateAndFind() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pesquisa = request.getParameter("pesquisa");

		if(pesquisa == null) {
			pesquisa="";
		}
		
		List<Funcionario> funcionarios = FuncionarioDAO.find(pesquisa);
		
		request.setAttribute("funcionarios", funcionarios);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaFuncionario.jsp");
		requestDispatcher.forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Funcionario funcionario = new Funcionario();
		
		funcionario.setNome(request.getParameter("nome"));
		funcionario.setEmail(request.getParameter("email"));
		funcionario.setSenha(request.getParameter("senha"));
		funcionario.setRegistroMatricula(request.getParameter("registroMatricula"));
		funcionario.setPerfil(request.getParameter("perfil"));
		
		FuncionarioDAO.create(funcionario);
		
		FuncionarioCreateAndFind funcionarioCreateAndFind = new FuncionarioCreateAndFind();
		funcionarioCreateAndFind.doGet(request, response);
	}

}
