package com.kumar.shapes;

import com.kumar.exception.DrawingException;

public abstract class Shape {

	public abstract void draw(char[][] graphics);

	public abstract boolean isValidLocation(int location);

	public abstract void validateCordinates(char[][] graphics);
	
	protected void validate(Point p, char[][] graphics) {
		if (p.getX() <= 0 || p.getY() <= 0 || p.getY() >= graphics.length - 1 || p.getX() >= graphics[p.getY()].length - 1) {
			throw new IllegalArgumentException(DrawingException.CO_ORDINATES_SHOULD_BE_WITHIN_CANVAS_BOUDARIES);
		}
	}
}
