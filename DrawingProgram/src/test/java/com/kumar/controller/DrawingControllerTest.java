package com.kumar.controller;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.Test;

import com.kumar.command.CommandReader;

public class DrawingControllerTest {

	DrawingController drawingController = new DrawingController();

	CommandReader commandReader = new CommandReader();

	Scanner scanner;

	char[][] canvas0by0 = new char[][] { { '-', '-' }, { '-', '-' } };

	char[][] canvas1by1 = new char[][] { { '-', '-', '-' }, { '|', '\u0000', '|' }, { '-', '-', '-' } };

	char[][] canvas_20by4_step1 = new char[][] {
			{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',
					'-' },
			{ '|', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000',
					'\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000',
					'|' },
			{ '|', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000',
					'\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000',
					'|' },
			{ '|', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000',
					'\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000',
					'|' },
			{ '|', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000',
					'\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000',
					'|' },
			{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',
					'-' } };

	char[][] canvas_20by4_step2 = new char[][] {
			{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',
					'-' },
			{ '|', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000',
					'\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000',
					'|' },
			{ '|', 'x', 'x', 'x', 'x', 'x', 'x', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000',
					'\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '|' },
			{ '|', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000',
					'\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000',
					'|' },
			{ '|', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000',
					'\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000',
					'|' },
			{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',
					'-' } };

	char[][] canvas_20by4_step3 = new char[][] {
			{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',
					'-' },
			{ '|', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000',
					'\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000',
					'|' },
			{ '|', 'x', 'x', 'x', 'x', 'x', 'x', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000',
					'\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '|' },
			{ '|', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', 'x', '\u0000', '\u0000', '\u0000', '\u0000',
					'\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000',
					'|' },
			{ '|', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', 'x', '\u0000', '\u0000', '\u0000', '\u0000',
					'\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000',
					'|' },
			{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',
					'-' } };

	char[][] canvas_20by4_step4 = new char[][] {
			{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',
					'-' },
			{ '|', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000',
					'\u0000', '\u0000', '\u0000', 'x', 'x', 'x', 'x', 'x', '\u0000', '\u0000', '|' },
			{ '|', 'x', 'x', 'x', 'x', 'x', 'x', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000',
					'x', '\u0000', '\u0000', '\u0000', 'x', '\u0000', '\u0000', '|' },
			{ '|', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', 'x', '\u0000', '\u0000', '\u0000', '\u0000',
					'\u0000', '\u0000', '\u0000', 'x', 'x', 'x', 'x', 'x', '\u0000', '\u0000', '|' },
			{ '|', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', 'x', '\u0000', '\u0000', '\u0000', '\u0000',
					'\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000',
					'|' },
			{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',
					'-' } };

	char[][] canvas_20by4_step5 = new char[][] {
			{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',
					'-' },
			{ '|', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'o',
					'|' },
			{ '|', 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', '\u0000', '\u0000', '\u0000',
					'x', 'o', 'o', '|' },
			{ '|', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 'x',
					'x', 'x', 'x', 'o', 'o', '|' },
			{ '|', '\u0000', '\u0000', '\u0000', '\u0000', '\u0000', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o',
					'o', 'o', 'o', 'o', 'o', '|' },
			{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',
					'-' } };

	private void setUpScanner(String input) {
		ByteArrayInputStream stream = new ByteArrayInputStream(input.getBytes());
		scanner = new Scanner(stream);
	}

	@Test
	public void testCanvas0by0() {

		String input = "C 0 0\nQ";
		setUpScanner(input);

		drawingController.readCommands(scanner, commandReader);
		char[][] graphics = drawingController.getGraphics();
		assertEquals(canvas0by0, graphics);
	}

	@Test
	public void testCanvas1by1() {

		String input = "C 1 1\nQ";
		setUpScanner(input);

		drawingController.readCommands(scanner, commandReader);
		char[][] graphics = drawingController.getGraphics();
		assertEquals(canvas1by1, graphics);
	}

	@Test
	public void testCanvas20by4_step1() {

		String input = "C 20 4\nQ";
		setUpScanner(input);

		drawingController.readCommands(scanner, commandReader);
		char[][] graphics = drawingController.getGraphics();
		assertEquals(canvas_20by4_step1, graphics);
	}

	@Test
	public void testCanvas20by4_step2() {

		String input = "C 20 4\nL 1 2 6 2\nQ";
		setUpScanner(input);

		drawingController.readCommands(scanner, commandReader);
		char[][] graphics = drawingController.getGraphics();
		assertEquals(canvas_20by4_step2, graphics);
	}

	@Test
	public void testCanvas20by4_step3() {

		String input = "C 20 4\nL 1 2 6 2\nL 6 3 6 4\nQ";
		setUpScanner(input);

		drawingController.readCommands(scanner, commandReader);
		char[][] graphics = drawingController.getGraphics();
		assertEquals(canvas_20by4_step3, graphics);
	}

	@Test
	public void testCanvas20by4_step4() {

		String input = "C 20 4\nL 1 2 6 2\nL 6 3 6 4\nR 14 1 18 3\nQ";
		setUpScanner(input);

		drawingController.readCommands(scanner, commandReader);
		char[][] graphics = drawingController.getGraphics();
		assertEquals(canvas_20by4_step4, graphics);
	}

	@Test
	public void testCanvas20by4_step5() {

		String input = "C 20 4\nL 1 2 6 2\nL 6 3 6 4\nR 14 1 18 3\nB 10 3 o\nQ";
		setUpScanner(input);

		drawingController.readCommands(scanner, commandReader);
		char[][] graphics = drawingController.getGraphics();
		assertEquals(canvas_20by4_step5, graphics);
	}
}
