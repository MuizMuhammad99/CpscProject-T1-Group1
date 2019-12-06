package breakout;

import java.util.Scanner;

public class BarPlayerCharacter extends Player{
	private int xcoord, ycoord = console.height()-1; // these coordinates are for the bottom left coordinates of the barPlayerCharacter
	
	public void initiateBar() { // draws the barPlayerCharacter/paddle at the bottom-centre of the screen
		
		xcoord = (console.length()/2)-2;
		for (int i= xcoord; i<= xcoord+4; i++) {
			console.setContent(ycoord, i, "=");
			}
		
	}
	
	public void moveBar() { // method that reads the input and calls the respective methods to move the paddle left or right based on input
		
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
	
	public void moveBarCopy(char in) { // method that reads the input and calls the respective methods to move the paddle left or right based on input

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
	
	public void moveRight() { // moves the barPlayerCharacter/paddle to the right by 1 unit
		if(xcoord<console.length()-5) {
			console.setContent(ycoord, xcoord, " ");
			xcoord ++;
			console.setContent(ycoord, xcoord+4, "=");
		}
	}
	
	public void moveLeft() { // moves the barPlayerCharacter/paddle to the left by 1 unit
		if(xcoord>1) {
			console.setContent(ycoord, xcoord+4, " ");
			xcoord --;
			console.setContent(ycoord, xcoord, "=");
		}
	}

	public int getXcoord() {
		return xcoord;
	}

	public void setXcoord(int xcoord) {
		if (xcoord<1 || xcoord > console.height())
			throw new IndexOutOfBoundsException();
		this.xcoord = xcoord;
	}

	public int getYcoord() {
		return ycoord;
	}

	public void setYcoord(int ycoord) {
		if (ycoord < 1 || ycoord > console.height())
			throw new IndexOutOfBoundsException();
		this.ycoord = ycoord;
	}
}
