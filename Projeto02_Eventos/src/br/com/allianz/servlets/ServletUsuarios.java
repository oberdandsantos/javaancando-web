package br.com.allianz.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.allianz.models.Usuario;
import br.com.allianz.repository.RepositorioDao;

@WebServlet({ "/login", "/admin/cadusuarios" })
public class ServletUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletUsuarios() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getRequestURI();
		String destino;
		
		if(path.endsWith("cadusuarios")) {
			destino = "WEB-INF/views/cadUsuarios.jsp";
		}else {
			destino = "WEB-INF/views/validarUsuario.jsp";			
		}
		request.getRequestDispatcher(destino).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String destino;
		
		try {
			    String path = request.getRequestURI();
				String nome = request.getParameter("nome");
				String senha = request.getParameter("senha");

				if(path.endsWith("cadusuarios")) {
					destino = "WEB-INF/views/cadUsuarios.jsp";
					int nivel = Integer.parseInt(request.getParameter("nivel"));					
					Usuario usuario = new Usuario();
					usuario.setNome(nome);
					usuario.setSenha(senha);
					usuario.setNivel(nivel);

					RepositorioDao.getUsuariosDao().incluir(usuario);

					request.setAttribute("cad_usuario", "Usuário incluído com sucesso");
					request.getRequestDispatcher(destino).forward(request, response);
					
				}else {
					destino = "WEB-INF/views/validarUsuarios.jsp"; 
				    Usuario usuario = RepositorioDao.getUsuariosDao().Buscar(nome, senha);
					if(usuario == null) {
						request.setAttribute("login_usuario", "Usuário ou senha inválidos");
						request.getRequestDispatcher(destino).forward(request, response);
					}else {
						HttpSession session = request.getSession();
						session.setAttribute("sessao_usuario", usuario);
						response.sendRedirect("/Projeto02_Eventos/admin/eventos");
					}					

				}				
				request.getRequestDispatcher(destino).forward(request, response);									
		} catch (Exception e) {
			request.setAttribute("erro", "ERRO:" + e.getMessage());
			request.getRequestDispatcher("WEB-INF/views/erro.jsp").forward(request, response);
		}
	}
}	