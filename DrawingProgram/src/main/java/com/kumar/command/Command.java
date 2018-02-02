package com.kumar.command;

import java.util.Optional;
import java.util.Scanner;

import com.kumar.exception.DrawingException;
import com.kumar.shapes.BucketFill;
import com.kumar.shapes.Canvas;
import com.kumar.shapes.HorizontalLine;
import com.kumar.shapes.Point;
import com.kumar.shapes.Rectangle;
import com.kumar.shapes.Shape;
import com.kumar.shapes.VerticalLine;

public enum Command {

	C("Canvas") {
		@Override
		public Optional<Shape> read(Scanner lineScanner) {
			Optional<Point> p1 = readPoint(lineScanner);
			if (lineScanner.hasNext()){
				return Optional.empty();
			}
			if (p1.isPresent()) {
				Point p2 = new Point(p1.get().getX()+1, p1.get().getY()+1);
				return Optional.of((Shape) new Canvas(p2));
			} else {
				return Optional.empty();
			}
		}
	},
	L("Line") {
		@Override
		public Optional<Shape> read(Scanner lineScanner) {
			Optional<Point> p1 = readPoint(lineScanner);
			Optional<Point> p2 = readPoint(lineScanner);
			if (lineScanner.hasNext()){
				return Optional.empty();
			}
			if (p1.isPresent() && p2.isPresent()) {
				return createLine(p1, p2);
			}
			return Optional.empty();
		}

		private Optional<Shape> createLine(Optional<Point> p1, Optional<Point> p2) {
			if(p1.get().getX() == p2.get().getX()){
				if(p1.get().getY() < p2.get().getY()){
					return Optional.of((Shape) new VerticalLine(p1.get(), p2.get()));
				}else{
					return Optional.of((Shape) new VerticalLine(p2.get(), p1.get()));
				}
			}else if(p1.get().getY() == p2.get().getY()){
				if(p1.get().getX() < p2.get().getX()){
					return Optional.of((Shape) new HorizontalLine(p1.get(), p2.get()));
				}else{
					return Optional.of((Shape) new HorizontalLine(p2.get(), p1.get()));
				}
			}else{
				throw new IllegalArgumentException(DrawingException.ONLY_HORIZONTAL_OR_VERTICAL_LINES_ARE_SUPPORTED);
			}
		}
	},
	R("Rectangle") {
		@Override
		public Optional<Shape> read(Scanner lineScanner) {
			Optional<Point> p1 = readPoint(lineScanner);
			Optional<Point> p2 = readPoint(lineScanner);
			if (lineScanner.hasNext()){
				return Optional.empty();
			}
			if (p1.isPresent() && p2.isPresent()) {
				if(p1.get().getX() <= p2.get().getX() && p1.get().getY() <= p2.get().getY()){
					return Optional.of((Shape) new Rectangle(p1.get(), p2.get()));	
				}else{
					throw new IllegalArgumentException(DrawingException.FOR_RECTANGLE_X1_Y1_X2_Y2);
				}
			}
			return Optional.empty();
			
		}
	},
	B("Bucketfill") {
		@Override
		public Optional<Shape> read(Scanner lineScanner) {
			String color;

			Optional<Point> p1 = readPoint(lineScanner);
			if (p1.isPresent() && lineScanner.hasNext()) {
				color = lineScanner.next();
				if (lineScanner.hasNext()){
					return Optional.empty();
				}
				if (color.length() == 1) {
					return Optional.of((Shape) new BucketFill(p1.get(), color.charAt(0)));
				}
			}
			return Optional.empty();
		}
	},
	Q("Quit") {
		@Override
		public Optional<Shape> read(Scanner lineScanner) {
			return null;
		}
	};
	
	private String commandName;
	
	Command(String commandName){
		
		this.commandName = commandName;
	}
	
	public String getCommandName(){
		return this.commandName;
	}

	public static String getValidStringPattern() {
		return "[" + Command.C.name() + Command.L.name() + Command.R.name() + Command.B + "]";
	}

	public abstract Optional<Shape> read(Scanner lineScanner);

	private static Optional<Point> readPoint(Scanner lineScanner) {
		int x1 = 0, y1 = 0;
		boolean valid = true;
		if (lineScanner.hasNextInt()) {
			x1 = lineScanner.nextInt();
		} else {
			valid = false;
		}

		if (lineScanner.hasNextInt()) {
			y1 = lineScanner.nextInt();
		} else {
			valid = false;
		}

		if (valid == false) {
			return Optional.empty();
		} else {
			return Optional.of(new Point(x1, y1));
		}
	}
}
