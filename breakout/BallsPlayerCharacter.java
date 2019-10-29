package breakout;

public class BallsPlayerCharacter extends Player {
	public int xcoord, ycoord = console.height()-3; // these coordinates are for the bottom left coordinates of the barPlayerCharacter
	
	public void initiateBall() {
		
			xcoord = (console.length()/2)-2;
			for (int i= xcoord; i<= xcoord+2; i++) {
				console.setContent(ycoord, i, "=");
				}	
	}

	public void moveUpRight() {
		if(xcoord<console.length()-2) {
			console.setContent(ycoord, xcoord, " ");
			ycoord --;
			xcoord ++;
			console.setContent(ycoord-2, xcoord+2, " ");
		}
	}
	
	public void moveUpLeft() {
		if(xcoord<console.length()-2) {
			console.setContent(ycoord, xcoord, " ");
			xcoord --;
			ycoord --;
			console.setContent(ycoord-2, xcoord-2, " ");
		}
	}
	
	public void moveDownRight() {
		if(xcoord<console.length()-2) {
			console.setContent(ycoord, xcoord, " ");
			xcoord ++;
			ycoord ++;
			
			console.setContent(ycoord+2, xcoord+2, " ");
		}
	}
	
	public void moveDownLeft() {
		if(xcoord<console.length()-2) {
			console.setContent(ycoord, xcoord, " ");
			xcoord --;
			ycoord ++;
			console.setContent(ycoord+2, xcoord-2, " ");
		}
		}

	public void wallBounceLeft(int xCoord) {
		if(xCoord==2)
			moveDownRight();
	}

	public void wallBounceRight(int xCoord) {
		if(xCoord== -2) {            
			moveDownLeft();
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
