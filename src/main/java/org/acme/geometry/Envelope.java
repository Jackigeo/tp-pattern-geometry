package org.acme.geometry;

public class Envelope {
	
	private Coordinate bottomLeft;
	private Coordinate topRight;
	
	Envelope(){
		this.bottomLeft = new Coordinate();
		this.topRight = new Coordinate();
	};
	
	Envelope(Coordinate bLeft, Coordinate tRight){
		
		this.bottomLeft = bLeft;
		this.topRight = tRight;
	};
	
	public Boolean isEmpty() {
		return bottomLeft.isEmpty() || topRight.isEmpty();
	}
	
	public double getXmin() {
		return this.bottomLeft.getX();
		
	}
	
	public double getYmin() {
		return topRight.getY();
		
	}
	
	public double getXmax() {
		return this.topRight.getX();
		
	}
	
	public double getYmax() {
		return bottomLeft.getY();	
	}


}
