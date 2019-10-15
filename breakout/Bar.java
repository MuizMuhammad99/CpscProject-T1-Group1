package breakout;

import java.util.Scanner;

public class Bar extends Player{
	
	public int xcoord, ycoord = console.height()-1; // these coordinates are for the bottom left coordinates of the bar
	
	public void initiateBar() {
		
		xcoord = (console.length()/2)-2;
		for (int i= xcoord; i<= xcoord+4; i++) {
			console.setContent(ycoord, i, "=");
			}
		
	}
	
	public void moveBar() {
		
		char c='s';
		System.out.println("\n Use 'a' and 'd' as arrows");
		while(c!='e' || c!= 'E') {
			if (c == 'a' || c == 'A') {
				gamer.moveLeft();
			} else if (c == 'd' || c == 'D') {
				gamer.moveRight();
			}
			console.printEnvironment();
			Scanner reader = new Scanner(System.in);
			c = reader.next().charAt(0);	
		}		
	}
	
	public void moveRight() {
		if(xcoord<console.length()-5) {
			console.setContent(ycoord, xcoord, " ");
			xcoord ++;
			console.setContent(ycoord, xcoord+4, "=");
		}
	}
	
	public void moveLeft() {
		if(xcoord>1) {
			console.setContent(ycoord, xcoord+4, " ");
			xcoord --;
			console.setContent(ycoord, xcoord, "=");
		}
	}
}
