package com.kumar.shapes;

public class VerticalLine extends Line {

	public VerticalLine(Point p1, Point p2) {
		super(p1, p2);
	}

	public VerticalLine(Point p1, Point p2, char color) {
		super(p1, p2, color);
	}
	
	@Override
	public void draw(char[][] graphics) {

		int x = p1.getX();
		int y1 = p1.getY();
		int y2 = p2.getY();
		
		for(int i = y1; i<=y2; i++){
			graphics[i][x]= color;
		}
	}
}
