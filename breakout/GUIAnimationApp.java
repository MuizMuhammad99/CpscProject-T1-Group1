/**
 * @author T1 Group 1
 * CPSC 233 Fall 2019
 */

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/** GUI */
public class GUIAnimationApp extends Application {

    private boolean goLeft; // boolean to determine if user has pressed 'A'
    private boolean goRight; // boolean to determine if user has pressed 'D'
    private Bar bar = new Bar(); // creates a bar object
    private Player player = new Player();
    private BallGUI ball = new BallGUI();
    Environment environment = new Environment();

    private boolean GO;

    private double w;
    private double h;

    private double refreshX = 8;
    private double refreshY = 8;

    private int score = 0;
    
    

    @Override
    public void start(Stage primaryStage) {
        environment = new Environment(20,38);
        Canvas canvas = new Canvas(1000, 760); // sets width to 800 x 760
        GraphicsContext gc = canvas.getGraphicsContext2D(); // draws the canvas

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

        environment.level1();


        primaryStage.show();


        /**
         * animation created to refresh scene and update paddle
         */
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

                if (GO){
                    System.exit(0);
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

                if (ball.getYcoord()> 760-17 || ball.getYcoord() < 3){
                    refreshY*=-1;
                }

                if (ball.getXcoord()> 800-17 || ball.getXcoord() < 3){
                    refreshX*=-1;

                }
                if (ball.getXcoord() >= x1-1 && ball.getXcoord() <= x2+1){
                    if (ball.getYcoord() <= 724 && ball.getYcoord() >= 712) {
                        refreshY*=-1;

                        //ball.setXcoord(ball.getXcoord()+10);
                        /*
                        if (ball.getXcoord() > x1 && ball.getXcoord() <x1+40){
                            refreshY*=0.25;
                            if (refreshY == 0){
                                refreshY = 0.25;
                            }
                        }
                        if (ball.getXcoord() > x1+60 && ball.getXcoord() <x1+100){
                            refreshY*=0.75;
                            if (refreshY == 0){
                                refreshY = 0.75;
                            }
                        }

                         */
                    }
                }
                gc.clearRect(20,20,770,700);
                try {
                    barrier(primaryStage, canvas, gc); // outlines the canvas
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                int tempInt = 0;
                for(DestroyableElements brick: environment.getBarrier()){
                    if (ball.getXcoord() >= brick.getBrickX() && ball.getXcoord() <= brick.getBrickLengthGUI()+brick.getBrickX() && ball.getYcoord() <= brick.getBrickY()+40 && ball.getYcoord() >= brick.getBrickY()){
                        if(ball.getYcoord() <= brick.getBrickY()+40 && ball.getYcoord() >= brick.getBrickY()){
                            refreshY *= -1;
                            refreshX *= -1;

                        }
                        if(ball.getXcoord() >= brick.getBrickX() && ball.getXcoord() <= brick.getBrickLengthGUI()+brick.getBrickX()){
                            refreshX *= -1;
                        }
                        destroyBrick(brick);
                        score +=10;
                    }
                    tempInt++;
                }

                ball.setXcoord(ball.getXcoord()+refreshX);
                ball.setYcoord(ball.getYcoord()+refreshY);

                if (score == 750) {
                    gc.setFill(Color.BLACK);
                    gc.clearRect(0, 0, 1000, 760);
                    gc.fillText("YOU WIN!", 500, 350);
                    gc.fillText("SCORE: " + score, 500,380);
                    ball.setXcoord(1500);
                    ball.setYcoord(2000);
                    x1 = 1200;
                    x2 = 1300;
                }

                if (ball.getYcoord() >= 730){
                    gc.setFill(Color.BLACK);
                    gc.clearRect(0, 0, 1000, 760);
                    gc.fillText("YOU LOSE!", 500, 350);
                    gc.fillText("SCORE: " + score, 500,380);
                    ball.setXcoord(1500);
                    ball.setYcoord(2000);
                    x1 = 1200;
                    x2 = 1300;
                }

                //System.out.println("x"+ ball.getXcoord() + "y" + ball.getYcoord());



                /** updates paddle to new location*/
                movePaddleTo(x1,y1,x2,y2, gc); // moves the paddle around canvas
                //System.out.println("                  " + x1);
                //System.out.println("                  " + x2);
                moveBallTo(ball.getXcoord(),ball.getYcoord(),w,h,gc);
            }

        };
        timer.start();
    }

    private void destroyBrick(DestroyableElements brick) {
        //System.out.println("Brick type:" + brick.getBrickType());
        if(brick.getBrickType()!=-1){
            brick.setBrickType(brick.getBrickType()-1);
        }
        if(brick.getBrickType() == -1){
            ArrayList<DestroyableElements> tempArray = new ArrayList<>(Arrays.asList(environment.getBarrier()));
            tempArray.remove(brick);
            environment.setBarrier(tempArray.toArray(new DestroyableElements[tempArray.size()]));
        }
    }

    /** updates paddle to new location*/
    public void movePaddleTo(int x1, int y1, int x2, int y2, GraphicsContext gc){
        gc.clearRect(6,700,789,27); // clears the general area around paddle
        gc.strokeLine(x1,y1,x2,y2); // draws the new paddle with updated coordinates
        //System.out.println(y1);
        //System.out.println(y2);
    }

    public void moveBallTo(double x, double y, double w,double h, GraphicsContext gc){
        gc.setFill(Color.DEEPPINK);
        gc.fillOval(x,y,w ,h);
    }

    /** outlines the canvas to draw barrier */
    public void barrier(Stage primaryStage, Canvas canvas, GraphicsContext gc) throws InterruptedException {
        gc.setFill(Color.BLACK);
        gc.setLineWidth(10);
        gc.strokeLine(0,0,800,0); // outlines top border of GUI
        gc.strokeLine(0,760,800,760); // outlines bottom border of GUI
        gc.strokeLine(0,0,0,800); // outlines left border of GUI
        gc.strokeLine(800,0,800,760); // outlines right border of GUI

        gc.strokeLine(800,0,1000,0);
        gc.strokeLine(805,0,805,760);
        gc.strokeLine(810,0,810,760);
        gc.strokeLine(800,760,1000,760);
        gc.strokeLine(1000,0,1000,760);


        gc.clearRect(820,15,170,720);

        gc.setFill(Color.BLACK);
        gc.fillText("SCORE", 885,300);
        gc.fillText("" + score, 885,350);

       // if (score >= 30){
          //  gc.clearRect(0,0,1000,760);
          //  gc.fillText("YOU WIN!", 500,380);
            //Thread.sleep(6000);
            //System.exit(0);

        //}


        bricks(primaryStage, canvas, gc); // places bricks on GUI

    }

    /** function to draw bricks on GUI*/
    public void bricks(Stage primaryStage, Canvas canvas, GraphicsContext gc){
        DestroyableElements[] levelArray = environment.getBarrier(); // copies brick placements from level 1

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
    
    //Getters
    /**
     * @return refreshX
     */

    public double getRefreshX() {
        return refreshX;
    }
    
    /**
     * @return refreshY
     */
    
    public double getRefreshY() {
        return refreshY;
    }
    
    //Setters
    /**
     * @param refreshX
     */

    public void setRefreshX(int refreshX) {
        this.refreshX = refreshX;
    }
    
    /**
     * @param refreshY
     */

   

    public void setRefreshY(int refreshY) {
        this.refreshY = refreshY;
    }

}
