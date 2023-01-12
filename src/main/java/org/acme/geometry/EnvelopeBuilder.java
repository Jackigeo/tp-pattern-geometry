package org.acme.geometry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnvelopeBuilder {
	
	private List<Double> xVals = new ArrayList<Double>();
	private List<Double> yVals = new ArrayList<Double>();
	
	
	public void insert(Coordinate c) {
		xVals.add(c.getX());
		yVals.add(c.getY());
	}
	
	public Envelope build() {
		if ( xVals.isEmpty() ) {
			return new Envelope();
		}
		
		double xmin=Collections.min(xVals);
		double xmax=Collections.max(xVals);
		double ymin=Collections.min(yVals);
		double ymax=Collections.max(yVals);
		
		Coordinate BL = new Coordinate(xmin,ymax);
		Coordinate TR = new Coordinate(xmax,ymin);
		
		Envelope envelope= new Envelope(BL,TR);
		return envelope;
	}
	
}
	


