package com.creditsuisse.canvas.draw.commands;

import com.creditsuisse.canvas.draw.coordinates.Coordinates;
import com.creditsuisse.canvas.draw.exception.CanvasException;
import com.creditsuisse.canvas.draw.shapes.BucketFill;
import com.creditsuisse.canvas.draw.shapes.Rectangle;
import com.creditsuisse.canvas.draw.shapes.Shape;

public class BucketFillCommand extends Command {
    @Override
    public void execute(String[] parameters) {
        if (!validateParams(parameters)) {
            throw new CanvasException("Parameter length for BucketFill shape should be 3 (x1,y1,color)");
        }
        Coordinates coordinates1 = new Coordinates(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]));
        Shape shape = new BucketFill(coordinates1,parameters[2].charAt(0));
        this.getCanvas().appendShapes(shape);
        this.getCanvas().drawCanvas();
    }

    @Override
    public Boolean isValidLength(String[] parameters) {
        return parameters.length ==3;
    }

    @Override
    public Boolean validateParams(String[] parameters) {
        return isValidLength(parameters);
    }
}
