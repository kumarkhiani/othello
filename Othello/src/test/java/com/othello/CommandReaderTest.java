package com.othello;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import com.othello.exceptions.InvalidInput;

public class CommandReaderTest {

	CommandReader commandReader = new CommandReader();
	
	Scanner scanner;

	private void setUpScanner(String input) {
		ByteArrayInputStream stream = new ByteArrayInputStream(input.getBytes());
		scanner = new Scanner(stream);
	}
	
	@Test
	public void testValidCommandsb6() throws IOException, InvalidInput {

		String input = "b6";
		setUpScanner(input);
		Point move = CommandReader.getMove(scanner, Player.X);
		assertEquals(1, move.getX());
		assertEquals(5, move.getY());
	}

	@Test
	public void testValidCommands6b() throws IOException, InvalidInput {

		String input = "6b";
		setUpScanner(input);
		Point move = CommandReader.getMove(scanner, Player.X);
		assertEquals(1, move.getX());
		assertEquals(5, move.getY());
	}

	@Test
	public void testValidCommandsB6() throws IOException, InvalidInput {

		String input = "B6";
		setUpScanner(input);
		Point move = CommandReader.getMove(scanner, Player.X);
		assertEquals(1, move.getX());
		assertEquals(5, move.getY());
	}

	
	@Test
	public void testInvalidCommands() throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/invalidMoves.txt")));
		String input = reader.readLine();
		while (input != null) {
			setUpScanner(input);
			try{
				CommandReader.getMove(scanner, Player.X);
				fail(input + " is a valid move");
			}catch(InvalidInput e){
				
			}
			input = reader.readLine();
		}
		reader.close();
	}
}
