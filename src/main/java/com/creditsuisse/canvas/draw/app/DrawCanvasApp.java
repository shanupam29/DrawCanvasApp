package com.creditsuisse.canvas.draw.app;

import com.creditsuisse.canvas.draw.commands.Command;
import com.creditsuisse.canvas.draw.coordinates.Coordinates;
import com.creditsuisse.canvas.draw.factory.CanvasCommandFactory;
import com.creditsuisse.canvas.draw.shapes.*;

import java.util.Arrays;
import java.util.Scanner;

public class DrawCanvasApp {

    private final static String SPACE_DELIM = " ";

    private static Canvas canvas;

    public static void main(String[] args) {
        System.out.println("<-----------Canvas App----------------------->");
        printHelp();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            drawCommands(input);
        }
    }

    private static void drawCommands(String inputCmd) {
        CanvasCommandFactory canvasCommandFactory = CanvasCommandFactory.getInstance();
        Command command;
        if(!inputCmd.equals("")) {
            String[] splitCommand = inputCmd.split(SPACE_DELIM);
            String cmd = splitCommand[0].toLowerCase();
            String[] cmdParams = Arrays.copyOfRange(splitCommand,1, splitCommand.length);
            switch (cmd) {
                case "c":
                    command = canvasCommandFactory.getCommand(cmd).get();
                    command.execute(cmdParams);
                    canvas = command.getCanvas();
                    break;
                case "l":
                    command = canvasCommandFactory.getCommand(cmd).get();
                    command.setCanvas(canvas);
                    command.execute(cmdParams);
                    break;
                case "r":
                    command = canvasCommandFactory.getCommand(cmd).get();
                    command.setCanvas(canvas);
                    command.execute(cmdParams);
                    break;
                case "b" :
                    command = canvasCommandFactory.getCommand(cmd).get();
                    command.setCanvas(canvas);
                    command.execute(cmdParams);
                    break;
                case "q" :
                    command = canvasCommandFactory.getCommand(cmd).get();
                    command.execute(cmdParams);
                    break;
            }
        }

    }

    private static void printHelp() {
        System.out.println("-----------------------------------------------");
        System.out.println("       Please use below commands               ");
        System.out.println("                                               ");
        System.out.println("  Note: Important to create canvas first       ");
        System.out.println("   before issuing other shape commands.        ");
        System.out.println("                                               ");
        System.out.println("   Canvas:     C w h  to create a convas       ");
        System.out.println("   Line:       L x1 y1 x2 y2  to draw a line   ");
        System.out.println("   Rectangle:  R x1 y1 x2 y2  to draw rectangle");
        System.out.println("   BucketFill: B x1 y1 color  to refill        ");
        System.out.println("                                               ");
        System.out.println("   to Quit:    Q  to Exit                      ");
        System.out.println("-----------------------------------------------");
    }
}
