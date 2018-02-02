package com.kumar.exception;

public class DrawingException extends RuntimeException{

	public static final String ONLY_HORIZONTAL_OR_VERTICAL_LINES_ARE_SUPPORTED = "Only Horizontal or vertical lines are supported";
	
	public static final String FOR_RECTANGLE_X1_Y1_X2_Y2 = "x1, y1 should be the upper left co-ordinates and x2, y2 should be the lower right co-ordinates";
	
	public static final String DRAW_CANVAS_FIRST = "Canvas should be the first item. C W H where W is the width and H is the height";
	
	public static final String CO_ORDINATES_SHOULD_BE_WITHIN_CANVAS_BOUDARIES = "Co-ordinates should be within canvas boundaries";
			
}
