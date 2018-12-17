package br.com.allianz.dao;


//import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import br.com.allianz.models.Usuario;

@Repository
public class UsuariosDao {

	@PersistenceContext
	private EntityManager manager;

	public void save(Usuario usuario) {
		manager.persist(usuario);
	}

//	public List<Usuario> listar(){
//		TypedQuery<Usuario> query = manager.createQuery("Select e from Usuario e", Usuario.class);
//		return query.getResultList();
//	}
//	
//	public Usuario buscar(String nome) {
//		TypedQuery<Usuario> query = manager.createQuery("Select e from Usuario e where e.nome = :nome", Usuario.class);
//		query.setParameter("nome", nome);
//		return query.getSingleResult();
//	}

}
