/**
 * @author T1 Group 1
 * CPSC 233 Fall 2019
 */

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

}
