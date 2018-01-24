package com.othello.exceptions;

public class InvalidInput extends Exception{

	private static final long serialVersionUID = 1L;

	public InvalidInput() {
		super("Invalid Input. Please try again.");
	}
	
}
