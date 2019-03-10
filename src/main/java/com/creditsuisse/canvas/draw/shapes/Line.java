package com.creditsuisse.canvas.draw.shapes;

import com.creditsuisse.canvas.draw.coordinates.Coordinates;
import com.creditsuisse.canvas.draw.exception.CanvasException;

public class Line implements Shape {

    private Coordinates coordinatesStart;

    private Coordinates coordinatesEnd;

    public Line(Coordinates start, Coordinates end) {
        this.coordinatesStart = start;
        this.coordinatesEnd = end;
    }

    @Override
    public char[][] draw(char[][] canvasArray) {
        if(validateDimensions()) {
            throw new CanvasException("Start and End coordinates cannot be same, hence line cannot be drawn");
        }
        if(!checkIfCanvasExists(canvasArray)) {
            throw new CanvasException("Canvas doesnt exist.");
        }
        return drawLine(this.coordinatesStart.getX_Axis(), this.coordinatesStart.getY_Axis(), this.coordinatesEnd.getX_Axis(), this.coordinatesEnd.getY_Axis(), canvasArray, 'x');
    }

    @Override
    public Boolean validateDimensions() {
        return ((coordinatesStart.getX_Axis() == coordinatesEnd.getX_Axis()) && (coordinatesStart.getY_Axis() == coordinatesEnd.getY_Axis()));
    }

   /* private char[][] drawLine(Coordinates start, Coordinates end, char[][] canvasArray, char lineChar) {
        for (int i = start.getY_Axis(); i <= end.getY_Axis(); i++) {
            for (int j = start.getX_Axis(); j <= end.getX_Axis(); j++) {
                canvasArray[i][j] = lineChar;
            }
        }
        return canvasArray;
    }*/

}
