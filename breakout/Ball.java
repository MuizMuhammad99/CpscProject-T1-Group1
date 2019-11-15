package breakout;

import java.io.IOException;
import java.util.Scanner;

public class Ball {
	Breakout breakout = new Breakout(); 
	Environment console = breakout.getConsole();
	int xcoord, ycoord = console.height()-2;
	Bar bar = breakout.getBar();
	
	
	public void initiateBall() { // draws the bottom on top of the bar
		bar.initiateBar();
		xcoord = (console.length()/2-1);
		console.setContent(ycoord, xcoord, "O");
	}
	
	public int getXcoord() {
		return xcoord;
	}
	
	public int getYcoord() {
		return ycoord;
	}
	
	
	public void moveY(int y) {
		String prev = console.getContent(ycoord+y, xcoord);
			console.setContent(ycoord, xcoord, " ");
			ycoord-=y;
			console.setContent(ycoord, xcoord, "O");
	}
	
	public void moveY(int x, int y) {
		
		String prev = console.getContent(ycoord-y, xcoord+x);
			console.setContent(ycoord, xcoord, prev);
			ycoord-=y;
			console.setContent(ycoord, xcoord, "O");
	}
	
	public void moveX(int x) {
	
		String prev = console.getContent(ycoord, xcoord+x);
			console.setContent(ycoord, xcoord, "-");
			xcoord+=x;
			console.setContent(ycoord, xcoord, "O");

	}	
	
	public void moveX(int x, int y) {
		
		String prev = console.getContent(ycoord-y, xcoord+x);
			console.setContent(ycoord, xcoord, prev);
			xcoord+=x;
			console.setContent(ycoord, xcoord, "O");
	}
	
	public void moveDiagonally(int x, int y) { //move Diagonally 
		int X = x, Y=y;		
			this.moveX(X,Y);
			X-=x;
			this.moveY(X,Y);	
	}


	public int[] moveConditions(int x, int y) {
		int [] values = new int[2];
		 if (xcoord >= console.length()- Math.abs(x) || xcoord <= Math.abs(x)) {
				x*=-1;
		} else if (ycoord < Math.abs(y)) {
			y*=-1;
			
		} else if (ycoord>=console.height()-1) {
			System.out.println("GAME OVER");
			values[0] = -18;
			return values;
			
		}else if (console.getContent(ycoord-y, xcoord+x) != " " && console.getContent(ycoord-y, xcoord+x) != "|") {
		 	y*=-1;
		 	
	 	}else if(y<0 && console.getContent(ycoord-y, xcoord) == "=") {
	 		y*=-1;
	 	}
		 values[0] = x;
		values[1] = y;
		return values;
	}
	
	
		
}
