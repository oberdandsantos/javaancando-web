package br.com.allianz.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.allianz.models.Evento;

@Repository
public class EventosDao {

	@PersistenceContext
	private EntityManager manager;

	public void save(Evento evento) {
		manager.persist(evento);
	}
	
	public List<Evento> listar(){
		TypedQuery<Evento> query = manager.createQuery("Select e from Evento e", Evento.class);
		return query.getResultList();
	}
	
	public Evento buscar(int idEvento) {
		TypedQuery<Evento> query = manager.createQuery("Select e from Evento e where e.id = :id", Evento.class);
		query.setParameter("id", idEvento);
		return query.getSingleResult();
	}
}
