package fr.formation.science;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MathsTestTDD {

	private Maths maths = null;

	@Before
	public void beforeEach() {
		this.maths = new Maths();

	}

	@Test
	public void shouldReturn0() {
		assertEquals(0, this.maths.soustraction(1, 1));
	}

	@Test
	public void shouldReturn4() {
		assertEquals(4, this.maths.soustraction(9, 5));
	}

	@Test
	public void shouldReturn8Negative() {
		assertEquals(-8, this.maths.soustraction(0, 8));
	}

}
