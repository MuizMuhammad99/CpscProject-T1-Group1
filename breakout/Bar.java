/**
 * @author T1 Group 1
 * CPSC 233 Fall 2019
 */

public class Bar extends Player {

	public int xcoord, ycoord = console.height()-1; // these coordinates are for the bottom left coordinates of the bar

	//Getters

	/**
	 * @return xcoord
	 * method that returns the x coordinate of the bar
	 */
	public int getXcoord() {
		return xcoord;
	}

	/**
	 * @return ycoord
	 * method that returns the y coordinate of the bar
	 */
	public int getYcoord() {
		return ycoord;
	}

	//Setters

	/**
	 * @param xcoord
	 * method that sets the x coordinate of the bar
	 */
	public void setXcoord(int xcoord) {
		this.xcoord = xcoord;
	}

}
