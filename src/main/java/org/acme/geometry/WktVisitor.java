package org.acme.geometry;

public class WktVisitor implements GeometryVisitor {
    private StringBuilder buffer = new StringBuilder();

    @Override
    public void visit(Point point) {
    	if(point.isEmpty()) {
    		this.buffer.append("POINT EMPTY");
	    } else {
	    	double x = point.getCoordinate().getX();
	    	double y = point.getCoordinate().getY();
	    	
	    	this.buffer.append(point.getType() + "("+x+" "+y+")");  	
	    }
    }
    
    @Override
    public void visit(LineString lineString) {
        if(lineString.isEmpty()){
            this.buffer.append(lineString.getType()+" EMPTY");
        }
        else {
            this.buffer.append(lineString.getType()+"(");
            for (int i=0; i<lineString.getNumPoints();i++) {
            	
            	double x = lineString.getPointN(i).getCoordinate().getX();
		    	double y = lineString.getPointN(i).getCoordinate().getY();
		    	
                if (i != 0) {
                    this.buffer.append(",");
                }
                
                this.buffer.append(x+" "+y);
            }
            
            this.buffer.append(")");
        }
    }
    
    
    public String getResult(){
        return buffer.toString();
    }
}