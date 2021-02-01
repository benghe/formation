package fr.formation.dao.jpa;

import java.util.List;

import fr.formation.dao.ICommentaireDao;
import fr.formation.model.Commentaire;

public class CommentaireDaoJpa extends DaoJpa implements ICommentaireDao{

	@Override
	public List<Commentaire> findAll() {
		List<Commentaire> commentaires = em.createQuery("select co from Commentaire co",Commentaire.class).getResultList();
		
		return commentaires;
	}

	@Override
	public Commentaire findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commentaire add(Commentaire entity) {
		em.getTransaction().begin(); 
		em.persist(entity);
		em.getTransaction().commit();
		
		return entity;
	}

	@Override
	public Commentaire save(Commentaire entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}



}
