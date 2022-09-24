package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TransicaoDAO;
import model.Transicao;


@WebServlet("/TransicaoMakeAndSearch")
public class TransicaoCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TransicaoCreateAndFind() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pesquisa = request.getParameter("pesquisa");

		if(pesquisa == null) {
			pesquisa="";
		}
		
		List<Transicao> transicoes = TransicaoDAO.find(pesquisa);
		
		request.setAttribute("transicoes", transicoes);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaTransicao.jsp");
		requestDispatcher.forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Transicao transicao = new Transicao();
		
		transicao.setIdCliente(Integer.parseInt(request.getParameter("idCliente")));
		transicao.setIdDestino(Integer.parseInt(request.getParameter("idDestino")));
		transicao.setQuantidadeDiarias(Integer.parseInt(request.getParameter("quantidadeDiarias")));
		transicao.setDataViagem(request.getParameter("dataViagem"));
		transicao.setOptanteSeguro(Boolean.parseBoolean(request.getParameter("optanteSeguro")));
		transicao.setTaxaSeguro(Double.parseDouble(request.getParameter("taxaSeguro")));
		
		TransicaoDAO.create(transicao);
		
		TransicaoCreateAndFind transicaoCreateAndFind = new TransicaoCreateAndFind();
		transicaoCreateAndFind.doGet(request, response);
	}

}
