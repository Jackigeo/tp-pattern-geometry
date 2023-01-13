package org.acme.geometry;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LineStringTest {
	
	public static final double EPSILON = 1.0e-15;

	@Test
	public void testDefaultConstructor(){
		LineString ls = new LineString();
		Assert.assertEquals(0, ls.getNumPoints());
	}
	
	@Test
	public void testGetPoints(){
		Point a = new Point(new Coordinate(3.0,4.0));
		Point b = new Point(new Coordinate(1.0,3.0));
		
		List<Point> points = new ArrayList<>();
		
		points.add(a);
		points.add(b);
		LineString ls = new LineString(points);
		
		Assert.assertEquals(2, ls.getNumPoints());
	}
	
	@Test
	public void testGetPointN(){
		Point a = new Point(new Coordinate(3.0,4.0));
		Point b = new Point(new Coordinate(1.0,3.0));
		
		List<Point> points = new ArrayList<>();
		
		points.add(a);
		points.add(b);
		LineString ls = new LineString(points);
		
		Assert.assertEquals(a, ls.getPointN(0));
		Assert.assertEquals(b, ls.getPointN(1));
	}
	
	@Test
	public void testGetType(){
		LineString ls = new LineString();
		Assert.assertEquals("LINESTRING", ls.getType());	
	}
	
	@Test
	public void testIsEmpty(){
		LineString ls = new LineString();
	    Assert.assertTrue(ls.isEmpty());	
	}
	
	@Test
	public void testTranslate(){
		
		Point a = new Point(new Coordinate(3.0,4.0));
		Point b = new Point(new Coordinate(1.0,3.0));
		
		List<Point> points = new ArrayList<>();
		
		points.add(a);
		points.add(b);
		LineString ls = new LineString(points);
		
		ls.translate(1.0,1.0);
		
		Assert.assertEquals(4.0,ls.getPointN(0).getCoordinate().getX(),EPSILON);
	    Assert.assertEquals(5.0,ls.getPointN(0).getCoordinate().getY(),EPSILON);
	    
	    Assert.assertEquals(2.0,ls.getPointN(1).getCoordinate().getX(),EPSILON);
	    Assert.assertEquals(4.0,ls.getPointN(1).getCoordinate().getY(),EPSILON);
	    
	}
	
	@Test
	public void testClone(){
		
		Point a = new Point(new Coordinate(3.0,4.0));
		Point b = new Point(new Coordinate(1.0,3.0));
		
		List<Point> points = new ArrayList<>();
		
		points.add(a);
		points.add(b);
		LineString ls = new LineString(points);
		
		Assert.assertEquals(ls.getPointN(0).getCoordinate(), ls.clone().getPointN(0).getCoordinate());
		Assert.assertEquals(ls.getPointN(1).getCoordinate(), ls.clone().getPointN(1).getCoordinate());
		
		LineString lsC = ls.clone();
		ls.translate(1.0, 1.0);
		Assert.assertNotEquals(lsC.getPointN(0).getCoordinate(),ls.getPointN(0).getCoordinate());
		
	}
	
	@Test
	public void testGetEnvelope(){
		
		Point a = new Point(new Coordinate(3.0,4.0));
		Point b = new Point(new Coordinate(1.0,3.0));
		
		List<Point> points = new ArrayList<>();
		
		points.add(a);
		points.add(b);
		LineString ls = new LineString(points);
	
		
		Envelope e = ls.getEnvelope();
		Assert.assertEquals(e.getXmax(), 3.0,EPSILON);
		Assert.assertEquals(e.getXmin(), 1.0,EPSILON);
		Assert.assertEquals(e.getYmax(), 4.0,EPSILON);
		Assert.assertEquals(e.getYmin(), 3.0,EPSILON);
	}
	
	@Test
	public void testAccept() throws UnsupportedEncodingException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
		
		Point a = new Point(new Coordinate(3.0,4.0));
		Point b = new Point(new Coordinate(1.0,3.0));
		
		List<Point> points = new ArrayList<>();
		
		points.add(a);
		points.add(b);
		
		Geometry geometry = new LineString(points);
		
		geometry.accept(visitor);
		
		// result contiendra ce qui est écrit dans la console
		String result = os.toString("UTF8");
		Assert.assertEquals("Je suis une polyligne définie par 2 point(s)", result.trim());
	}
}
