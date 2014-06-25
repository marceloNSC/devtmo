package br.carnaval.model.dao.impl;

import javax.persistence.EntityManager;

import br.carnaval.bean.Fantasia;
import br.carnaval.model.dao.DaoJPA;
import br.carnaval.model.dao.FantasiaDao;

public class ImplFantasia extends DaoJPA<Fantasia> implements FantasiaDao {

	public ImplFantasia(EntityManager c) {
		super(c);	
	}

	
}
