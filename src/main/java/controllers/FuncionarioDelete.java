package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FuncionarioDAO;

@WebServlet("/FuncionarioRemove")
public class FuncionarioDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FuncionarioDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int funcionarioId = Integer.parseInt(request.getParameter("funcionarioId"));
		System.out.println(funcionarioId);
		FuncionarioDAO.delete(funcionarioId);
		
		FuncionarioCreateAndFind funcionarioCreateAndFind = new FuncionarioCreateAndFind();
		funcionarioCreateAndFind.doGet(request, response);
	}

}
