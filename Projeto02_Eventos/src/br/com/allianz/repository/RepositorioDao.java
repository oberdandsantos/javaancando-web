package br.com.allianz.repository;

import br.com.allianz.dao.ConvidadosDao;
import br.com.allianz.dao.EventosDao;
import br.com.allianz.dao.UsuariosDao;

public class RepositorioDao {

	static EventosDao eventosDao;
	static ConvidadosDao convidadosDao;
	static UsuariosDao usuariosDao;
	
	public static EventosDao getEventosDao() {
		if(eventosDao == null) {
			eventosDao = new EventosDao();
		}
		return eventosDao;
		
	}
	
	public static ConvidadosDao getConvidadosDao() {
		if(convidadosDao == null) {
			convidadosDao = new ConvidadosDao();
		}
		return convidadosDao;
		
	}
	
	public static UsuariosDao getUsuariosDao() {
		if(usuariosDao == null) {
			usuariosDao = new UsuariosDao();
		}
		return usuariosDao;
		
	}

	
}
