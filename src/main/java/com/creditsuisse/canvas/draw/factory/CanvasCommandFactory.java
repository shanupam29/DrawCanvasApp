package com.creditsuisse.canvas.draw.factory;

import com.creditsuisse.canvas.draw.commands.*;

import java.util.Optional;

public class CanvasCommandFactory {

    private static CanvasCommandFactory canvasCommandFactory;

    private CanvasCommandFactory(){
        super();
    }

    public static CanvasCommandFactory getInstance() {
        if(null == canvasCommandFactory) {
            canvasCommandFactory = new CanvasCommandFactory();
        }
        return canvasCommandFactory;
    }

    /**
     * Factory method to return the desired command class.
     *
     * @param command
     * @return
     */
    public Optional<Command> getCommand(final String command) {
        if (null != command) {
            if (command.equalsIgnoreCase("c")) {
                return Optional.ofNullable(new CanvasCommand());
            } else if (command.equalsIgnoreCase("l")) {
                return Optional.ofNullable(new LineCommand());
            } else if (command.equalsIgnoreCase("r")) {
                return Optional.ofNullable(new RectangleCommand());
            } else if (command.equalsIgnoreCase("b")) {
                return Optional.ofNullable(new BucketFillCommand());
            } else if (command.equalsIgnoreCase("q")) {
                return Optional.ofNullable(new QuitCommand());
            }

        }
        return null;
    }
}
