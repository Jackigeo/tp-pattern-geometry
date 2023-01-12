package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class EnvelopeBuilderTest {
	
	public static final double EPSILON = 1.0e-15;
	
	@Test
	public void testInsertBuild(){
		
		EnvelopeBuilder builder = new EnvelopeBuilder();
		
		Envelope emptyEnvelope = builder.build();
		Assert.assertTrue(emptyEnvelope.isEmpty());
		
		builder.insert(new Coordinate(1.0,2.0));
		builder.insert(new Coordinate(0.0,3.0));
		builder.insert(new Coordinate(1.0,3.0));
		
		Envelope envelope = builder.build();
		
		Assert.assertEquals(0.0, envelope.getXmin(), EPSILON);
		Assert.assertEquals(1.0, envelope.getXmax(), EPSILON);
		Assert.assertEquals(2.0, envelope.getYmin(), EPSILON);
		Assert.assertEquals(3.0, envelope.getYmax(), EPSILON);
	}
}
