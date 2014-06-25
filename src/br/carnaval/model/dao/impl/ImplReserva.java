package br.carnaval.model.dao.impl;

import javax.persistence.EntityManager;

import br.carnaval.bean.Reserva;
import br.carnaval.model.dao.DaoJPA;
import br.carnaval.model.dao.ReservaDao;

public class ImplReserva extends DaoJPA<Reserva> implements ReservaDao {

	public ImplReserva(EntityManager c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	
}
