package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class WktWriterTest {
	
	@Test
	public void testWrite(){
		Point p = new Point();
		
		Point p1 = new Point(new Coordinate(1.0,1.0));
		
		
		LineString ls = new LineString();
		
		Point a = new Point(new Coordinate(3.0,4.0));
		Point b = new Point(new Coordinate(1.0,3.0));
		List<Point> points = new ArrayList<>();
		points.add(a);
		points.add(b);
		LineString ls1 = new LineString(points);
		
		
		
		WktWriter writer = new WktWriter();
		
		
		
		Assert.assertEquals("POINT EMPTY",writer.write(p));
		Assert.assertEquals("POINT(1.0 1.0)",writer.write(p1));
		Assert.assertEquals("LINESTRING EMPTY",writer.write(ls));
		Assert.assertEquals("LINESTRING(3.0 4.0,1.0 3.0)",writer.write(ls1));
	}
	

}
