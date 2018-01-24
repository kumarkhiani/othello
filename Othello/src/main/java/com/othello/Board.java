package com.othello;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Board {

	static final int SIZE = 8;
	private Cell board[][];
	private Player player;
	private Score score;
	
	class Score {
		int xScore;
		int oScore;
	}

	static List<Point> directions = new ArrayList<Point>();

	Board() {
		board = new Cell[SIZE][SIZE];
		score = new Score();
		intializeBoard();
		intializeDirections();
		player = Player.X;
	}

	private void intializeBoard() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				board[i][j] = Cell.EMPTY;
			}
		}
		board[3][3] = Cell.O;
		board[3][4] = Cell.X;
		board[4][3] = Cell.X;
		board[4][4] = Cell.O;
	}

	private void intializeDirections() {

		directions = new ArrayList<Point>();
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (!(i == 0 && j == 0)) {
					directions.add(new Point(i, j));
				}
			}
		}
	}

	public Player getPlayer() {

		return this.player;
	}

	public void changePlayer() {

		player = player.changePlayer();
	}

	public Set<Point> getPlayableMoves(Player player) {

		Player opponentPlayer = player.changePlayer();
		Set<Point> playableMoves = new HashSet<>();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {

				if (board[i][j] == opponentPlayer.getCell()) {
					for (Point direction : directions) {
						int y = i + direction.getY();
						int x = j + direction.getX();
						int Y = y;
						int X = x;
						if (withinBoundaries(x, y) && board[y][x] == Cell.EMPTY) {
							x = x + direction.getX() * -1;
							y = y + direction.getY() * -1;
							while (withinBoundaries(x, y) && board[y][x] == opponentPlayer.getCell()) {
								x = x + direction.getX() * -1;
								y = y + direction.getY() * -1;
							}
							;
							if (withinBoundaries(x, y) && board[y][x] == player.getCell()) {
								playableMoves.add(new Point(X, Y));
							}
						}
					}
				}
			}
		}
		return playableMoves;
	}

	public void playMove(Player player, Point move) {

		board[move.getY()][move.getX()] = player.getCell();
		Player opponentPlayer = player.changePlayer();
		for (Point direction : directions) {
			int y = move.getY() + direction.getY();
			int x = move.getX() + direction.getX();
			if (withinBoundaries(x, y) && board[y][x] == opponentPlayer.getCell()) {
				while (withinBoundaries(x, y) && board[y][x] == opponentPlayer.getCell()) {
					x = x + direction.getX();
					y = y + direction.getY();
				}
				if (withinBoundaries(x, y) && board[y][x] == player.getCell()) {
					while(withinBoundaries(x,y) && !(x == move.getX() && y== move.getY())){
						x = x + direction.getX() * -1;
						y = y + direction.getY() * -1;
						board[y][x] = player.getCell();
					}
				}
			}
		}
		updateScore();
	}

	private boolean withinBoundaries(int x, int y) {
		return x >= 0 && x < Board.SIZE && y >= 0 && y < Board.SIZE;
	}

	public void displayBoard() {

		System.out.println();
		for (int i = 0; i < board.length; i++) {
			System.out.print((i + 1) + " ");
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		char c = 'a';
		System.out.print("  ");
		for (int i = 0; i < SIZE; i++) {
			System.out.print(c++ + " ");
		}
	}

	public void displayBoard(Set<Point> playableMoves) {

		Cell[][] tempBoard = new Cell[SIZE][SIZE];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				tempBoard[i][j] = board[i][j];
			}
		}

		for (Point point : playableMoves) {
			tempBoard[point.getY()][point.getX()] = Cell.POSSIBLE;
		}

		System.out.println();
		for (int i = 0; i < tempBoard.length; i++) {
			System.out.print((i + 1) + " ");
			for (int j = 0; j < tempBoard[i].length; j++) {
				System.out.print(tempBoard[i][j] + " ");
			}
			System.out.println();
		}
		char c = 'a';
		System.out.print("  ");
		for (int i = 0; i < SIZE; i++) {
			System.out.print(c++ + " ");
		}
		System.out.println();
	}

	
	public Score updateScore() {

		score.xScore = 0;
		score.oScore = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == Cell.X) {
					score.xScore++;
				}
				if (board[i][j] == Cell.O) {
					score.oScore++;
				}
			}
		}
		return score;
	}

	public void displayWinner() {
		
		if(score.xScore == score.oScore){
			System.out.print("Its a draw ");
		}else if(score.xScore > score.oScore){
			System.out.print("Player '" + Player.X + "' wins (" + score.xScore + " vs " + score.oScore + ")");
		} else{
			System.out.print("Player '" + Player.O + "' wins (" + score.xScore + " vs " + score.oScore + ")");
		}
	}

	public void terminate() {
		System.out.println("No further moves available");
		displayWinner();
	}
}
