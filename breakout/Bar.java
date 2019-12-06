public class Bar extends Player {
	
	public BallsPlayerCharacter ball = super.getBall();
	public int xcoord, ycoord = console.height()-1; // these coordinates are for the bottom left coordinates of the bar
	
	
	public void initiateBar() { // draws the bar/paddle at the bottom-centre of the screen
		
		xcoord = (console.length()/2)-2;
		for (int i= xcoord; i<= xcoord+4; i++) {
			console.setContent(ycoord, i, "=");
			}
		
	}

	
	public void moveBar(char in) { // method that reads the input and calls the respective methods to move the paddle left or right based on input
		
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


	public int getXcoord() {
		return xcoord;
	}

	public void setXcoord(int xcoord) {
		this.xcoord = xcoord;
	}

	public int getYcoord() {
		return ycoord;
	}

	public void setYcoord(int ycoord) {
		this.ycoord = ycoord;
	}
}
