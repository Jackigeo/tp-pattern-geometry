package org.acme.geometry;

public class Point implements Geometry{
	
	private Coordinate coordinate;
	
	public Point() {
		this.coordinate = new Coordinate();
	}
	
	public Point(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	@Override
	public String getType() {
		return "Point";
	}

	@Override
	public Boolean isEmpty() {
		return this.coordinate.isEmpty();
	}

	@Override
	public void translate(double dx, double dy) {
			
			double x = this.coordinate.getX() + dx;
			double y = this.coordinate.getY() + dy;
			
			Coordinate cTranslated = new Coordinate(x,y);
			this.coordinate = cTranslated;
			return;	
	}
	
	@Override
	public Point clone() {
		Point clone = new Point(this.coordinate);
		return clone;	
	}

	@Override
	public Envelope getEnvelope() {
		return new Envelope(this.coordinate,this.coordinate);
	}
		
}
