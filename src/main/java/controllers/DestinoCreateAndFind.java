package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DestinoDAO;
import dao.FuncionarioDAO;
import model.Destino;
import model.Funcionario;


@WebServlet("/DestinoMakeAndSearch")
public class DestinoCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DestinoCreateAndFind() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pesquisa = request.getParameter("pesquisa");

		if(pesquisa == null) {
			pesquisa="";
		}
		
		List<Destino> destinos = DestinoDAO.find(pesquisa);
		List<Funcionario> funcionarios = FuncionarioDAO.find("");
		
		request.setAttribute("destinos", destinos);
		request.setAttribute("funcionarios", funcionarios);

		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaDestino.jsp");
		requestDispatcher.forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Destino destino = new Destino();

		// destino.setIdFuncionario(Integer.parseInt(request.getParameter("idFuncionario")));
		destino.setNome(request.getParameter("nome"));
		destino.setCidade(request.getParameter("cidade"));
		destino.setEstado(request.getParameter("estado"));
		destino.setPrecoDoPacote(Double.parseDouble(request.getParameter("precoDoPacote")));
		destino.setPromocao(Boolean.parseBoolean(request.getParameter("promocao")));
		destino.setDesconto(Double.parseDouble(request.getParameter("desconto")));
		destino.setUrlFoto(request.getParameter("urlFoto"));

		
		DestinoDAO.create(destino);
		
		DestinoCreateAndFind destinoCreateAndFind = new DestinoCreateAndFind();
		destinoCreateAndFind.doGet(request, response);
	}

}
