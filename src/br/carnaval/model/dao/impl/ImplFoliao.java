package br.carnaval.model.dao.impl;

import javax.persistence.EntityManager;

import br.carnaval.bean.Foliao;
import br.carnaval.model.dao.DaoJPA;
import br.carnaval.model.dao.FoliaoDao;

public class ImplFoliao extends DaoJPA<Foliao> implements FoliaoDao {

	public ImplFoliao(EntityManager c) {
		super(c);
	}

}
