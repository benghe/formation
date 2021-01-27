package fr.formation.dao.sql;

import java.util.List;

import fr.formation.dao.ICommandeDao;
import fr.formation.model.Commande;

public class CommandeDaoSql extends DaoSql implements ICommandeDao {
	@Override
	public List<Commande> findAll() {
		this.openConnection();
		return null;
	}

	@Override
	public Commande findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commande add(Commande entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commande save(Commande entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}
}