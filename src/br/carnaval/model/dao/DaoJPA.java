package br.carnaval.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

public class DaoJPA<T> implements IDAOGenerico<T> {

	private EntityManager entity;

	public DaoJPA(EntityManager c) {
		entity = c;
	}

	@Override
	public void save(T t) {
		entity.getTransaction().begin();
		entity.persist(t);
		entity.getTransaction().commit();
	}

	@Override
	public void remover(T t) {
		entity.getTransaction().begin();
		entity.remove(t);
		entity.getTransaction().commit();
	}

	@Override
	public void update(T t) {
		entity.getTransaction().begin();
		entity.merge(t);
		entity.getTransaction().commit();
	}

	@Override
	public T find(Class<T> c, int id) {
		return entity.find(c, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> listAll(Class<T> c, int maxIndex) {
		return entity.createQuery("SELECT O FROM " + c.getSimpleName() + " o")
				.getResultList();
	}

		
	
}
