package fr.formation.dao.jpa;

import java.util.List;

import fr.formation.dao.ICategorieDao;
import fr.formation.model.Categorie;

public class CategorieDaoJpa extends DaoJpa implements ICategorieDao{

	@Override
	public List<Categorie> findAll() {
		
		
		List <Categorie> categories = em.createQuery("select c from Categorie c",Categorie.class).getResultList();
		
		return categories;
	}

	@Override
	public Categorie findById(int id) {
		// TODO Auto-generated method stub
		return null;
		
	}

	@Override
	public Categorie add(Categorie entity) {
		
		
		em.getTransaction().begin(); 
		em.persist(entity);
		em.getTransaction().commit();
		
		return entity;
	
	}
	
	

	@Override
	public Categorie save(Categorie entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
