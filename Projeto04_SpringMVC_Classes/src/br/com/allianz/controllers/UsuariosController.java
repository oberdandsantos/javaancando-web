package br.com.allianz.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.allianz.dao.UsuariosDao;
import br.com.allianz.models.Usuario;
import br.com.allianz.utils.Utils;

@Controller
@Transactional
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	UsuariosDao usuariosDao;

	@RequestMapping("/cadastro")
	public String incluir(ModelMap model) {
		try {
			model.addAttribute("usuarios", usuariosDao);
			return "usuarios/incluirUsuarios";
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}
		
	}

	@RequestMapping(value = "/cadusuario", method=RequestMethod.POST)
	public String incluir(@Valid Usuario usuario, BindingResult result, ModelMap model) {
		
		if(result.hasErrors()) {
			return "forward:/usuarios/cadastro";
		}
		
		try {
			usuario.setSenha(Utils.verificarMD5(usuario.getSenha()));
			usuariosDao.save(usuario);
			model.addAttribute("mensagem", "Usuário incluído");			
			return "usuarios/incluirUsuarios";
			
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}
		
	}
	
}
