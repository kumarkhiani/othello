package com.kumar.shapes;

import static org.junit.Assert.*;

import org.junit.Test;

import com.kumar.exception.DrawingException;

public class LineTest {

	char graphics[][] = new char[20][4];

	Point p1 = new Point(1, 2);
	Point p2 = new Point(100, 2);

	@Test
	public void testShouldFailWhenCoordinatesAreOutsideCanvasBoundariesForHorizontalLine() {

		HorizontalLine horizontalLine = new HorizontalLine(p1, p2);
		try {
			horizontalLine.validate(p2, graphics);
			fail("should fail if co-ordinates are outside canvas boundaries");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), DrawingException.CO_ORDINATES_SHOULD_BE_WITHIN_CANVAS_BOUDARIES);
		}
	}

	@Test
	public void testShouldFailWhenCoordinatesAreOutsideCanvasBoundariesForVerticalLine() {

		VerticalLine verticalLine = new VerticalLine(p1, p2);
		try {
			verticalLine.validate(p2, graphics);
			fail("should fail if co-ordinates are outside canvas boundaries");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), DrawingException.CO_ORDINATES_SHOULD_BE_WITHIN_CANVAS_BOUDARIES);
		}
	}
}
