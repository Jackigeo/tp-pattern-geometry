package org.acme.geometry;

public class WktWriter {
	
	public String write(Geometry geometry) {
		
		String wktString;
		
		if ( geometry instanceof Point ){
			
		    Point point = (Point)geometry;
		    
		    if(point.isEmpty()) {
		    	wktString = point.getType() + " EMPTY";
		    } else {
		    	double x = point.getCoordinate().getX();
		    	double y = point.getCoordinate().getY();
		    	
		    	wktString = point.getType() + "("+x+" "+y+")";  	
		    }
		    
		    return wktString;

		}else if ( geometry instanceof LineString ){
		    LineString lineString = (LineString)geometry;
		    
		    if(lineString.isEmpty()) {
		    	wktString = lineString.getType() + " EMPTY";
		    } else {
		    	
		    	wktString = lineString.getType()+ "(";
		    	
		    	for (int i=0; i<lineString.getNumPoints();i++) {
		    		double x = lineString.getPointN(i).getCoordinate().getX();
			    	double y = lineString.getPointN(i).getCoordinate().getY();
			    	
			    	if(i!=0) {
			    		wktString+=",";
			    	}
			    	
			    	wktString+=x+" "+y;  	
		    	}
		    	
		    	wktString +=")";
		    }
		    
		    return wktString;
		}else{
			
		    throw new RuntimeException("geometry type not supported");
		}
		
	}
}
