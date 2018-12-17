package br.com.allianz.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.allianz.models.Convidado;

@Repository
public class ConvidadosDao {


	@PersistenceContext
	private EntityManager manager;

	public void save(Convidado convidado) {
		manager.persist(convidado);
	}

	public List<Convidado> listar(){
		TypedQuery<Convidado> query = manager.createQuery("Select c from Convidado c", Convidado.class);
		return query.getResultList();
	}
	
	public List<Convidado> listar(int idEvento){
		TypedQuery<Convidado> query = manager.createQuery("Select c from Convidado c where c.evento.id = :id", Convidado.class);
		query.setParameter("id", idEvento);
		return query.getResultList();
	}
}
