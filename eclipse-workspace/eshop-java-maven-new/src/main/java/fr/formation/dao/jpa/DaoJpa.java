package fr.formation.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DaoJpa {
	protected static EntityManagerFactory emf; // Singleton
	protected EntityManager em;

	public DaoJpa() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("EShopUnit");

		}

		em = emf.createEntityManager();
	}
}
