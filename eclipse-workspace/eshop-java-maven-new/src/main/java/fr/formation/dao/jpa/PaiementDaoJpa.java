package fr.formation.dao.jpa;

import java.util.List;

import fr.formation.dao.IPaiementDao;
import fr.formation.model.Paiement;

public class PaiementDaoJpa extends DaoJpa implements IPaiementDao {

	@Override
	public List<Paiement> findAll() {
		List <Paiement> paiements = em.createQuery("select p from Paiement p",Paiement.class).getResultList();
		
		return paiements;
	}

	@Override
	public Paiement findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paiement add(Paiement entity) {
		em.getTransaction().begin(); 
		em.persist(entity);
		em.getTransaction().commit();
		
		return entity;
	}

	@Override
	public Paiement save(Paiement entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
