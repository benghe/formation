package fr.formation.science;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MathsPuissanceTest {

	private Maths maths = null;

	@Before
	public void beforeEach() {
		this.maths = new Maths();

	}

	@Test
	public void shouldReturn1() {
		assertEquals(1, this.maths.puissance(0, 0), 0);
		assertEquals(1, this.maths.puissance(10, 0), 0);
		assertEquals(1, this.maths.puissance(1, 1), 0);
	}

	@Test
	public void shouldReturn8() {
		assertEquals(8, this.maths.puissance(2, 3), 0);
	}

	@Test
	public void shouldReturn4() {
		assertEquals(4, this.maths.puissance(-2, 2), 0);
	}

	@Test
	public void shouldReturn1over4() {
		assertEquals(0.25, this.maths.puissance(2, -2), 0);
	}

	@Test
	public void shouldReturnMinus1over4() {
		assertEquals(-0.25, this.maths.puissance(-2, -2), 0);
	}

	@Test
	public void shouldReturnMinus1over8() {
		assertEquals(-0.125, this.maths.puissance(-2, -3), 0);
	}

	@Test
	public void shouldReturn0dot015625() {
		assertEquals(0.015625, this.maths.puissance(4, -3), 0);
	}

	@Test
	public void shouldReturnMinus0dot015625() {
		assertEquals(-0.015625, this.maths.puissance(-4, -3), 0);
	}
}
