package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DestinoDAO;
import model.Destino;

@WebServlet("/DestinoUpdate")
public class DestinoFindAndUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DestinoFindAndUpdate() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int destinoId = Integer.parseInt(request.getParameter("destinoId"));
		Destino destino = DestinoDAO.findByPk(destinoId);
		
		request.setAttribute("destino", destino);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("formUpdateDestino.jsp");
		requestDispatcher.forward(request,  response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Destino destino = new Destino();
		destino.setIdDestino(Integer.parseInt(request.getParameter("idDestino")));
		//destino.setIdFuncionario(Integer.parseInt(request.getParameter("idFuncionario")));
		destino.setNome(request.getParameter("nome"));
		destino.setCidade(request.getParameter("cidade"));
		destino.setEstado(request.getParameter("estado"));
		destino.setPrecoDoPacote(Double.parseDouble(request.getParameter("precoDoPacote")));
		destino.setPromocao(Boolean.parseBoolean(request.getParameter("promocao")));
		destino.setDesconto(Double.parseDouble(request.getParameter("desconto")));
		destino.setUrlFoto(request.getParameter("urlFoto"));
		
		DestinoDAO.update(destino);
		
		DestinoCreateAndFind destinoCreateAndFind = new DestinoCreateAndFind();
		destinoCreateAndFind.doGet(request, response);
	}

}
