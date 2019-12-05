/**
 * @author T1 Group 1
 * CPSC 233 Fall 2019
 */

public class BallGUI {
	Breakout breakout = new Breakout();
	Environment console = breakout.getConsole();
	private double xcoord;
	private double ycoord = console.height()-2;
	BarPlayerCharacter bar = breakout.getBar();
	
	
	/**
	 * @param ball
	 * copy constructor
	 */
	public BallGUI(BallGUI ball) {
		this.xcoord = ball.getXcoord();
		this.ycoord = ball.getYcoord();
	}
	
	/**
	 * default constructor
	 * method that draws the bottom on top of the bar
	 */
	public BallGUI() { 
		xcoord = 400;
		ycoord = 600;
	}
	
	//Getters
	
	/**
	 * @return xcoord
	 * method that returns x coordinate of the ball
	 */
	public double getXcoord() {
		return xcoord;
	}
	
	/**
	 * @return ycoord
	 * method that returns y coordinate of the ball
	 */
	public double getYcoord() {
		return ycoord;
	}

	/**
	 * @param x
	 * @param y
	 * method that updates x and y coordinate of the ball
	 */
	public void moveConditions(double x, double y) {
		this.setXcoord(x+1);
		this.setXcoord(y+1);

	}
	
	//Setters
	
	/**
	 * @param xcoord
	 * method that sets the x coordinate of the ball
	 */
	public void setXcoord(double xcoord) {
		this.xcoord = xcoord;
	}
	
	/**
	 * @param ycoord
	 * method that sets the y coordinate of the ball
	 */
	public void setYcoord(double ycoord) {
		this.ycoord = ycoord;
	}
}
