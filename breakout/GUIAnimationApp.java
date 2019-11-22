package breakout;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/** GUI */
public class GUIAnimationApp extends Application {

    private boolean goLeft; // boolean to determine if user has pressed 'A'
    private boolean goRight; // boolean to determine if user has pressed 'D'
    private BarPlayerCharacter barPlayerCharacter = new BarPlayerCharacter(); // creates a barPlayerCharacter object

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(800, 600); // sets width to 800 x 600
        GraphicsContext gc = canvas.getGraphicsContext2D(); // draws the canvas

        barrier(primaryStage, canvas, gc); // outlines the canvas

        Group root = new Group();
        Scene scene = new Scene(root);
        root.getChildren().add(canvas);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Breakout"); // names the application "Breakout"

        /** event listener for key press */
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()){ // indicates whether key has been pressed
                case A: goLeft = true; // changes goLeft to True if key 'A' is pressed
                break;
                case D: goRight = true; // changes goRight to True if key 'D' is pressed
                break;

            }
        });

        /** event listener for key release */
        scene.setOnKeyReleased(event -> {
            switch (event.getCode()){ //indicates whether key has been released
                case A: goLeft = false; // changes goLeft to False if key 'A' is released
                break;
                case D: goRight = false; // changes goRight to False if key 'D' is released
                break;

            }
        });

        primaryStage.show();

        /** animation created to refresh scene and update paddle*/
        AnimationTimer timer = new AnimationTimer(){
            @Override
            public void handle(long now) {

                int x1 = ((barPlayerCharacter.getXcoord()+17)*20); // scales the x coordinate for the left side of barPlayerCharacter from the text-version to GUI
                int x2 = ((barPlayerCharacter.getXcoord()+17)*20)+100; // scales the x coordinate for the right side of barPlayerCharacter from the text-version to GUI
                int y1 = (barPlayerCharacter.getYcoord()*40); // scales the y coordinate for the barPlayerCharacter from the text-version to GUI
                int y2 = (barPlayerCharacter.getYcoord()*40); // scales the y coordinate for the barPlayerCharacter from the text-version to GUI

                /** moves paddle left*/
                if (goLeft && barPlayerCharacter.getXcoord() > -16){ // makes sure paddle does not collide with left side of wall
                    x1 -= 50; // moves the left side of paddle left
                    x2 -= 50; // moves the right side of paddle left
                    barPlayerCharacter.setXcoord(barPlayerCharacter.getXcoord()-1); // stores the new x coordinate so that clearing canvas does not reset the paddle back to middle
                }


                /** moves paddle right*/
                if (goRight && barPlayerCharacter.getXcoord() < 17){ // makes sure paddle does not collide with right side of wall
                    x1 += 50; // moves the left side of paddle right
                    x2 += 50; // moves the right side of paddle right
                    barPlayerCharacter.setXcoord(barPlayerCharacter.getXcoord()+1); // stores the new x coordinate so that clearing canvas does not reset the paddle back to middle
                }

                /** updates paddle to new location*/
                movePaddleTo(x1,y1,x2,y2, gc); // moves the paddle around canvas
            }

        };
        timer.start();
    }

    /** updates paddle to new location*/
    public void movePaddleTo(int x1, int y1, int x2, int y2, GraphicsContext gc){
    gc.clearRect(6,500,789,75); // clears the general area around paddle
    gc.strokeLine(x1,y1,x2,y2); // draws the new paddle with updated coordinates
    }

    /** outlines the canvas to draw barrier */
    public void barrier(Stage primaryStage, Canvas canvas, GraphicsContext gc) {
        gc.setLineWidth(10);
        gc.strokeLine(0,0,800,0); // outlines top border of GUI
        gc.strokeLine(0,600,800,600); // outlines bottom border of GUI
        gc.strokeLine(0,0,0,600); // outlines left border of GUI
        gc.strokeLine(800,0,800,600); // outlines right border of GUI
       // paddle(primaryStage,canvas,gc);
        bricks(primaryStage, canvas, gc); // places bricks on GUI

    }

    /** function to draw bricks on GUI*/
    public void bricks(Stage primaryStage, Canvas canvas, GraphicsContext gc){
        Environment level = new Environment(); // creates a new level object
        level.level1(); // copies level 1 from level class
        ArrayList<DestroyableElements> levelArray = level.getBarrier(); // copies brick placements from level 1

        for(DestroyableElements destroyableElements : levelArray){
            if(destroyableElements.getBrickType() == 0){ // checks if destroyableElements type is 0
                gc.setFill(Color.BLUE); // sets colour to blue
            }
            else if(destroyableElements.getBrickType() == 1){ // checks if destroyableElements type is 1
                gc.setFill(Color.CRIMSON); // sets colour to crimson
            }
            else if(destroyableElements.getBrickType() == 2){ // checks if destroyableElements type is 2
                gc.setFill(Color.ORANGE); // sets colour to orange
            }
            else if(destroyableElements.getBrickType() == 3){ // checks if destroyableElements type is 3
                gc.setFill(Color.FORESTGREEN); // sets colour to forest green
            }
            else if(destroyableElements.getBrickType() == 4){ // checks if destroyableElements type is 4
                gc.setFill(Color.BLACK); // sets colour to black
            }

            gc.fillRect(destroyableElements.getColumnBrick()*20, destroyableElements.getRowBrick()*40, destroyableElements.getBrickLength()*20, 40); //draws the actual bricks on GUI based on their type, length and location on text-based version
        }
    }
}
