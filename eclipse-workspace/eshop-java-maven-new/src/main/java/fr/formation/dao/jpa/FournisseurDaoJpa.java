package fr.formation.dao.jpa;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.Tuple;

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
		return em.createQuery("select f from Fournisseur f where f.id =?1",Fournisseur.class).
				setParameter(1,id).
				getSingleResult();
		
//		em.close(); //Si on fait ça on a besoin de findAllFetchingProduits pour récupérer les produits
	}
	
	@Override
	public List<Fournisseur> findAllFetchingProduits(){
		List<Fournisseur> fournisseurs = em
				.createQuery("select distinct f from Fournisseur f left join fetch f.produits p",Fournisseur.class)
				.getResultList();
		
		em.close();
		return fournisseurs;
	}
	
	
	@Override
	public int count() {
		return em.createQuery("select count(f) from Fournisseur f", Long.class).getSingleResult().intValue();
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
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
		
//Pour n'utiliser que le save et se débarasser du add		
//		if(entity.getId()>0) {
//			em.merge(entity);
//			
//		}else {
//			em.persist(entity);
//		}
		
		return entity;
	}

	@Override
	public boolean deleteById(int id) {
		
		em.getTransaction().begin(); 
		
		em.createQuery("delete from Fournisseur f where f.id=?1")
		.setParameter(1,id)
		.executeUpdate();
		
		em.getTransaction().commit();
		
		return true;
		
		
//		//Deuxième méthode
//		Fournisseur fournisseur = new Fournisseur();
//		fournisseur.setId(id);
//		try {
//			em.getTransaction().begin(); 
//			em.remove(em.merge(fournisseur));
//			em.getTransaction().commit();
//			return true;
//			
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			return false;
//		}
//		
		
		
	}

}
