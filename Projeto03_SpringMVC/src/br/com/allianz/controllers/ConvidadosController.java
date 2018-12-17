package br.com.allianz.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.allianz.jdbc.JdbcConvidadosDao;
import br.com.allianz.jdbc.JdbcEventosDao;
import br.com.allianz.models.Convidado;

@Controller
@RequestMapping("/convidados")
public class ConvidadosController {

	@RequestMapping("/cadastro")	
	public String incluir(ModelMap model) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beanJDBC.xml");
		JdbcEventosDao dao = (JdbcEventosDao) context.getBean("eventosDao");

		try {
			model.addAttribute("eventos", dao.listarEventos());
			return "convidados/incluirConvidados";
		} catch (Exception e) {
			return "erro";
		}
		
	}

	@RequestMapping(value = "/cadconvidado", method=RequestMethod.POST)
	public String incluir(@RequestParam("idEvento") int id, Convidado convidado, ModelMap model) {
		
		try {

			ApplicationContext context = new ClassPathXmlApplicationContext("beanJDBC.xml");
			JdbcEventosDao dao_e = (JdbcEventosDao) context.getBean("eventosDao");
			
			JdbcConvidadosDao dao_c = (JdbcConvidadosDao) context.getBean("convidadosDao");
			convidado.setEvento(dao_e.buscarEvento(id));
			dao_c.incluirConvidado(convidado);
			
			model.addAttribute("eventos", dao_e.listarEventos());
			model.addAttribute("mensagem", "Convidado incluído");

			return "convidados/incluirConvidados";
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}
	}
	
}
