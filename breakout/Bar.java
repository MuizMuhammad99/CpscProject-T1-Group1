import java.util.Scanner;

public class Bar extends Player{
	
	public int xcoord, ycoord = console.height()-1; // these coordinates are for the bottom left coordinates of the bar
	
	public void initiateBar() { // draws the bar/paddle at the bottom-centre of the screen
		
		xcoord = (console.length()/2)-2;
		for (int i= xcoord; i<= xcoord+4; i++) {
			console.setContent(ycoord, i, "=");
			}
		
	}
	
	public void moveBar() { // method that reads the input and calls the respective methods to move the paddle left or right based on input
		
		char c='s';
		System.out.println("\n Use 'a' and 'd' as arrows");

		while(c!='e' || c!= 'E') { // 'e' and 'E' are designated keys for exiting game
			if (c == 'a' || c == 'A') { // 'a' is designated key for moving bar/paddle left
				gamer.moveLeft();
			} else if (c == 'd' || c == 'D') { // 'd' is designated key for moving bar/paddle right
				gamer.moveRight();
			}
			console.printEnvironment();
			Scanner reader = new Scanner(System.in); // takes the input from the keyboard
			c = reader.next().charAt(0); // will only consider the first character of whatever the user inputs
		}		
	}
	
	public void moveRight() { // moves the bar/paddle to the right by 1 unit
		if(xcoord<console.length()-5) {
			console.setContent(ycoord, xcoord, " ");
			xcoord ++;
			console.setContent(ycoord, xcoord+4, "=");
		}
	}
	
	public void moveLeft() { // moves the bar/paddle to the left by 1 unit
		if(xcoord>1) {
			console.setContent(ycoord, xcoord+4, " ");
			xcoord --;
			console.setContent(ycoord, xcoord, "=");
		}
	}
}
