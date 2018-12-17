package br.com.allianz.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.allianz.models.Evento;

public class EventosMapper implements RowMapper<Evento> {

	@Override
	public Evento mapRow(ResultSet rs, int rowNum) throws SQLException {
		Evento evento = new Evento();
		evento.setId(rs.getInt("ID"));
		evento.setDescricao(rs.getString("DESCRICAO"));
		evento.setResponsavel(rs.getString("RESPONSAVEL"));
		evento.setData(rs.getDate("DATA"));
		evento.setPreco(rs.getDouble("PRECO"));
		
		return evento;
	}

}
