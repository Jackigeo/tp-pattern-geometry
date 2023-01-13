package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class WktVisitorTest {

	@Test
	public void testVisitPoint() {
		WktVisitor visitor = new WktVisitor();
		Geometry geometry = new Point(new Coordinate(1.0,2.0));
		geometry.accept(visitor);
		
		Assert.assertEquals("POINT(1.0 2.0)", visitor.getResult());
	}
	
	@Test
	public void testVisitEmptyPoint() {
		WktVisitor visitor = new WktVisitor();
		Geometry geometry = new Point();
		geometry.accept(visitor);
		
		Assert.assertEquals("POINT EMPTY", visitor.getResult());
	}
	
	@Test
	public void testVisitLineString() {
		WktVisitor visitor = new WktVisitor();
		Point a = new Point(new Coordinate(3.0,4.0));
		Point b = new Point(new Coordinate(1.0,3.0));
		
		List<Point> points = new ArrayList<>();
		
		points.add(a);
		points.add(b);
		
		Geometry geometry = new LineString(points);
		
		geometry.accept(visitor);
		
		Assert.assertEquals("LINESTRING(3.0 4.0,1.0 3.0)", visitor.getResult());
	}
	
	@Test
	public void testVisitEmptyLineString() {
		WktVisitor visitor = new WktVisitor();
		Geometry geometry = new LineString();
		geometry.accept(visitor);
		
		Assert.assertEquals("LINESTRING EMPTY", visitor.getResult());
	}
	
	
}
