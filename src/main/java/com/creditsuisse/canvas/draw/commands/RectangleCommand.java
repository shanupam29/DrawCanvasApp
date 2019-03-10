package com.creditsuisse.canvas.draw.commands;

import com.creditsuisse.canvas.draw.coordinates.Coordinates;
import com.creditsuisse.canvas.draw.exception.CanvasException;
import com.creditsuisse.canvas.draw.shapes.Line;
import com.creditsuisse.canvas.draw.shapes.Rectangle;
import com.creditsuisse.canvas.draw.shapes.Shape;

public class RectangleCommand extends Command {
    @Override
    public void execute(String[] parameters) {
        if (!validateParams(parameters)) {
            throw new CanvasException("Parameter length for Rectangle shape should be 4 (x1,y1,x2,y2) and of type integer should be supplied");
        }
        Coordinates coordinates1 = new Coordinates(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]));
        Coordinates coordinates2 = new Coordinates(Integer.parseInt(parameters[2]), Integer.parseInt(parameters[3]));
        Shape shape = new Rectangle(coordinates1,coordinates2);
        this.getCanvas().appendShapes(shape);
        this.getCanvas().drawCanvas();
    }

    @Override
    public Boolean isValidLength(String[] parameters) {
        return parameters.length ==4;
    }

    @Override
    public Boolean validateParams(String[] parameters) {
        return isValidLength(parameters) && checkParamsType(parameters);
    }
}
