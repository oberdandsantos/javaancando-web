package br.com.allianz.dao;

import br.com.allianz.models.Usuario;
import br.com.allianz.utils.Utils;

public class UsuariosDao extends Dao<Usuario, String> {

	@Override
	public void incluir(Usuario elemento) throws Exception {
		try {
			abrirConexao();
			stmt = cn.prepareStatement("INSERT INTO USUARIOS (NOME, SENNHA, NIVEL) VALUES (?,?,?)");
			stmt.setString(1, elemento.getNome());
			stmt.setString(2, elemento.getSenha());
			stmt.setInt(3, elemento.getNivel());

			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
		
	}

	public Usuario Buscar(String chave, String senha) throws Exception {
		Usuario usuario = null;
		try {
			abrirConexao();
			stmt = cn.prepareStatement("SELECT * FROM USUARIOS WHERE NOME = ? AND SENHA = ?");
			stmt.setString(1, chave);
			stmt.setString(2, Utils.verificarMD5(senha));
			rs = stmt.executeQuery();
			if(rs.next()) {
				usuario = new Usuario();
				usuario.setNome(chave);
				usuario.setNivel(rs.getInt("NIVEL"));
			}
		} catch (Exception e) {
			throw e;
		}finally {
			fecharConexao();
		}
		
		return usuario;
	}
	
	@Override
	public Usuario Buscar(String chave) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
