package com.creditsuisse.canvas.draw.commands;

import com.creditsuisse.canvas.draw.exception.CanvasException;
import com.creditsuisse.canvas.draw.shapes.Canvas;

public class CanvasCommand extends Command {
    @Override
    public void execute(String[] parameters) {
        if(!validateParams(parameters)){
            throw new CanvasException("Please check the parameters provided, height and width(of type integer) should be provided.");
        }
        super.canvas = new Canvas(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]));
        canvas.drawCanvas();
    }

    @Override
    public Boolean isValidLength(String[] parameters) {
        return parameters.length ==2;
    }

    @Override
    public Boolean validateParams(String[] parameters) {
        return isValidLength(parameters) && checkParamsType(parameters);
    }
}
