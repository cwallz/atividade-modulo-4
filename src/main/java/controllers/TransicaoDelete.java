package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TransicaoDAO;

@WebServlet("/TransicaoRemove")
public class TransicaoDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TransicaoDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int transicaoId = Integer.parseInt(request.getParameter("transicaoId"));
		System.out.println(transicaoId);
		TransicaoDAO.delete(transicaoId);
		
		TransicaoCreateAndFind transicaoCreateAndFind = new TransicaoCreateAndFind();
		transicaoCreateAndFind.doGet(request, response);
	}

}

