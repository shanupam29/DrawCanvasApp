package com.creditsuisse.canvas.draw.shapes;

import com.creditsuisse.canvas.draw.coordinates.Coordinates;
import com.creditsuisse.canvas.draw.exception.CanvasException;

public class BucketFill implements Shape {

    private Coordinates point;

    private char color;

    public BucketFill(Coordinates point, char color) {
        this.point = point;
        this.color = color;
    }

    @Override
    public char[][] draw(char[][] canvasArray) {
        if (!checkIfCanvasExists(canvasArray)) {
            throw new CanvasException("Canvas doesnt exist.");
        }
        int x = point.getX_Axis();
        int y = point.getY_Axis();
        return bucketFill(x,y,canvasArray);
    }

    private char[][] bucketFill(int x, int y, char[][] canvasArray) {
        if (canvasArray[y][x] == ' ') {// if the current color is none.
            canvasArray[y][x] = this.color;
            //Recursive function to autofill the surrounding coordinates around each point until boundary is found.
            canvasArray = bucketFill(x - 1, y, canvasArray);
            canvasArray = bucketFill(x + 1, y, canvasArray);
            canvasArray = bucketFill(x, y - 1, canvasArray);
            canvasArray = bucketFill(x, y + 1, canvasArray);
        }
        return canvasArray;
    }

    @Override
    public Boolean validateDimensions() {
        return null;
    }

}
