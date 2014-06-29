package br.carnaval.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.carnaval.bean.Fantasia;
import br.carnaval.model.conexao.Conexao;
import br.carnaval.model.dao.impl.ImplFantasia;
import br.carnaval.model.dao.impl.ImplFoliao;
import br.carnaval.bean.Foliao;

public final class CompraFantasiaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String pagina = "";

	public CompraFantasiaController() {
		pagina = "home.jsp";
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String opcao = req.getParameter("opcao");

		switch (opcao) {
		
		case "iniciar":
			pagina = listarFantasias(req, resp);
			break;
		
		case "listarFantasias":
			pagina = listarFantasias(req, resp);
			break;

		default:
			pagina = "/home.jsp";
			break;
		}
		req.getRequestDispatcher(pagina).forward(req, resp);
	}

	private String listarFantasias(HttpServletRequest rq, HttpServletResponse rp)
			throws ServletException, IOException {
		ImplFantasia impl = new ImplFantasia(Conexao.getInstance());
		List<Fantasia> lista = impl.listAll(Fantasia.class, 100);
		rq.setAttribute("lista", lista);
		return "/home.jsp";
	}

	private void comprasComDadosDoCliente(HttpServletRequest rq,
			HttpServletResponse rp) throws ServletException, IOException {
		boolean isNula = false;
		String erro = "";
		String cpf = null;
		String idade = null;
		String rg = null;

		String nome = rq.getParameter("nome").trim().toString();

		try {

			rg = rq.getParameter("rg").trim().toString();
			cpf = rq.getParameter("cpf").trim().toString();
			idade = rq.getParameter("idade").trim().toString();

		} catch (NumberFormatException n) {
			isNula = true;
		}
		// TODO arrumar validacção de campo nome e do rg e cpf

		if (nome.equals("") || nome == null || nome.matches("\\w")) {
			erro += "nome Inválido ";
			isNula = true;
		}
		if (rg.equals("")) {
			erro += "rg inválido! ";
			isNula = true;
		}
		if (cpf.equals("")) {
			erro += "cpf inválido! ";
			isNula = true;
		}
		if (idade.equals("") || idade.length() == 0 || idade.length() > 3) {
			erro += "idade inválido! ";
			isNula = true;
		}

		if (isNula) {
			rq.setAttribute(
					"msg",
					"<p style='width:100%;padding:02px 8px;background:#fdd;border:1px solid #f00;'>"
							+ erro + "</p>");
			rq.setAttribute("nome", nome);
			rq.setAttribute("rg", rg);
			rq.setAttribute("cpf", cpf);
			rq.setAttribute("idade", idade);
			RequestDispatcher d = rq
					.getRequestDispatcher("/paginas/cadastro/cadastroFoliao.jsp");
			d.forward(rq, rp);
		} else {
			try {
				ImplFoliao impl = new ImplFoliao(Conexao.getInstance());
				br.carnaval.bean.Foliao foliao = new br.carnaval.bean.Foliao();
				foliao.setNome(nome);
				foliao.setIdade(Integer.parseInt(idade));
				foliao.setRg(Integer.parseInt(rg));
				foliao.setCpf(Integer.parseInt(cpf));
				impl.save(foliao);
				Conexao.closeInstance();

				seguePara(
						"msg",
						"<p style='width:100%;padding:02px 8px;background:#dfd;border:1px solid #0f0;'>Cadastro realizado com sucesso</p>",
						"/paginas/cadastro/cadastroFantasia.jsp", rq, rp);
			} catch (PersistenceException e) {
				seguePara(
						"msg",
						"<p style='width:100%;padding:02px 8px;background:#fdd;border:1px solid #f00;'>Ocorreu um erro grave! Consulte os administradores do sistema.</p>",
						"/paginas/cadastro/cadastroFantasia.jsp", rq, rp);
			}
		}

	}

	private void seguePara(String objsession, Object o, String path,
			HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute(objsession, o);
		RequestDispatcher d = req.getRequestDispatcher(path);
		d.forward(req, resp);
	}

}
