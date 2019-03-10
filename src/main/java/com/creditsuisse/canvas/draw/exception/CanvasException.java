package com.creditsuisse.canvas.draw.exception;

/**
 * @author anupam
 */
public class CanvasException extends RuntimeException {

    private static final long serialVersionUID = 7718828512143293558L;

    public CanvasException() {
        super();
    }

    public CanvasException(String message, Throwable cause) {
        super(message, cause);
    }

    public CanvasException(String message) {
        super(message);
    }

    public CanvasException(Throwable cause) {
        super(cause);
    }

}
