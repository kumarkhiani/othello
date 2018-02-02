package com.kumar.shapes;

import com.kumar.DrawingApplication;

public class Canvas extends Shape{

	protected Point p1;

	protected Point p2;
	
	protected Point p3;
	
	protected Point p4;
	
	public Canvas(Point p2){
		this.p1 = new Point(0,0);
		this.p2 = p2;
		this.p3 = new Point(p1.getX(), p2.getY());
		this.p4 = new Point(p2.getX(), p1.getY());
	}
	
	@Override
	public void draw(char[][] graphics){
		new VerticalLine(p1, p3, DrawingApplication.vertical).draw(graphics);
		new VerticalLine(p4, p2, DrawingApplication.vertical).draw(graphics);
		new HorizontalLine(p1, p4, DrawingApplication.horizontal).draw(graphics);
		new HorizontalLine(p3, p2, DrawingApplication.horizontal).draw(graphics);
	}

	public Point getP2() {
		return p2;
	}

	@Override
	public String toString() {
		return "Canvas [p1=" + p1 + ", p2=" + p2 + "]";
	}

	@Override
	public boolean isValidLocation(int location) {
		return location==0;
	}
	
	@Override
	public void validateCordinates(char[][] graphics){
		if(p2.getX() <= 0 || p2.getY() <= 0){
			throw new IllegalArgumentException("Canvas width and height should be positive integers");
		}
	}
}
