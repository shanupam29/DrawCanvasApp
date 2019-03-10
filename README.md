# Project Title
  Draw Canvas App is to facilitate draw supported shapes such as Canvas, Line, Rectangle and BucketFill Option.

## Prerequisites
   - Windows/Linux Operating System, Java 8, Java IDE(Eclipse/IntelliJ Idea)(Optional)

### Getting Started
   - Download the zip into local IDE(Eclipse or IntelliJ), complile and run the code using main class, Draw Canvas App
     (com.creditsuisse.canvas.draw.app.DrawCanvasApp)

   #### API Details.
   - Standalone App using main class i.e. com.creditsuisse.canvas.draw.app.DrawCanvasApp to run the app.
   - The various shapes are provided using abstraction inside com.creditsuisse.canvas.draw.shapes package.
   - Exception handling using custom exception class com.creditsuisse.canvas.draw.exception.CanvasException.
   - Command handling from the console using Factory class for command inside com.creditsuisse.canvas.draw.command package.
   - Factory method for commands inside CanvasCommandFactory class, which is itself singleton in nature.
   - Coordinates for diffrent shapes provided using bean com.creditsuisse.canvas.draw.coordinates.Coordinates class.

### Design Choices and Assumptions

    - Abstraction using Shape interface.
    - Singleton pattern on the Factory class to ensure no multiple copies of factory class exist.
    - Custom Exception handling to return more user friendly exception.
    - Commands handling using Factory design Pattern.
    - Shape classes(Rectangle,Lines etc) follow single responsibility principle.
    - Application design is made keeping in mind maintainability and ease of further developments.
      eg: Addition of new shapes can be easily achieved by following existing design and adding few more classes.

    #### Assumptions
    - Lines and rectangle can be supported inside canvas range.
    - Lines can be only horizontal or vertical(no inclined lines) for simplicity.

#### Author

   - Anupam Shrivastava
   - shanupam@gmail.com

#### License
   NA

####  Built With
   Java 8, Maven 3, Design Patterns