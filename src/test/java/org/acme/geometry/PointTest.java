package org.acme.geometry;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

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
		Assert.assertEquals("POINT", p.getType());	
	}
	

	@Test
	public void testIsEmpty(){
		Coordinate c = new Coordinate();
		Point p = new Point(c);
	    Assert.assertTrue(p.isEmpty());	
	}
	
	@Test
	public void testTranslate(){
		Point a = new Point(new Coordinate(3.0,4.0));
		
		a.translate(1.0,1.0);
	    Assert.assertEquals(4.0,a.getCoordinate().getX(), EPSILON);	
	    Assert.assertEquals(5.0,a.getCoordinate().getY(), EPSILON);	
	}
	
	@Test
	public void testClone(){
		
		Point a = new Point(new Coordinate(3.0,4.0));
		Assert.assertEquals(a.getCoordinate(), a.clone().getCoordinate());
		
		Point p = a.clone();
		a.translate(1.0, 1.0);
		Assert.assertNotEquals(p.getCoordinate(),a.getCoordinate());
	}
	
	@Test
	public void testGetEnvelope(){
		
		Point a = new Point(new Coordinate(3.0,4.0));
		Envelope e = a.getEnvelope();
		Assert.assertEquals(e.getXmax(), 3.0,EPSILON);
		Assert.assertEquals(e.getXmin(), 3.0,EPSILON);
		Assert.assertEquals(e.getYmax(), 4.0,EPSILON);
		Assert.assertEquals(e.getYmin(), 4.0,EPSILON);
	}
	
	@Test
	public void testAccept() throws UnsupportedEncodingException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
		Geometry geometry = new Point(new Coordinate(1.0,2.0));
		geometry.accept(visitor);
		
		// result contiendra ce qui est écrit dans la console
		String result = os.toString("UTF8");
		Assert.assertEquals("Je suis un point avec x=1.0 et y=2.0", result.trim());
	}
	
	



}
