package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString implements Geometry {
	
	private List<Point> points;
	
	public LineString() {
		this.points = new ArrayList<>();
		
	};
	
	public LineString(List<Point> points) {
		this.points = points;
	};
	
	public int getNumPoints() {
		return this.points.size();
	}
	
	public Point getPointN(int n) {	
		Point p = this.points.get(n);
		return p;			
	}

	@Override
	public String getType() {
		return "LineString";
	}

	@Override
	public Boolean isEmpty() {
		return points.isEmpty();
	}
	
	
	

}
