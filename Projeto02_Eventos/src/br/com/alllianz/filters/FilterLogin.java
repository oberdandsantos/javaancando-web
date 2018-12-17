package br.com.alllianz.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.allianz.models.Usuario;

@WebFilter("/admin/*")
public class FilterLogin implements Filter {

    public FilterLogin() {

    }

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//Obtendo o HttpServletRequest, HttpServletResponse e HttpSession
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		
		//Verificando se existe o atributo usuario na sessão
		Usuario usuario = (Usuario) session.getAttribute("sessao_usuario");
		if(usuario == null){
			resp.sendRedirect("/Projeto02_Eventos/login");
		}else {
			chain.doFilter(req, resp);			
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
