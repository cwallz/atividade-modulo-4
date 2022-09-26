package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FuncionarioDAO;
import model.Funcionario;

@WebServlet("/FuncionarioUpdate")
public class FuncionarioFindAndUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FuncionarioFindAndUpdate() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int funcionarioId = Integer.parseInt(request.getParameter("funcionarioId"));
		Funcionario funcionario = FuncionarioDAO.findByPk(funcionarioId);
		
		request.setAttribute("funcionario", funcionario);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("formUpdateFuncionario.jsp");
		requestDispatcher.forward(request,  response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Funcionario funcionario = new Funcionario();

		funcionario.setIdFuncionario(Integer.parseInt(request.getParameter("idFuncionario")));
		funcionario.setNome(request.getParameter("nome"));
		funcionario.setEmail(request.getParameter("email"));
		funcionario.setSenha(request.getParameter("senha"));
		funcionario.setRegistroMatricula(request.getParameter("registroMatricula"));
		funcionario.setPerfil(request.getParameter("perfil"));
		
		
		FuncionarioDAO.update(funcionario);
		
		FuncionarioCreateAndFind funcionarioCreateAndFind = new FuncionarioCreateAndFind();
		funcionarioCreateAndFind.doGet(request, response);
	}

}
