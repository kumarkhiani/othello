package com.kumar.shapes;

public class Rectangle extends Shape{

	protected Point p1;

	protected Point p2;
	
	protected Point p3;
	
	protected Point p4;

	public Rectangle(Point p1, Point p2){
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = new Point(p1.getX(), p2.getY());
		this.p4 = new Point(p2.getX(), p1.getY());
	}
	
	@Override
	public void draw(char[][] graphics){
		new VerticalLine(p1, p3).draw(graphics);
		new VerticalLine(p4, p2).draw(graphics);
		new HorizontalLine(p1, p4).draw(graphics);
		new HorizontalLine(p3, p2).draw(graphics);		
	}

	@Override
	public String toString() {
		return "Rectangle [p1=" + p1 + ", p2=" + p2 + "]";
	}
	
	@Override
	public boolean isValidLocation(int location) {
		return location!=0;
	}

	@Override
	public void validateCordinates(char[][] graphics) {
		validate(p1, graphics);
		validate(p2, graphics);
	}
}
