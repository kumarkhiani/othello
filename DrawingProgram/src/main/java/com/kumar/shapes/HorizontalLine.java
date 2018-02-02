package com.kumar.shapes;

public class HorizontalLine extends Line {

	public HorizontalLine(Point p1, Point p2) {
		super(p1, p2);
	}

	public HorizontalLine(Point p1, Point p2, char color) {
		super(p1, p2, color);
	}

	@Override
	public void draw(char[][] graphics) {

		int x1 = p1.getX();
		int x2 = p2.getX();
		int y = p1.getY();
		
		for(int i = x1; i<=x2; i++){
			graphics[y][i]= this.color;
		}
	}
}
