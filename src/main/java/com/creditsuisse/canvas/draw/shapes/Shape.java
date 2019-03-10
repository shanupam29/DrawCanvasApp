package com.creditsuisse.canvas.draw.shapes;

public interface Shape<T> {

    public char[][] draw(char[][] canvasArray);

    public Boolean validateDimensions();

    public default Boolean checkIfCanvasExists(char[][] canvasArray) {
        return canvasArray != null;
    }

    public default char[][] drawLine(int x1, int y1, int x2, int y2, char[][] canvasArray, char lineChar) {
        //providing looping using x and y coordinates for readability purpose.
        for (int row = y1; row <= y2; row++) {
            for (int col = x1; col <= x2; col++) {
                canvasArray[row][col] = lineChar;
            }
        }
        return canvasArray;
    }


}
