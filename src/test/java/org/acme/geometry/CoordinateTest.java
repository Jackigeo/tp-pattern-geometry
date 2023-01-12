package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class CoordinateTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testDefaultConstructor(){
		// TODO
		Coordinate c = new Coordinate();
		Assert.assertEquals(Double.NaN, c.getX(), EPSILON);
		Assert.assertEquals(Double.NaN, c.getY(), EPSILON);
	}
	
	@Test
	public void testParamConstructor(){
		// TODO	
		Coordinate c1 = new Coordinate(0.5,1.0);
		Assert.assertEquals(0.5, c1.getX(), EPSILON);
		Assert.assertEquals(1.0, c1.getY(), EPSILON);
	}
	
	@Test
	public void testIsEmpty(){
		Coordinate c2 = new Coordinate();
        Assert.assertTrue(c2.isEmpty());
	}
	



}
