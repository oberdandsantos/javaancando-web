package br.com.allianz.jdbc;

import br.com.allianz.models.Convidado;

public class JdbcConvidadosDao extends JdbcDao {

	public void incluirConvidado(Convidado convidado) throws Exception{
		try {
			String query = "INSERT INTO CONVIDADOS (CPF, IDEVENTO, NOME,EMAIL, TELEFONE) VALUES (?,?,?,?,?)";
			jdbcTemplate.update(query, convidado.getCpf(), convidado.getEvento().getId(),convidado.getNome(),convidado.getEmail(),convidado.getTelefone());
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	
}
