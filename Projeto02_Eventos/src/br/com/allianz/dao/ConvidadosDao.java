package br.com.allianz.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.allianz.models.Convidado;
import br.com.allianz.repository.RepositorioDao;

public class ConvidadosDao extends Dao<Convidado, String> {

	@Override
	public void incluir(Convidado elemento) throws Exception {
		try {
			abrirConexao();
			stmt = cn.prepareStatement("INSERT INTO CONVIDADOS (CPF, IDEVENTO, NOME,EMAIL, TELEFONE) VALUES (?,?,?,?,?)");
			stmt.setString(1, elemento.getCpf());
			stmt.setInt(2, elemento.getEvento().getId());
			stmt.setString(3, elemento.getNome());
			stmt.setString(4, elemento.getEmail());
			stmt.setString(5, elemento.getTelefone());

			stmt.executeUpdate();

		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
	}

	@Override
	public Convidado Buscar(String chave) throws Exception {
		Convidado convidado = null;
		try {
			abrirConexao();
			stmt = cn.prepareStatement("SELECT * FROM CONVIDADOS WHERE CPF=?");
			stmt.setString(1, chave);
			rs = stmt.executeQuery();
			if (rs.next()) {
				convidado = new Convidado();
				convidado.setCpf(rs.getString("CPF"));
				convidado.setNome(rs.getString("NOME"));
				convidado.setEmail(rs.getString("EMAIL"));
				convidado.setTelefone(rs.getString("TELEFONE"));
				convidado.setEvento(RepositorioDao.getEventosDao().Buscar(rs.getInt("IDEVENTO")));
			}

		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
		return convidado;
	}

	public List<Convidado> ListarConvidados(int... id) throws Exception {
		List<Convidado> convidados = new ArrayList<>();
		try {
			if(id.length > 1) {
				throw new IllegalArgumentException("Este método admite no máximo UM parâmentro");
			}
			abrirConexao();
			if (id.length == 1) {
				stmt = cn.prepareStatement("SELECT * FROM CONVIDADOS WHERE IDEVENTO=?");
				stmt.setInt(1, id[0]);
			} else {
				stmt = cn.prepareStatement("SELECT * FROM CONVIDADOS");
			}
			rs = stmt.executeQuery();
			while(rs.next()) {				
				Convidado convidado = new Convidado();
				convidado.setCpf(rs.getString("CPF"));
				convidado.setNome(rs.getString("NOME"));
				convidado.setEmail(rs.getString("EMAIL"));
				convidado.setTelefone(rs.getString("TELEFONE"));
				convidado.setEvento(RepositorioDao.getEventosDao().Buscar(rs.getInt("IDEVENTO")));
				
				convidados.add(convidado);
			}

		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
		return convidados;
	}

}
