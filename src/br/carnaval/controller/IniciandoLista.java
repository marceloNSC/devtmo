package br.carnaval.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.carnaval.bean.Fantasia;
import br.carnaval.model.conexao.Conexao;
import br.carnaval.model.dao.impl.ImplFantasia;

@WebServlet(name = "/IniciandoLista", urlPatterns = { "/home" })
public class IniciandoLista extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ImplFantasia impl = new ImplFantasia(Conexao.getInstance());
		List<Fantasia> lista = impl.listAll(Fantasia.class, 100);
		request.setAttribute("lista", lista);
		request.getRequestDispatcher("/home.jsp").forward(request, response);

	}

}
