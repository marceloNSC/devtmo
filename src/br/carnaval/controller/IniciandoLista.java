package br.carnaval.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.carnaval.bean.Fantasia;
import br.carnaval.model.conexao.Conexao;
import br.carnaval.model.dao.impl.ImplFantasia;

@WebServlet(name = "/IniciandoLista", urlPatterns = { "/listar/fantasia",
		"/listar/*" })
public class IniciandoLista extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		EntityManager co = null;
		try {
			co = Conexao.getInstance();
			ImplFantasia impl = new ImplFantasia(co);
			List<Fantasia> lista = impl.listAll(Fantasia.class, 100);
			request.setAttribute("lista", lista);
			request.getRequestDispatcher("/paginas/index.jsp").forward(request,
					response);
		} catch (Exception e) {
			response.sendError(404);
			// request.getRequestDispatcher("/paginas/error.jsp").forward(request,
			// response);
		}

	}

}
