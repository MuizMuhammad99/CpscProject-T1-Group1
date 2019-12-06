/**
 * @author T1 Group 1
 * CPSC 233 Fall 2019
 */

public class BallGUI {
	private double xcoord;
	private double ycoord;

	/**
	 * default constructor
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
