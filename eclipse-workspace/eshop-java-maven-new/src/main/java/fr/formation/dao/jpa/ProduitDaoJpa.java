package fr.formation.dao.jpa;

import java.util.List;

import fr.formation.dao.IProduitDao;
import fr.formation.model.Produit;

public class ProduitDaoJpa extends DaoJpa implements IProduitDao {

	@Override
	public List<Produit> findAll() {
		List <Produit> produits = em.createQuery("select p from Produit p",Produit.class).getResultList();
		
		return produits;
	}

	@Override
	public Produit findById(int id) {
		return em.createQuery("select p from Produit p where p.id =?1",Produit.class).
				setParameter(1,id).
				getSingleResult();
	}

	@Override
	public Produit add(Produit entity) {
		em.getTransaction().begin(); 
		em.persist(entity);
		em.getTransaction().commit();
		
		return entity;
	}

	@Override
	public Produit save(Produit entity) {
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
		return entity;
	}

	@Override
	public boolean deleteById(int id) {
		
		try {
			
			
			em.getTransaction().begin(); 
			
			em.createQuery("delete from Produit p where p.id=?1")
			.setParameter(1,id)
			.executeUpdate();
			
			em.getTransaction().commit();
			
			return true;
			
			
		}
		
		catch(Exception ex) {
			em.getTransaction().rollback();
			return false;
		}
	}

}
