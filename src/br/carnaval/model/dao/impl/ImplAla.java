package br.carnaval.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.carnaval.bean.Ala;
import br.carnaval.model.dao.AlaDao;
import br.carnaval.model.dao.DaoJPA;

public class ImplAla extends DaoJPA<Ala> implements AlaDao {

	public ImplAla(EntityManager c) {
		super(c);	
	}

	

}
