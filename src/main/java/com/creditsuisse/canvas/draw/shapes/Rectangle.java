package com.creditsuisse.canvas.draw.shapes;

import com.creditsuisse.canvas.draw.coordinates.Coordinates;
import com.creditsuisse.canvas.draw.exception.CanvasException;

public class Rectangle implements Shape {

    private Coordinates coordinatesStart;

    private Coordinates coordinatesEnd;

    public Rectangle(Coordinates coordinatesStart, Coordinates coordinatesEnd) {
        this.coordinatesStart = coordinatesStart;
        this.coordinatesEnd = coordinatesEnd;
    }

    @Override
    public char[][] draw(char[][] canvasArray) {
        if(!validateDimensions()) {
            throw new CanvasException("Start and End coordinates doesn't meet the requirements for rectangular shape.");
        }
        if(!checkIfCanvasExists(canvasArray)) {
            throw new CanvasException("Canvas doesnt exist.");
        }
        return drawRectangle(canvasArray);
    }

    private char[][] drawRectangle(char[][] canvasArray) {
        int x1 = this.coordinatesStart.getX_Axis();
        int y1 = this.coordinatesStart.getY_Axis();
        int x2 = this.coordinatesEnd.getX_Axis();
        int y2 = this.coordinatesEnd.getY_Axis();
        canvasArray = drawLine(x1, y1, x2, y1, canvasArray, 'x');//top horizontal line of rectangle.
        canvasArray = drawLine(x1, y1, x1, y2, canvasArray, 'x');//left vertical line of rectangle.
        canvasArray = drawLine(x2, y1, x2, y2, canvasArray, 'x');//right vertical line of rectangle.
        canvasArray = drawLine(x1, y2, x2, y2, canvasArray, 'x');//bottom horizontal line of rectangle.
        return canvasArray;
    }

    @Override
    public Boolean validateDimensions() {
        return (coordinatesStart.getX_Axis() != coordinatesEnd.getX_Axis() && coordinatesStart.getY_Axis() != coordinatesEnd.getY_Axis());
    }
}
