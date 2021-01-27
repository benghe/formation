package fr.formation.science;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MathsTest {
	//TESTS UNITAIRES
	//ISOLES - INDEPENDANTS LES UNS DES AUTRES
	//LES PLUS SIMPLES POSSIBLES
	
	//CHAQUE TEST UNITAIRE = METHODE QUI RENVOIE RIEN
	//NOM TEST UNITAIRE = NOM DE LA METHODE
	//CHAQUE METHODE TEST UNIT DOIT ETRE ANNOTEE DE @Test
	
	//POUR TESTER, UTILISATION DES ASSERTIONS
	
	//ON PEUT DECLARER DES METHODES QUI S'EXECUTENT AVANT CHAQUE TEST
	//IDEM POUR APRES CHAQUE TEST
	
	private Maths maths = null;
	
	@BeforeEach //S'exécutera avant CHAQUE test
	public void beforeEach() {
		this.maths = new Maths();
	}
	
	@Test
	public void shouldReturn2() {
		assertEquals(2, this.maths.addition(1, 1));
		assertEquals(2, this.maths.addition(0, 2));
		assertEquals(2, this.maths.addition(-1, 3));
		assertEquals(2, this.maths.addition(4, -2));
	}
	
	@Test
	public void shouldReturn5() {
		assertEquals(5, this.maths.addition(2, 3));
	}
}