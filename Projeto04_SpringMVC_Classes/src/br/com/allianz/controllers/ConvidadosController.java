package br.com.allianz.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.allianz.dao.ConvidadosDao;
import br.com.allianz.dao.EventosDao;
import br.com.allianz.models.Convidado;
import br.com.allianz.viewmodel.ConvidadoVM;

@Controller
@Transactional
@RequestMapping("/convidados")
public class ConvidadosController {

	@Autowired
	EventosDao eventosDao;
	@Autowired
	ConvidadosDao convidadosDao;

	@RequestMapping("/cadastro")
	public String incluir(ModelMap model) {

		try {
			model.addAttribute("eventos", eventosDao.listar());
			return "convidados/incluirConvidados";
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}

	}

	@RequestMapping(value = "/cadconvidado", method = RequestMethod.POST)
	public String incluir(@RequestParam("idEvento") int id, Convidado convidado, ModelMap model) {
		try {
			convidado.setEvento(eventosDao.buscar(id));
			convidadosDao.save(convidado);
			model.addAttribute("eventos", eventosDao.listar());
			model.addAttribute("mensagem", "Convidado inclu�do");

			return "convidados/incluirConvidados";

		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}

	}

	@RequestMapping({ "/lista/{id}", "/lista" })
	public ModelAndView listar(@RequestParam(value = "idEvento", required = false) Integer codigo) {
		ModelAndView model = new ModelAndView();
		model.setViewName("convidados/listaConvidados");
		model.addObject("eventos", eventosDao.listar());

		if (codigo != null && codigo > 0) {
			model.addObject("idSelecionado", codigo);
			model.addObject("convidados", convidadosDao.listar(codigo));
		}
		return model;
	}
	
	//javascript - ajax
	@RequestMapping("/js")
	public String executarJs() {
		return "convidados/exemploJs";
	}
	
	//lista de convidados via ajax
	//1 - Carregando a lista de eventos e mostrando a pagina
	@RequestMapping("/listaAjax")	
	public ModelAndView listarAjax() {
		ModelAndView model = new ModelAndView();
		model.setViewName("convidados/listaConvidadosAjax");
		model.addObject("eventos", eventosDao.listar());
		
		return model;
	}
	
	//2 - Recebendo a requisi��o via Ajax
	@RequestMapping(value="/listaAjaxResult/{idEvento}",
			method=RequestMethod.GET,
			produces="application/json")
	public @ResponseBody List<ConvidadoVM> listaAjaxResult(@PathVariable Integer idEvento){
		
		List<ConvidadoVM> lista = new ArrayList<>();
		convidadosDao.listar(idEvento).forEach(s -> {
			lista.add(new ConvidadoVM(
					s.getEvento().getId(),
					s.getCpf(),
					s.getNome(),
					s.getTelefone(),
					s.getEmail()));
		});
		
		return lista;
	}
	
	
}