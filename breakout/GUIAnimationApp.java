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

/** GUI */
public class GUIAnimationApp extends Application {

    private boolean goLeft; // boolean to determine if user has pressed 'A'
    private boolean goRight; // boolean to determine if user has pressed 'D'
    private boolean GO; // boolean to determine if user has pressed 'L'
    private boolean faster; // boolean to determine if user has pressed 'J'
    private boolean slower; // boolean to determine if user has pressed 'K'

    private Player player = new Player(); // creates a player object
    private BallGUI ball = new BallGUI();
    Environment environment = new Environment();

    private double w;
    private double h;

    private double refreshX = 2;
    private double refreshY = 2;

    private int score = 0;


    @Override

    /**
     * @param primaryStage is the stage in which everything is drawn
     */
    public void start(Stage primaryStage) {
        environment = new Environment(20,38);
        Canvas canvas = new Canvas(1000, 760); // sets width to 1000 x 760
        GraphicsContext gc = canvas.getGraphicsContext2D(); // draws the canvas

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
                    break;
                case J: faster = true;
                    break;
                case K: slower = true;
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
                case L: GO = false;
                    break;
                case J: faster = false;
                    break;
                case K: slower = false;
                    break;
            }
        });

        environment.level1();


        primaryStage.show();


        /** animation created to refresh scene and update paddle*/
        AnimationTimer timer = new AnimationTimer(){
            @Override
            public void handle(long now) {

                int x1 = ((player.getXcoord()+17)*20); // scales the x coordinate for the left side of player from the text-version to GUI
                int x2 = ((player.getXcoord()+17)*20)+100; // scales the x coordinate for the right side of player from the text-version to GUI
                int y1 = (player.getYcoord()*38); // scales the y coordinate for the player from the text-version to GUI
                int y2 = (player.getYcoord()*38); // scales the y coordinate for the player from the text-version to GUI




                /** moves paddle left*/
                if (goLeft && player.getXcoord() > -16){ // makes sure paddle does not collide with left side of wall
                    x1 -= 50; // moves the left side of paddle left
                    x2 -= 50; // moves the right side of paddle left
                    player.setXcoord(player.getXcoord()-1); // stores the new x coordinate so that clearing canvas does not reset the paddle back to middle
                }


                /** moves paddle right*/
                if (goRight && player.getXcoord() < 17){ // makes sure paddle does not collide with right side of wall
                    x1 += 50; // moves the left side of paddle right
                    x2 += 50; // moves the right side of paddle right
                    player.setXcoord(player.getXcoord()+1); // stores the new x coordinate so that clearing canvas does not reset the paddle back to middle
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

                    }
                }
                gc.clearRect(20,20,770,700);
                barrier(gc); // outlines the canvas

                for(DestroyableElements brick: environment.getBarrier()){
                    if (
                            ball.getXcoord() >= brick.getBrickX() && //left
                            ball.getYcoord() >= brick.getBrickY() && //top
                            ball.getXcoord() <= brick.getBrickLengthGUI()+brick.getBrickX() && //right
                            ball.getYcoord() <= brick.getBrickY()+40 //bottom

                    ){

                        if (
                            ball.getXcoord() >= brick.getBrickX()-5 && //left
                            ball.getYcoord() >= brick.getBrickY()+5 && //top
                            ball.getXcoord() <= brick.getBrickX() + brick.getBrickLengthGUI()+5 && //right
                            ball.getYcoord() <= brick.getBrickY()+35 //bottom
                        ){
                            refreshX *= -1;
                            destroyBrick(brick);
                        }
                        else if (
                            ball.getXcoord() >= brick.getBrickX() && //left
                            ball.getYcoord() >= brick.getBrickY()-5 && //top
                            ball.getXcoord() <= brick.getBrickX() + brick.getBrickLengthGUI() && //right
                            ball.getYcoord() <= brick.getBrickY()+45 //bottom
                        ){
                            refreshY *= -1;
                            destroyBrick(brick);
                        }

                        score +=10;
                    }
                }

                ball.setXcoord(ball.getXcoord()+refreshX);
                ball.setYcoord(ball.getYcoord()+refreshY);

                if (score == 750) {
                    gc.setFill(Color.BLACK);
                    gc.clearRect(0, 0, 1000, 760);
                    gc.fillText("YOU WIN!", 500, 350);
                    gc.fillText("SCORE: " + score, 500,380);
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

                if (faster){
                    if(getRefreshX() > 0){
                        setRefreshX(getRefreshX() + 1);
                    }
                    if(getRefreshX() < 0){
                        setRefreshX(getRefreshX() - 1);
                    }

                    if(getRefreshY() > 0){
                        setRefreshY(getRefreshY() + 1);
                    }
                    if(getRefreshY() < 0){
                        setRefreshY(getRefreshY() - 1);
                    }
                }

                if (slower){
                    if(getRefreshX() > 0){
                        setRefreshX(getRefreshX()*0.50);
                    }
                    if(getRefreshX() < 0){
                        setRefreshX(getRefreshX()*0.50);
                    }

                    if(getRefreshY() > 0){
                        setRefreshY(getRefreshY()*0.50);
                    }
                    if(getRefreshY() < 0){
                        setRefreshY(getRefreshY()*0.50);
                    }
                }



                /** updates paddle to new location*/
                movePaddleTo(x1,y1,x2,y2, gc); // moves the paddle around canvas
                moveBallTo(ball.getXcoord(),ball.getYcoord(),w,h,gc);
                teleporters(gc);
            }

        };
        timer.start();
    }

    /**
     * @param brick is the brick which is hit by ball
     */
    private void destroyBrick(DestroyableElements brick) {
        if(brick.getBrickType()!=-1){
            brick.setBrickType(brick.getBrickType()-1);
        }
        if(brick.getBrickType() == -1){
            ArrayList<DestroyableElements> tempArray = new ArrayList<>(Arrays.asList(environment.getBarrier()));
            tempArray.remove(brick);
            environment.setBarrier(tempArray.toArray(new DestroyableElements[tempArray.size()]));
        }
    }

    /** updates paddle to new location
     * @param x1 is the top left x-coordinate of the paddle
     * @param y1 is the top left y-coordinate of the paddle
     * @param x2 is the top right x-coordinate of the paddle
     * @param y2 is the top right y-coordinate of the paddle
     * @param gc is used to call draw commands on canvas
     */
    public void movePaddleTo(int x1, int y1, int x2, int y2, GraphicsContext gc){
        gc.clearRect(6,700,789,27); // clears the general area around paddle
        gc.strokeLine(x1,y1,x2,y2); // draws the new paddle with updated coordinates
    }


    /** updates ball to new location
     * @param x is the top left x-coordinate of the ball
     * @param y is the top left y-coordinate of the ball
     * @param w is the width of the ball
     * @param h is the height of the ball
     * @param gc is used to call draw commands on canvas
     */
    public void moveBallTo(double x, double y, double w,double h, GraphicsContext gc){
        gc.setFill(Color.DEEPPINK);
        gc.fillOval(x,y,w ,h);
    }

    /** outlines the canvas to draw barrier
     * @param gc is used to call draw commands on canvas
     */
    public void barrier(GraphicsContext gc) {
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


        bricks(gc); // places bricks on GUI

    }

    /** function to draw bricks on GUI
     * @param gc is used to call draw commands on canvas
     */
    public void bricks(GraphicsContext gc){
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

    /** draws teleporters to move ball
     * @param gc is used to call draw commands on canvas
     */

    public void teleporters(GraphicsContext gc){
        gc.setFill(Color.MEDIUMPURPLE); // sets colour to black
        gc.fillRect(0,500,5,150);

        if ((ball.getXcoord() >= 0 && ball.getXcoord() <= 8) && (ball.getYcoord() >= 490 && ball.getYcoord() <= 660)){
            gc.setFill(Color.WHITE);
            gc.fillOval(ball.getXcoord()-1,ball.getYcoord()-1,w+1.5 ,h+1.5);
            ball.setXcoord(750);
            ball.setYcoord(150);
            gc.setFill(Color.BLACK); // sets colour to black


        }

        gc.fillRect(795,150,5,150);
        gc.setFill(Color.BLACK); // sets colour to black
    }

    /** getter for refreshX
     * @return refreshX
     */
    public double getRefreshX() {
        return refreshX;
    }

    /**setter for refreshX
     * @param refreshX
     */
    public void setRefreshX(double refreshX) {
        this.refreshX = refreshX;
    }

    /**getter for refreshY
     * @return refreshY
     */
    public double getRefreshY() {
        return refreshY;
    }

    /**setter for refreshY
     * @param refreshY
     */
    public void setRefreshY(double refreshY){
        this.refreshY = refreshY;
    }

}
