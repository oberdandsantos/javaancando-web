package br.com.allianz.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.allianz.dao.EventosDao;
import br.com.allianz.models.Evento;
import br.com.allianz.models.Usuario;
import br.com.allianz.repository.RepositorioDao;

@WebServlet("/admin/eventos")
public class ServletEventos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletEventos() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuario usuario = (Usuario) request.getSession().getAttribute("sessao_usuario");
		if (usuario == null) {
			response.sendRedirect("login");
		} else {
			try {
				EventosDao dao = RepositorioDao.getEventosDao();
				List<Evento> listaEventos = dao.ListarEventos();
				request.setAttribute("lista_eventos", listaEventos);

				request.getRequestDispatcher("WEB-INF/views/cadEventos.jsp").include(request, response);
			} catch (Exception e) {
				request.setAttribute("erro", "ERRO:" + e.getMessage());
				request.getRequestDispatcher("WEB-INF/views/erro.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String descricao = request.getParameter("descricao");
			String sdata = request.getParameter("data");
			Date data = new SimpleDateFormat("yyyy-MM-dd").parse(sdata);

			String responsavel = request.getParameter("responsavel");
			double preco = Double.parseDouble(request.getParameter("preco"));

			Evento evento = new Evento();
			evento.setDescricao(descricao);
			evento.setData(data);
			evento.setResponsavel(responsavel);
			evento.setPreco(preco);

			EventosDao dao = RepositorioDao.getEventosDao();
			dao.incluir(evento);

			request.setAttribute("mensagem", "Evento incluído com sucesso");
			request.setAttribute("link_retorno", "eventos");
			request.getRequestDispatcher("WEB-INF/views/sucesso.jsp").forward(request, response);

		} catch (Exception e) {
			request.setAttribute("erro", "ERRO:" + e.getMessage());
			request.getRequestDispatcher("WEB-INF/views/erro.jsp").forward(request, response);
		}
	}

}
