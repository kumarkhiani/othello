package com.othello;

public enum Player {

	X {
		@Override
		public Cell getCell() {
			return Cell.X;
		}

		@Override
		public Player changePlayer() {
			return O;
		}
	},
	O {
		@Override
		public Cell getCell() {
			return Cell.O;
		}

		@Override
		public Player changePlayer() {
			return X;
		}
	};

	public abstract Cell getCell();
	
	public abstract Player changePlayer();
}
