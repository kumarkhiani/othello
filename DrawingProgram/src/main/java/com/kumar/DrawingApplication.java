package com.kumar;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.kumar.command.CommandReader;
import com.kumar.controller.DrawingController;

public class DrawingApplication {

	public static char horizontal = '-';
	
	public static char vertical = '|';
	
	public static char line = 'x';
	
	final static Logger logger = Logger.getLogger(DrawingController.class);
	
	public static void main(String args[]) {

		logger.info("****************************************************");
		Scanner scanner = new Scanner(System.in);
		CommandReader commandReader = new CommandReader();
		DrawingController drawingController = new DrawingController();
		System.out.println("Drawing Application");
		System.out.println("C w h\t\tTo draw canvas of width w and height h.");
		System.out.println("L x1 y1 x2 y2\tTo draw line from (x1,y1) to (x2,y2)).");
		System.out.println("R x1 y1 x2 y2\tTo create rectangle from (x1,y1) to (x2,y2)).");
		System.out.println("B x y c\t\tTo fill the entire area connected to (x,y) with \"colour\" c.");
		System.out.println("Q\t\tTo quit the program.");
		drawingController.readCommands(scanner, commandReader);
	}

}
