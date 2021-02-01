package fr.formation.dao.jpa;

import java.util.List;

import fr.formation.dao.IFournisseurDao;
import fr.formation.model.Fournisseur;

public class FournisseurDaoJpa extends DaoJpa implements IFournisseurDao {

	@Override
	public List<Fournisseur> findAll() {

		List <Fournisseur> fournisseurs = em.createQuery("select f from Fournisseur f",Fournisseur.class).getResultList();
		
		return fournisseurs;
	}

	@Override
	public Fournisseur findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fournisseur add(Fournisseur entity) {
		em.getTransaction().begin(); 
		em.persist(entity);
		em.getTransaction().commit();
		
		return entity;
	}

	@Override
	public Fournisseur save(Fournisseur entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
