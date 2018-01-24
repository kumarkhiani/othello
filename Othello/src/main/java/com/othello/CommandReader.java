package com.othello;

import java.util.Scanner;

import com.othello.exceptions.InvalidInput;

public class CommandReader {

	public static Point getMove(Scanner scanner, Player player) throws InvalidInput {

		String move = null;
		System.out.print("\n Player '" + player.toString() + "' move: ");
		if (scanner.hasNext()) {
			move = scanner.nextLine();
		}
		return validate(move);
	}

	private static Point validate(String move) throws InvalidInput {
		
		if(move == null || move.length() != 2){
			throw new InvalidInput();
		}
		int row;
		int column;
		move=move.toLowerCase();
		int first = move.charAt(0);
		int second = move.charAt(1);
		if(Character.isDigit(first) && Character.isLetter(second)){
			row = second - 'a';
			column = Character.digit(first,10) - 1;
			validateBoundaries(column, row);
			return new Point(row, column);
		}else if(Character.isLetter(first) && Character.isDigit(second)){
			row = first - 'a';
			column = Character.digit(second,10) - 1;
			validateBoundaries(column, row);
			return new Point(row, column);
		}
		throw new InvalidInput();
	}
	
	private static void validateBoundaries(int x, int y) throws InvalidInput{
		if(x<0 || x>=Board.SIZE || y<0 || y>=Board.SIZE){
			throw new InvalidInput();
		}
	}
}
