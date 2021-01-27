package fr.formation.science;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MathsPuissanceTest {
	private Maths maths = null;
	
	@BeforeEach //S'exécutera avant CHAQUE test
	public void beforeEach() {
		this.maths = new Maths();
	}
	
	@Test
	public void shouldReturn4() {
		assertEquals(4, this.maths.puissance(2, 2));
	}
	
	@Test
	public void shouldReturn256() {
		assertEquals(256, this.maths.puissance(4, 4));
	}
	
	@Test
	public void shouldReturn729() {
		assertEquals(729, this.maths.puissance(3, 6));
	}
	
	@Test
	public void shouldReturn1048576() {
		assertEquals(1048576, this.maths.puissance(4, 10));
	}
	
	@Test
	public void shouldReturn1WhenPuissance0() {
		assertEquals(1, this.maths.puissance(3, 0));
	}
	
	@Test
	public void shouldReturn0WhenPuissanceNegative() {
		assertEquals(0, this.maths.puissance(3, -4));
		assertEquals(0, this.maths.puissance(4, -8));
		assertEquals(0, this.maths.puissance(4, -3));
		assertEquals(0, this.maths.puissance(4, -9));
	}
	
	@Test
	public void shouldReturn27Negative() {
		assertEquals(-27, this.maths.puissance(-3, 3));
	}
	
	@Test
	public void shouldReturn81WhenANegative() {
		assertEquals(81, this.maths.puissance(-3, 4));
	}
}