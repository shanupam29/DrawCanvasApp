package com.creditsuisse.canvas.draw.shapes;


import com.creditsuisse.canvas.draw.exception.CanvasException;

import java.util.ArrayList;
import java.util.List;

public final class Canvas {

    private Integer height;

    private Integer width;

    private char[][] charArrayForBorder;

    private final static char HORIZONTAL_CHAR = '-';

    private final static char VERTICAL_CHAR = '|';

    private final static char SPACE = ' ';

    private List<Shape> shapes;

    public Canvas(Integer width, Integer height) throws CanvasException {
        //height/width cannot be zero.
        if (height < 1 || width < 1) {
            throw new CanvasException("height or width cannot be zero");
        }
        this.height = height + 2;
        this.width = width + 2;
        charArrayForBorder = new char[this.height][this.width];
        shapes = new ArrayList<>();
    }

    public void appendShapes(Shape shape) {
        this.shapes.add(shape);
    }

    public void drawCanvas() {
        // Method to set the border's using charactor '-' and '|' using array representation matrix.
        for (int row = 0; row < charArrayForBorder.length; row++) {
            for (int col = 0; col < charArrayForBorder[row].length; col++) {
                if (row == 0 || row == charArrayForBorder.length - 1) {//create horizontal lines for only top and bottom index.
                    charArrayForBorder[row][col] = HORIZONTAL_CHAR;
                } else if (col == 0 || col == charArrayForBorder[row].length - 1) {//create vertical lines for only middle index elements.
                    charArrayForBorder[row][col] = VERTICAL_CHAR;
                } else {
                    charArrayForBorder[row][col] = SPACE;
                }
            }
        }
        //Initialise shapes requested by user, i.e. line, rect, fill etc.
        for (Shape shape : shapes) {
            charArrayForBorder = shape.draw(charArrayForBorder);
        }
        printToConsole();
    }

    private void printToConsole() {
        StringBuilder strBuilder = new StringBuilder();
        for(int i=0;i<this.height;i++) {
            for(int j=0;j<this.width;j++) {
                strBuilder.append(this.charArrayForBorder[i][j]);
            }
            strBuilder.append("\n");
        }
        System.out.print(strBuilder.toString().trim());
    }

}
