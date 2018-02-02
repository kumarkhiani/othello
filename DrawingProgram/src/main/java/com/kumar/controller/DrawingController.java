package com.kumar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.kumar.command.Command;
import com.kumar.command.CommandReader;
import com.kumar.exception.DrawingException;
import com.kumar.shapes.Canvas;
import com.kumar.shapes.Point;
import com.kumar.shapes.Shape;

public class DrawingController {

	private List<Shape> shapes = new ArrayList<>();

	private char[][] graphics;

	private static String enterCommand = "Enter Command : ";

	final static Logger logger = Logger.getLogger(DrawingController.class);
	
	public void readCommands(Scanner scanner, CommandReader commandReader) {

		displayInputPrompt();
		while (!scanner.hasNext(Command.Q.name())) {
			try {
				Optional<Shape> optionalShape = commandReader.getShape(scanner);
				if (optionalShape.isPresent()) {
					Shape shape = optionalShape.get();
					logger.debug("Got command : " + shape);
					if (isValidLocation(shape)) {
						shape.validateCordinates(graphics);
						shapes.add(shape);
						draw();
					} else {
						System.out.println(DrawingException.DRAW_CANVAS_FIRST);
						logger.debug("Invalid location. List of shapes" + shapes);
					}
				} else {
					System.out.println("Invalid Command");
					logger.debug("Invalid Command : ");
				}
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				logger.debug("IllegalArgumentException : " + e.getMessage());
			}
			displayInputPrompt();
		}
		scanner.close();
	}

	private void draw() {

		for (Shape s : shapes) {
			s.draw(graphics);
		}
		displayGraphics();
	}

	private void displayGraphics() {
		
		for (int i = 0; i < graphics.length; i++) {
			for (int j = 0; j < graphics[i].length; j++) {
				System.out.print(graphics[i][j]);
			}
			System.out.println();
		}
	}

	private boolean isValidLocation(Shape shape) {

		boolean isValid = shape.isValidLocation(shapes.size());

		if (isValid && shape instanceof Canvas) {
			initalizeCanvas(shape);
		}
		return isValid;
	}

	private void initalizeCanvas(Shape shape) {
		
		Point canvasPoint = ((Canvas) shape).getP2();
		graphics = new char[canvasPoint.getY() + 1][canvasPoint.getX() + 1];
	}

	private void displayInputPrompt() {
		
		System.out.print(enterCommand);
	}

	public char[][] getGraphics() {
		
		return graphics;
	}
}
