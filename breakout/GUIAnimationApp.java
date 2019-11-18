package breakout;

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
    private Bar bar = new Bar(); // creates a bar object
    private Player player = new Player();
    private BallGUI ball = new BallGUI();

    private boolean GO;


    private double w;
    private double h;

    private int refreshX = 8;
    private int refreshY = 8;


    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(800, 760); // sets width to 800 x 600
        GraphicsContext gc = canvas.getGraphicsContext2D(); // draws the canvas

        barrier(primaryStage, canvas, gc); // outlines the canvas
        Breakout breakout = new Breakout();

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
                case L: GO = true;

            }
        });

        /** event listener for key release */
        scene.setOnKeyReleased(event -> {
            switch (event.getCode()){ //indicates whether key has been released
                case A: goLeft = false; // changes goLeft to False if key 'A' is released
                    break;
                case D: goRight = false; // changes goRight to False if key 'D' is released
                    break;
                case L: GO = false;

            }
        });

        primaryStage.show();


        /** animation created to refresh scene and update paddle*/
        AnimationTimer timer = new AnimationTimer(){
            @Override
            public void handle(long now) {

                int x1 = ((bar.getXcoord()+17)*20); // scales the x coordinate for the left side of bar from the text-version to GUI
                int x2 = ((bar.getXcoord()+17)*20)+100; // scales the x coordinate for the right side of bar from the text-version to GUI
                int y1 = (bar.getYcoord()*38); // scales the y coordinate for the bar from the text-version to GUI
                int y2 = (bar.getYcoord()*38); // scales the y coordinate for the bar from the text-version to GUI





                /** moves paddle left*/
                if (goLeft && bar.getXcoord() > -16){ // makes sure paddle does not collide with left side of wall
                    x1 -= 50; // moves the left side of paddle left
                    x2 -= 50; // moves the right side of paddle left
                    bar.setXcoord(bar.getXcoord()-1); // stores the new x coordinate so that clearing canvas does not reset the paddle back to middle
                }


                /** moves paddle right*/
                if (goRight && bar.getXcoord() < 17){ // makes sure paddle does not collide with right side of wall
                    x1 += 50; // moves the left side of paddle right
                    x2 += 50; // moves the right side of paddle right
                    bar.setXcoord(bar.getXcoord()+1); // stores the new x coordinate so that clearing canvas does not reset the paddle back to middle
                }

                try
                {
                    Thread.sleep(30);
                }
                catch(Exception exec)
                {
                    exec.printStackTrace();
                }

                gc.setFill(Color.WHITE);
                gc.fillOval(ball.getXcoord()-1,ball.getYcoord()-1,w+1.5 ,h+1.5);

                w = 20;
                h = 20;

                barrier( primaryStage, canvas, gc);
                if (ball.getYcoord()> 760-17 || ball.getYcoord() < 3){
                    refreshY*=-1;
                }

                if (ball.getXcoord()> 800-17 || ball.getXcoord() < 3){
                    refreshX*=-1;
                }
                if (ball.getXcoord() >= x1-1 && ball.getXcoord() <= x2+1){
                    if (ball.getYcoord() <= 724 && ball.getYcoord() >= 712) {
                        refreshY*=-1;
                    }
                }
                ball.setXcoord(ball.getXcoord()+refreshX);
                ball.setYcoord(ball.getYcoord()+refreshY);

                System.out.println("x"+ ball.getXcoord() + "y" + ball.getYcoord());



                /** updates paddle to new location*/
                movePaddleTo(x1,y1,x2,y2, gc); // moves the paddle around canvas

                moveBallTo(ball.getXcoord(),ball.getYcoord(),w,h,gc);
            }

        };
        timer.start();
    }

    /** updates paddle to new location*/
    public void movePaddleTo(int x1, int y1, int x2, int y2, GraphicsContext gc){
        gc.clearRect(6,700,789,27); // clears the general area around paddle
        gc.strokeLine(x1,y1,x2,y2); // draws the new paddle with updated coordinates
        System.out.println(y1);
        System.out.println(y2);
    }

    public void moveBallTo(double x, double y, double w,double h, GraphicsContext gc){
        gc.setFill(Color.DEEPPINK);
        gc.fillOval(x,y,w ,h);
    }

    /** outlines the canvas to draw barrier */
    public void barrier(Stage primaryStage, Canvas canvas, GraphicsContext gc) {
        gc.setLineWidth(10);
        gc.strokeLine(0,0,800,0); // outlines top border of GUI
        gc.strokeLine(0,760,800,760); // outlines bottom border of GUI
        gc.strokeLine(0,0,0,800); // outlines left border of GUI
        gc.strokeLine(800,0,800,760); // outlines right border of GUI
        // paddle(primaryStage,canvas,gc);
        bricks(primaryStage, canvas, gc); // places bricks on GUI

    }

    /** function to draw bricks on GUI*/
    public void bricks(Stage primaryStage, Canvas canvas, GraphicsContext gc){
        Environment level = new Environment(); // creates a new level object
        level.level1(); // copies level 1 from level class
        DestroyableElements[] levelArray = level.getBarrier(); // copies brick placements from level 1

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
/*
    public void ball(Stage primaryStage, Canvas canvas, GraphicsContext gc){
        //gc.fillOval(breakout.getBall().getXcoord()*40, getBall().getYcoord()*20,5,5);
        ballStart(primaryStage, canvas, gc);

        if (topRight){
            gc.setFill(Color.WHITE);
            gc.fillOval(x-1,y-1,w+1.5 ,h+1.5);
            gc.setFill(Color.DEEPPINK);
            x += 100;
            y -= 100;
            gc.fillOval(x,y,w ,h);


            return;
        }

        if (topLeft){
            return;
        }

        if (bottomLeft){
            return;
        }

        if (bottomRight){
            return;
        }
    }
*/
}
