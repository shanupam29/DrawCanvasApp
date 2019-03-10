package com.creditsuisse.canvas.draw.commands;

import com.creditsuisse.canvas.draw.coordinates.Coordinates;
import com.creditsuisse.canvas.draw.shapes.Canvas;

public abstract class Command {

    protected Canvas canvas;

    public abstract void execute(String[] parameters);

    public abstract Boolean isValidLength(String[] parameters);

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public abstract Boolean validateParams(String[] parameters);

    public Boolean checkParamsType(String[] parameters) {
        for(String param: parameters) {
            if(!isInteger(param)){
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    private Boolean isInteger(String parameter) {
        try{
            Integer.parseInt(parameter);
        }catch (NumberFormatException ne){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public Coordinates getCoordinates(Integer x, Integer y) {
        return new Coordinates(x, y);
    }
}
