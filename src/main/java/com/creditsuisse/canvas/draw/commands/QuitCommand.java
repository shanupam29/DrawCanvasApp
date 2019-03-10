package com.creditsuisse.canvas.draw.commands;

public class QuitCommand extends Command {
    @Override
    public void execute(String[] parameters) {
        if (validateParams(parameters)) {
            System.exit(0);
        }
    }

    @Override
    public Boolean isValidLength(String[] parameters) {
        return parameters.length == 0;
    }

    @Override
    public Boolean validateParams(String[] parameters) {
        return isValidLength(parameters);
    }
}
