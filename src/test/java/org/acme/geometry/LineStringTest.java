package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LineStringTest {

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
		Assert.assertEquals("LineString", ls.getType());	
	}
}
