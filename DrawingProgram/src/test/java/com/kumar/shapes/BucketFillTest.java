package com.kumar.shapes;

import static org.junit.Assert.*;

import org.junit.Test;

import com.kumar.exception.DrawingException;

public class BucketFillTest {

	char graphics[][] = new char[20][4];
	Point p1 = new Point(100, 100);

	@Test
	public void testShouldFailWhenCoordinatesAreOutsideCanvasBoundariesForBucketFill() {

		BucketFill BucketFill = new BucketFill(p1, 'x');
		
		try {
			BucketFill.validate(p1, graphics);
			fail("should fail if co-ordinates are outside canvas boundaries");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), DrawingException.CO_ORDINATES_SHOULD_BE_WITHIN_CANVAS_BOUDARIES);
		}
	}
}
