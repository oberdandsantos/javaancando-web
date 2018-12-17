package br.com.allianz.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.allianz.dao.EventosDao;
import br.com.allianz.models.Evento;

@Controller
@Transactional
@RequestMapping("/eventos")
public class EventosController {

	@Autowired
	private EventosDao eventosDao;
	
	@RequestMapping("/cadastro")
	public String incluir() {
		return "eventos/incluirEvento";
	}

	@RequestMapping(value="/cadevento", method = RequestMethod.POST)
	public String incluir(Evento evento, ModelMap model) {
		try {
			eventosDao.save(evento);
			model.addAttribute("mensagem", "Evento Incluído");
			return "eventos/incluirEvento";
			
		} catch (Exception e) {
			model.addAttribute("erro".concat(e.getMessage()));
			return "erro";
		}
		
	}

//	@RequestMapping("/lista")
	
}
