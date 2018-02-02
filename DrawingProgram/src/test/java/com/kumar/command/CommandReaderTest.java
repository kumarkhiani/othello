package com.kumar.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import org.junit.Test;

import com.kumar.exception.DrawingException;
import com.kumar.shapes.BucketFill;
import com.kumar.shapes.HorizontalLine;
import com.kumar.shapes.Rectangle;
import com.kumar.shapes.Shape;
import com.kumar.shapes.VerticalLine;

public class CommandReaderTest {

	CommandReader commandReader = new CommandReader();

	Scanner scanner;

	private void setUpScanner(String input) {
		ByteArrayInputStream stream = new ByteArrayInputStream(input.getBytes());
		scanner = new Scanner(stream);
	}

	@Test
	public void testInvalidCommands() throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/invalidShapes.txt")));
		String input = reader.readLine();
		while (input != null) {
			setUpScanner(input);
			Optional<Shape> shape = commandReader.getShape(scanner);
			assertFalse(shape.toString(), shape.isPresent());
			input = reader.readLine();
		}
		reader.close();
	}

	@Test
	public void testValidCommands() throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/validShapes.txt")));
		String input = reader.readLine();
		while (input != null) {
			setUpScanner(input);
			Optional<Shape> shape = commandReader.getShape(scanner);
			System.out.println(shape.get());
			assertTrue(shape.toString(), shape.isPresent());
			input = reader.readLine();
		}
		reader.close();
	}

	@Test
	public void testHorizontalLineCommand() throws IOException {

		String input = "L 1 2 3 2";
		setUpScanner(input);
		Optional<Shape> shape = commandReader.getShape(scanner);
		assertTrue(shape.isPresent());
		assertEquals(HorizontalLine.class, shape.get().getClass());
	}

	@Test
	public void testVerticalLineCommand() throws IOException {

		String input = "L 1 2 1 4";
		setUpScanner(input);
		Optional<Shape> shape = commandReader.getShape(scanner);
		assertTrue(shape.isPresent());
		assertEquals(VerticalLine.class, shape.get().getClass());
	}
	
	@Test
	public void testNonHorizontalLineCommand() throws IOException {

		String input = "L 1 2 3 4";
		setUpScanner(input);
		try {
			commandReader.getShape(scanner);
			fail("Should fail for non horizontal or not vertical line");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), DrawingException.ONLY_HORIZONTAL_OR_VERTICAL_LINES_ARE_SUPPORTED);
		}
	}

	@Test
	public void testRectangleCommand() throws IOException {

		String input = "R 1 1 1 1";
		setUpScanner(input);
		Optional<Shape> shape = commandReader.getShape(scanner);
		assertTrue(shape.isPresent());
		assertEquals(Rectangle.class, shape.get().getClass());
	}
	
	@Test
	public void testIncorrectCoordintatesForRectangleCommand() throws IOException {

		String input = "R 3 4 1 2";
		setUpScanner(input);
		try {
			commandReader.getShape(scanner);
			fail("Should fail if x1 y1 is on right or lower of x2 y2");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), DrawingException.FOR_RECTANGLE_X1_Y1_X2_Y2);
		}
	}
	
	@Test
	public void testBucketFillCommand() throws IOException {

		String input = "B 1 2 a";
		setUpScanner(input);
		Optional<Shape> shape = commandReader.getShape(scanner);
		assertTrue(shape.isPresent());
		assertEquals(BucketFill.class, shape.get().getClass());
	}
}
