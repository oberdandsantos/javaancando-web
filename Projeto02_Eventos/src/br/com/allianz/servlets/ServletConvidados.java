package br.com.allianz.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.allianz.dao.ConvidadosDao;
import br.com.allianz.models.Convidado;
import br.com.allianz.models.Evento;
import br.com.allianz.repository.RepositorioDao;

@WebServlet({ "/admin/convidados", "/busca" })
public class ServletConvidados extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletConvidados() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String path = request.getRequestURI();
			List<Evento> listaeventos = RepositorioDao.getEventosDao().ListarEventos();
			if (listaeventos.size() == 0) {
				throw new IllegalArgumentException("Não existem eventos disponíveis");
			}
			request.setAttribute("lista_eventos", listaeventos);
			List<Convidado> listaConvidados;

			if (path.endsWith("busca")) {
				String id = request.getParameter("id"); // id do evento
				if (id != null) {
					listaConvidados = RepositorioDao.getConvidadosDao().ListarConvidados(Integer.parseInt(id));
					request.setAttribute("lista_convidados", listaConvidados);
					request.setAttribute("id_selected", id);
				}
				request.getRequestDispatcher("WEB-INF/views/listaConvidados.jsp").include(request, response);
			} else {
				listaConvidados = RepositorioDao.getConvidadosDao().ListarConvidados();
				request.setAttribute("lista_convidados", listaConvidados);
				request.getRequestDispatcher("WEB-INF/views/cadConvidados.jsp").include(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("erro", "ERRO:" + e.getMessage());
			request.getRequestDispatcher("WEB-INF/views/erro.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			Integer sEvento = Integer.valueOf(request.getParameter("evento"));
			if (sEvento == 0) {
				throw new IllegalArgumentException("Você deve selecionar um Evento");
			}

			String nome = request.getParameter("nome");
			String cpf = request.getParameter("cpf");
			String email = request.getParameter("email");
			String telefone = request.getParameter("telefone");

			Convidado convidado = new Convidado();
			convidado.setNome(nome);
			convidado.setCpf(cpf);
			convidado.setEmail(email);
			convidado.setTelefone(telefone);

			Evento evento = new Evento();
			evento.setId(sEvento);
			convidado.setEvento(evento);

			ConvidadosDao dao = RepositorioDao.getConvidadosDao();
			dao.incluir(convidado);

			request.setAttribute("mensagem", "Convidado incluído com sucesso");
			request.setAttribute("link_retorno", "Convidados");
			request.getRequestDispatcher("WEB-INF/views/sucesso.jsp").forward(request, response);

		} catch (Exception e) {
			request.setAttribute("erro", "ERRO:" + e.getMessage());
			request.getRequestDispatcher("WEB-INF/views/erro.jsp").forward(request, response);
		}
	}

}