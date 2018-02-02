package com.kumar.shapes;

import com.kumar.DrawingApplication;

public class BucketFill extends Shape {

	protected char color;

	protected Point p1;

	public BucketFill(Point p1, char color) {
		this.color = color;
		this.p1 = p1;
	}

	@Override
	public void draw(char[][] graphics) {

		fillCanvas(graphics, p1.getX(), p1.getY());
	}

	private void fillCanvas(char[][] graphics, int x, int y) {
		if (x <= 0 || y <= 0 || y >= graphics.length - 1 || x >= graphics[y].length - 1 || graphics[y][x] == color || graphics[y][x] == DrawingApplication.line) {
			return;
		} else {
			if (graphics[y][x] != color) {
				graphics[y][x] = color;
				fillCanvas(graphics, x + 1, y);
				fillCanvas(graphics, x - 1, y);
				fillCanvas(graphics, x, y + 1);
				fillCanvas(graphics, x, y - 1);
			}
		}
	}

	@Override
	public String toString() {
		return "BucketFill [p1=" + p1 + ", c=" + color + "]";
	}

	@Override
	public boolean isValidLocation(int location) {
		return location != 0;
	}

	@Override
	public void validateCordinates(char[][] graphics){
		validate(p1, graphics);
	}
}
