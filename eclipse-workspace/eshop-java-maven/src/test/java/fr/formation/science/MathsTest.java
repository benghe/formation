package fr.formation.science;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MathsTest {
	// TEST UNITAIRES
	// ISOLES - INDEPENDANTS LES UNS DES AUTRES
	// LES PLUS SIMPLES POSSIBLES

	// CHAQUE TEST UNITAIRE EST UNE METHODE QUI NE RENVOIE RIEN DU TOUT
	// NOM TEST UNITAIRE = NOM DE LA METHODE

	// POUR TESTER, UTILISATION DES ASSERTIONS

	// ON PEUT DECLARER DES METHODES QUI S'EXECUTENT AVANT CHAQUE TEST
	// IDEM POUR APRES CHAQUE TEST

	private Maths maths = null;

	@Before
	public void beforeEach() {
		this.maths = new Maths();

	}

	@Test
	public void shouldReturn2() {
		assertEquals(2, this.maths.addition(1, 1));

	}

	@Test
	public void shouldReturn5() {
		assertEquals(5, this.maths.addition(2, 3));

	}
}
