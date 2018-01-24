package com.othello;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.othello.exceptions.InvalidInput;

public class Main {

	public static void main(String[] args) throws IOException {

		Board board = new Board();

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\nBlack Moves first");
		Set<Point> playableMoves = new HashSet<>();;
		board.displayBoard();

		while (true) {
			try {
				playableMoves = board.getPlayableMoves(board.getPlayer());
				if(playableMoves.isEmpty()){
					System.out.println("\n" + board.getPlayer() + " can't play any more moves");
					board.changePlayer();
					playableMoves = board.getPlayableMoves(board.getPlayer());
					if(playableMoves.isEmpty()){
						board.terminate();	
						break;
					}
				}
				//board.displayBoard(playableMoves);
				Point move = CommandReader.getMove(scanner, board.getPlayer());
				if(playableMoves.contains(move)){
					board.playMove(board.getPlayer(), move);
					board.displayBoard();
					board.changePlayer();
				}else{
					System.out.println("Invalid move. Please try again.");
				}
			} catch (InvalidInput e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
