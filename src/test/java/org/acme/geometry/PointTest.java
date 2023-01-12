package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
	
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testDefaultConstructor(){
		// TODO
		Point p = new Point();
		Assert.assertEquals(Double.NaN, p.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(Double.NaN, p.getCoordinate().getY(), EPSILON);
	}
	
	@Test
	public void testParamConstructor(){
		// TODO
		Coordinate c = new Coordinate(0.5,1.0);
		Point p = new Point(c);
		Assert.assertSame(c, p.getCoordinate());	
	}
	
	@Test
	public void testGetType(){
		// TODO
		Coordinate c = new Coordinate(0.5,1.0);
		Point p = new Point(c);
		Assert.assertEquals("Point", p.getType());	
	}
	

	@Test
	public void testIsEmpty(){
		Coordinate c = new Coordinate();
		Point p = new Point(c);
	    Assert.assertTrue(p.isEmpty());	
	}
	



}
