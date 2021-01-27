package fr.formation.science;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MathsTestTDD {
	private Maths maths = null;
	
	@BeforeEach //S'exécutera avant CHAQUE test
	public void beforeEach() {
		this.maths = new Maths();
	}
	
	@Test
	public void shouldReturn0() {
		assertEquals(0, this.maths.soustraction(1, 1));
		assertEquals(0, this.maths.soustraction(2, 2));
		assertEquals(0, this.maths.soustraction(-2, -2));
	}
	
	@Test
	public void shouldReturn4() {
		assertEquals(4, this.maths.soustraction(9, 5));
	}
	
	@Test
	public void shouldReturn8Negativ() {
		assertEquals(-8, this.maths.soustraction(0, 8));
		assertEquals(-8, this.maths.soustraction(12, 20));
	}
}