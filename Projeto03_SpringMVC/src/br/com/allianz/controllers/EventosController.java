package br.com.allianz.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.allianz.jdbc.JdbcEventosDao;
import br.com.allianz.models.Evento;

@Controller
@RequestMapping("/eventos")
public class EventosController {

	@RequestMapping("/cadastro")
	public String incluir() {
		return "eventos/incluirEvento";
	}
	
	@RequestMapping(value="/cadevento", method = RequestMethod.POST)
	public String incluir(Evento evento, ModelMap model) {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("beanJDBC.xml");
			JdbcEventosDao dao = (JdbcEventosDao) context.getBean("eventosDao");
			dao.incluirEvento(evento);
			
			model.addAttribute("mensagem", "Evento Incluído");
			return "eventos/incluirEvento";
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}
		
	}
}
