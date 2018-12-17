package br.com.allianz.jdbc;

import java.util.ArrayList;
import java.util.List;

import br.com.allianz.mapper.EventosMapper;
import br.com.allianz.models.Evento;

public class JdbcEventosDao extends JdbcDao{


	public void incluirEvento(Evento evento) throws Exception{
		try {
			jdbcTemplate.update("INSERT INTO EVENTOS (" + "DESCRICAO, DATA, RESPONSAVEL,PRECO) VALUES (?,?,?,?)",
			evento.getDescricao(),
			evento.getData(),
			evento.getResponsavel(),
			evento.getPreco());
			
		} catch (Exception e) {
			throw e;
		}
	}

	public List<Evento> listarEventos() throws Exception{
		List<Evento> eventos = new ArrayList<>();
		try {
			eventos = jdbcTemplate.query("SELECT * FROM EVENTOS", new EventosMapper()); 
		} catch (Exception e) {
			throw e;
		}
		return eventos;
	} 

	public Evento buscarEvento(int id) throws Exception{
		Evento evento = null;
		try {
			evento = jdbcTemplate.queryForObject("SELECT * FROM EVENTOS WHERE ID=?", new Integer[] {id}, new EventosMapper());
		} catch (Exception e) {
			throw e;
		}
		return evento;
	}
}
