package com.othello;

public enum Cell {

	EMPTY {
		@Override
		public String toString() {
			return "-";
		}
	},
	X,
	O,
	POSSIBLE{
		@Override

		public String toString() {
			return "P";
		}
	};

}
