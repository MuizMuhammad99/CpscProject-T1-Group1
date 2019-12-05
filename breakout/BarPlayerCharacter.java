/**
 * @author T1 Group 1
 * CPSC 233 Fall 2019
 */

import java.util.Scanner;

public class BarPlayerCharacter extends Player{
	private int xcoord, ycoord = console.height()-1; // these coordinates are for the bottom left coordinates of the barPlayerCharacter
	
	
	/**
	 * draws the barPlayerCharacter/paddle at the bottom-centre of the screen
	 */
	public void initiateBar() {  
		
		xcoord = (console.length()/2)-2;
		for (int i= xcoord; i<= xcoord+4; i++) {
			console.setContent(ycoord, i, "=");
			}
		
	}
	
	/**
	 * method that reads the input and calls the respective methods to move the paddle left or right, or to exit the game entirely, based on input
	 */
	
	public void moveBar() { 
		
		char c = 's';
		System.out.println("\n Use 'a' and 'd' as arrows");

		while(c!='e' || c!= 'E') { // 'e' and 'E' are designated keys for exiting game
			if (c == 'a' || c == 'A') { // 'a' is designated key for moving barPlayerCharacter/paddle left
				gamer.moveLeft();
			} else if (c == 'd' || c == 'D') { // 'd' is designated key for moving barPlayerCharacter/paddle right
				gamer.moveRight();
			}
			console.printEnvironment();
			Scanner reader = new Scanner(System.in); // takes the input from the keyboard
			c = reader.next().charAt(0); // will only consider the first character of whatever the user inputs
		}		
	}
	
	/**
	 * @param in
	 *  method that reads the input and calls the respective methods to move the paddle left or right, or to exit the game entirely, based on input
	 */
	
	public void moveBarCopy(char in) { 

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
	 * method that moves the barPlayerCharacter/paddle to the right by 1 unit
	 */
	
	public void moveRight() { 
		if(xcoord<console.length()-5) {
			console.setContent(ycoord, xcoord, " ");
			xcoord ++;
			console.setContent(ycoord, xcoord+4, "=");
		}
	}
	
	/**
	 * method that moves the barPlayerCharacter/paddle to the left by 1 unit
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
	 * method that returns the x coordinate
	 */

	public int getXcoord() {
		return xcoord;
	}
	
	/**
	 * @return ycoord
	 * method that returns the y coordinate
	 */
	
	public int getYcoord() {
		return ycoord;
	}
	
	//Setters
	
	/**
	 * @param xcoord
	 * method that sets the x coordinate
	 */

	public void setXcoord(int xcoord) {
		this.xcoord = xcoord;
	}
	
	/**
	 * @param ycoord
	 * method that sets the y coordinate
	 */

	
	public void setYcoord(int ycoord) {
		this.ycoord = ycoord;
	}
}
