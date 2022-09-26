package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TransicaoDAO;
import model.Transicao;

@WebServlet("/TransicaoUpdate")
public class TransicaoFindAndUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TransicaoFindAndUpdate() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int transicaoId = Integer.parseInt(request.getParameter("transicaoId"));
		Transicao transicao = TransicaoDAO.findByPk(transicaoId);
		
		request.setAttribute("transicao", transicao);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("formUpdateTransicao.jsp");
		requestDispatcher.forward(request,  response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Transicao transicao = new Transicao();
		transicao.setIdTransicao(Integer.parseInt(request.getParameter("idTransicao")));
		//transicao.setIdCliente(Integer.parseInt(request.getParameter("idCliente")));
		//transicao.setIdDestino(Integer.parseInt(request.getParameter("idDestino")));
		transicao.setQuantidadeDiarias(Integer.parseInt(request.getParameter("quantidadeDiarias")));
		transicao.setDataViagem(request.getParameter("dataViagem"));
		transicao.setOptanteSeguro(Boolean.parseBoolean(request.getParameter("optanteSeguro")));
		transicao.setTaxaSeguro(Double.parseDouble(request.getParameter("taxaSeguro")));
		
		TransicaoDAO.update(transicao);
		
		TransicaoCreateAndFind transicaoCreateAndFind = new TransicaoCreateAndFind();
		transicaoCreateAndFind.doGet(request, response);
	}

}
