/**
 * @author T1 Group 1
 * CPSC 233 Fall 2019
 */

public class Bar extends Player {
	
	public BallsPlayerCharacter ball = super.getBall();
	public int xcoord, ycoord = console.height()-1; // these coordinates are for the bottom left coordinates of the bar
	
	/**
	 * initiates the bar object
	 */
	public void initiateBar() { // draws the bar/paddle at the bottom-centre of the screen
		
		xcoord = (console.length()/2)-2;
		for (int i= xcoord; i<= xcoord+4; i++) {
			console.setContent(ycoord, i, "=");
			}
		
	}
	
	/**
	 * @param in
	 * 
	 * method that takes the input and calls the respective methods to move the bar/paddle left or right, or to exit the game, based on input
	 */

	
	public void moveBar(char in) {  
		
		char c = in;
			if (c == 'a' || c == 'A') { // 'a' is designated key for moving bar/paddle left
				gamer.moveLeft();
			} else if (c == 'd' || c == 'D') { // 'd' is designated key for moving bar/paddle right
				gamer.moveRight();
			} else if (c=='e' || c=='E'){
				System.out.println("The END.");
				//break;
			}
			
	}
	
	/**
	 * method that moves the bar/paddle to the right by 1 unit
	 */
	public void moveRight() { 
		if(xcoord<console.length()-5) {
			console.setContent(ycoord, xcoord, " ");
			xcoord ++;
			console.setContent(ycoord, xcoord+4, "=");
		}
	}
	
	/**
	 * method that moves the bar/paddle to the left by 1 unit
	 */
	public void moveLeft() {  
		if(xcoord>1) {
			console.setContent(ycoord, xcoord+4, " ");
			xcoord --;
			console.setContent(ycoord, xcoord, "=");
		}
	}
	
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
	
	/**
	 * @param ycoord
	 * method that sets the y coordinate of the bar
	 */
	public void setYcoord(int ycoord) {
		this.ycoord = ycoord;
	}
}
