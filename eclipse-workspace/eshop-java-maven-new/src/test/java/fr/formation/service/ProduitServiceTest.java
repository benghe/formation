package fr.formation.service;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.formation.dao.IProduitDao;
import fr.formation.exception.LibelleVideException;
import fr.formation.exception.PrixNegatifException;
import fr.formation.model.Produit;

@ExtendWith(MockitoExtension.class) //On démarre le test unit avec Mockito
public class ProduitServiceTest {
	@Mock //Objet à simuler par Mockito (la fonction ne sera pas réellement appelée - donc pas de sauvegarde réelle)
	private IProduitDao daoProduit;
	
	@InjectMocks //Objet dans lequel injecter les mocks (objets simulés)
	private ProduitService srvProduit;
	
	@Test
	public void shouldThrowLibelleVideException() {
		Produit p = new Produit();
		
		p.setLibelle("");
		p.setPrix(new BigDecimal(50));
		
		try {
			this.srvProduit.ajouterProduit(p);
		}
		
		catch (LibelleVideException lve) {
			
		}
		
		Mockito.verify(this.daoProduit, Mockito.never()).add(p);
	}
	
	@Test
	public void shouldThrowPrixNegatifException() {
		Produit p = new Produit();
		
		p.setLibelle("LIBELLE");
		p.setPrix(new BigDecimal(0));
		
		try {
			this.srvProduit.ajouterProduit(p);
		}
		
		catch (PrixNegatifException lve) {
			
		}
		
		Mockito.verify(this.daoProduit, Mockito.never()).add(p);
	}
	
	@Test
	public void shouldCallDaoAdd() {
		Produit p = new Produit();
		
		p.setLibelle("LIBELLE");
		p.setPrix(new BigDecimal(50));
		
		try {
			this.srvProduit.ajouterProduit(p);
		}
		
		catch (LibelleVideException lve) {
			
		}
		
		Mockito.verify(this.daoProduit, Mockito.times(1)).add(p);
	}
}