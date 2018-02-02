package com.kumar.shapes;

import com.kumar.DrawingApplication;

public abstract class Line extends Shape {

	protected Point p1;

	protected Point p2;

	protected char color;

	public Line(Point p1, Point p2) {
		this(p1, p2, DrawingApplication.line);
	}

	public Line(Point p1, Point p2, char color) {
		this.color = color;
		this.p1 = p1;
		this.p2 = p2;
	}

	@Override
	public String toString() {
		return "Line [p1=" + p1 + ", p2=" + p2 + "]";
	}

	@Override
	public boolean isValidLocation(int location) {
		return location != 0;
	}

	@Override
	public void validateCordinates(char[][] graphics) {
		validate(p1, graphics);
		validate(p2, graphics);
	}
}
