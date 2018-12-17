package br.com.allianz.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.allianz.dao.ConvidadosDao;
import br.com.allianz.dao.EventosDao;
import br.com.allianz.models.Convidado;
import br.com.allianz.models.Evento;
import br.com.allianz.viewmodel.ConvidadoVM;

@RestController
@Transactional
@RequestMapping("/api")
public class RestApiController {

	@Autowired
	EventosDao eventosDao;
	
	@Autowired
	ConvidadosDao convidadosDao;
	
	@RequestMapping(value="/convidados", method=RequestMethod.GET,produces="application/json")
	public @ResponseBody List<ConvidadoVM> listar(){
		List<Convidado> convidados = convidadosDao.listar();
		List<ConvidadoVM> vm = new ArrayList<>();
		
		convidados.forEach(c ->
		{
			vm.add(new ConvidadoVM(
					c.getEvento().getId(),
					c.getCpf(),
					c.getNome(),
					c.getTelefone(),
					c.getEmail()
					));
		});
		
		return vm;
	}

	//HTTP POST
	@RequestMapping(value="/convidados", method=RequestMethod.POST)
	@ResponseBody
	public void incluirConvidado(@RequestBody ConvidadoVM vm) {
		try {
			Convidado convidado = new Convidado();
			convidado.setCpf(vm.getCpf());
			convidado.setNome(vm.getNome());
			convidado.setEmail(vm.getEmail());
			convidado.setTelefone(vm.getTelefone());
			
			Evento evento = eventosDao.buscar(vm.getIdEvento());
			convidado.setEvento(evento);
			
			convidadosDao.save(convidado);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
