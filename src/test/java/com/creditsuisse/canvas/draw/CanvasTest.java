package com.creditsuisse.canvas.draw;

import com.creditsuisse.canvas.draw.coordinates.Coordinates;
import com.creditsuisse.canvas.draw.exception.CanvasException;
import com.creditsuisse.canvas.draw.shapes.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CanvasTest {

    private static final String CANVAS_20BY4= "----------------------\n" +
                                              "|                    |\n" +
                                              "|                    |\n" +
                                              "|                    |\n" +
                                              "|                    |\n" +
                                              "----------------------";

    private static final String CANVAS_20BY4_WITH_LINE ="----------------------\n" +
                                                        "|                    |\n" +
                                                        "|xxxxxx              |\n" +
                                                        "|                    |\n" +
                                                        "|                    |\n" +
                                                        "----------------------";
    private static final String CANVAS_20BY4_WITH_RECTANGLE ="----------------------\n" +
                                                             "|             xxxxx  |\n" +
                                                             "|             x   x  |\n" +
                                                             "|             xxxxx  |\n" +
                                                             "|                    |\n" +
                                                             "----------------------";

    private static final String CANVAS_20BY4_WITH_RECTANGLE_AND_BUCKETFILL = "----------------------\n" +
                                                                             "|oooooooooooooxxxxxoo|\n" +
                                                                             "|ooooooooooooox   xoo|\n" +
                                                                             "|oooooooooooooxxxxxoo|\n" +
                                                                             "|oooooooooooooooooooo|\n" +
                                                                             "----------------------";
    private static final String CANVAS_20BY4_WITH_LINE_RECT_AND_FILL = "----------------------\n" +
                                                                       "|oooooooooooooxxxxxoo|\n" +
                                                                       "|xxxxxxooooooox   xoo|\n" +
                                                                       "|oooooooooooooxxxxxoo|\n" +
                                                                       "|oooooooooooooooooooo|\n" +
                                                                       "----------------------";

    /**
     * - When :  Valid Canvas dimensions.
     * - Given : Width and Height
     * - Expected :  Return Success response with matching the canvas design.
     *
     */
    @Test
    void testCanvas() {
        Canvas canvas  = new Canvas(20, 4);
        assertEquals(canvas.drawCanvas(),CANVAS_20BY4);
    }
    /**
     * - When :  Invalid Canvas dimensions.
     * - Given : Zero Width and positive Height
     * - Expected :  Return Canvas Exception.
     *
     */
    @Test
    void testInvalidCanvas() {
        assertThrows(CanvasException.class,()->new Canvas(0, 4));
    }
    /**
     * - When :  Valid Canvas and Line dimensions.
     * - Given : Width and Height of Canvas and valid line coordinates
     * - Expected :  Return Success response with matching the canvas design.
     *
     */
    @Test
    void testCanvasWithLine() {
        Canvas canvas  = new Canvas(20, 4);
        Coordinates coordinates1 = new Coordinates(1,2);
        Coordinates coordinates2 = new Coordinates(6,2);
        Shape shape = new Line(coordinates1,coordinates2);
        canvas.appendShapes(shape);
        assertEquals(canvas.drawCanvas(),CANVAS_20BY4_WITH_LINE);
    }

    /**
     * - When :  Valid Canvas dimensions and invalid line dimensions.
     * - Given : Width and Height of Canvas and Line length is zero. i.e. same start and end coordinates.
     * - Expected :  Return CanvasException
     *
     */
    @Test
    void testCanvasWithInvalidLine() {
        Canvas canvas  = new Canvas(20, 4);
        Coordinates coordinates1 = new Coordinates(1,2);
        Coordinates coordinates2 = new Coordinates(1,2);
        Shape shape = new Line(coordinates1,coordinates2);
        canvas.appendShapes(shape);
        assertThrows(CanvasException.class,()->canvas.drawCanvas());
    }
    /**
     * - When :  Valid Canvas and Rectangle dimensions.
     * - Given : Width and Height of Canvas and valid rectangle coordinates
     * - Expected :  Return Success response with matching the canvas design.
     *
     */
    @Test
    void testCanvasWithRectangle() {
        Canvas canvas  = new Canvas(20, 4);
        Coordinates coordinates1 = new Coordinates(14,1);
        Coordinates coordinates2 = new Coordinates(18,3);
        Shape shape = new Rectangle(coordinates1,coordinates2);
        canvas.appendShapes(shape);
        assertEquals(canvas.drawCanvas(),CANVAS_20BY4_WITH_RECTANGLE);
    }
    /**
     * - When :  Valid Canvas and Invalid Rectangle dimensions.
     * - Given : Width and Height of Canvas and invalid rectangle coordinates(coordinates not forming rectangle but a line).
     * - Expected :  Return CanvasException.
     *
     */
    @Test
    void testCanvasWithInvalidRectangle() {
        Canvas canvas  = new Canvas(20, 4);
        Coordinates coordinates1 = new Coordinates(14,1);
        Coordinates coordinates2 = new Coordinates(14,3);
        Shape shape = new Rectangle(coordinates1,coordinates2);
        canvas.appendShapes(shape);
        assertThrows(CanvasException.class,()->canvas.drawCanvas());
    }
    /**
     * - When :  Valid Canvas and Rectangle dimensions with bucket Fill.
     * - Given : Width and Height of Canvas and valid rectangle coordinates and Bucket Fill coordinates.
     * - Expected :  Return Success response with matching the canvas design.
     *
     */
    @Test
    void testCanvasWithBucketFill() {
        Canvas canvas  = new Canvas(20, 4);
        Coordinates coordinates1 = new Coordinates(14,1);
        Coordinates coordinates2 = new Coordinates(18,3);
        Shape shape = new Rectangle(coordinates1,coordinates2);
        canvas.appendShapes(shape);
        Coordinates coordinates3 = new Coordinates(10,3);
        Shape shape_fill = new BucketFill(coordinates3,'o');
        canvas.appendShapes(shape_fill);
        assertEquals(canvas.drawCanvas(),CANVAS_20BY4_WITH_RECTANGLE_AND_BUCKETFILL);
    }
    /**
     * - When :  Valid Canvas,Line Rectangle dimensions with bucket Fill.
     * - Given : Width and Height of Canvas and valid Line and Rectangle coordinates and Bucket Fill coordinates.
     * - Expected :  Return Success response with matching the canvas design.
     *
     */
    @Test
    void testCanvasWithLineRectangleAndBucketFill() {
        Canvas canvas  = new Canvas(20, 4);
        Coordinates coordinates1 = new Coordinates(1,2);
        Coordinates coordinates2 = new Coordinates(6,2);
        Shape shape_line = new Line(coordinates1,coordinates2);
        canvas.appendShapes(shape_line);
        Coordinates coordinates3 = new Coordinates(14,1);
        Coordinates coordinates4 = new Coordinates(18,3);
        Shape shape_rect = new Rectangle(coordinates3,coordinates4);
        canvas.appendShapes(shape_rect);
        Coordinates coordinates5 = new Coordinates(10,3);
        Shape shape_fill = new BucketFill(coordinates5,'o');
        canvas.appendShapes(shape_fill);
        assertEquals(canvas.drawCanvas(),CANVAS_20BY4_WITH_LINE_RECT_AND_FILL);
    }



}
