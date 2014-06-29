package br.carnaval.model.conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class Conexao {

	private static EntityManager entity;
	private static EntityManagerFactory entityFactory= Persistence.createEntityManagerFactory("devtmo");

	private Conexao() {	
	}

	public static EntityManager getInstance() {
		if (entity == null) {
			entity = entityFactory.createEntityManager();
		}
		System.out.println("inicinado metodo getinstance da conexao");
		return entity;
	}

	public static void closeInstance() {
		if (entity.isOpen()) {
			entity.close();
			System.out
					.println("fechando instancia da conexao. O ENTITYMANAGER :"
							+ entity.isOpen());
		}
		if (entityFactory.isOpen()) {
			entityFactory.close();
			System.out
					.println("fechando instancia da conexao. O ENTITYMANAGERfACTORY :"
							+ entityFactory.isOpen());
		}

	}

	
	
	
}