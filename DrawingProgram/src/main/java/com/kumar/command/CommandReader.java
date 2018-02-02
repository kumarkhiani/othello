package com.kumar.command;

import java.util.Optional;
import java.util.Scanner;

import com.kumar.shapes.Shape;

public class CommandReader {

	public Optional<Shape> getShape(Scanner scanner) {

		Command command;

		Scanner lineScanner = new Scanner(scanner.nextLine());

		if (lineScanner.hasNext(Command.getValidStringPattern())) {
			command = Command.valueOf(lineScanner.next());
			return command.read(lineScanner);
		}
		lineScanner.close();
		return Optional.empty();
	}
}
