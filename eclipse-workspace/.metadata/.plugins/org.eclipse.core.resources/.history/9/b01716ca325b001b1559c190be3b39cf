package fr.adopteunchat.service;

import java.util.List;

import fr.adopteunchat.dao.IPersonneDao;
import fr.adopteunchat.dao.sql.PersonneDaoSql;
import fr.adopteunchat.model.Personne;

public class PersonneService {
	
	IPersonneDao daoPersonne = new PersonneDaoSql();
	
	
	public List<Personne> findAll() {
		
		return daoPersonne.findAll();

	}
	
	public Personne findById(int id) {
		
		if (id!=0) {
			return daoPersonne.findById(id);
		}
		
		return null;
		
	}
	
	public Personne add(Personne entity) {
		
		if(!entity.getNom().equals("") && entity.getPassword().length()>=6) {
			return daoPersonne.add(entity);
		}
		
		return null;
	}
	

}
