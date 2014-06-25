package br.carnaval.model.dao;

import java.util.List;

public interface IDAOGenerico<T> {

	public void save(T t);

	public void remover(T t);

	public void update(T t);

	public T find(Class<T> c, int id);

	public List<T> listAll(Class<T> c, int maxIndex);

}
