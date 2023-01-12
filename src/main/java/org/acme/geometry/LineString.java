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

	@Override
	public void translate(double dx, double dy) {		
				for(Point point : this.points) {
				
				double x = point.getCoordinate().getX() + dx;
				double y = point.getCoordinate().getY() + dy;
				
				point.translate(dx, dy);
				
			}
				return;
	}
	
	
	

}
