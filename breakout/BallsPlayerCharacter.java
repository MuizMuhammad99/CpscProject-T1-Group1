public class BallsPlayerCharacter extends Player {
	Breakout breakout = new Breakout();
	Environment console = breakout.getConsole();
	private int xcoord, ycoord = console.height()-3; // these coordinates are for the bottom left coordinates of the barPlayerCharacter
	
	// text version:		
	int xco, yco = console.height()-2;
	BarPlayerCharacter bar = breakout.getBar();
	
	public void initiateBall() {
		
			/*xcoord = (console.length()/2)-2;
			for (int i= xcoord; i<= xcoord+2; i++) {
				console.setContent(ycoord, i, "=");
				}*/	
			//text version:
			bar.initiateBar();
			xco = (console.length()/2-1);
			console.setContent(yco, xco, "O");
	}
	
	public int getXcoord() {
		return xco;
	}

	public int getYcoord() {
		return yco;
	}
	
	// Start of Lateral Movements 
	
	// text version:
	public void moveY(int y) {
			console.setContent(yco, xco, " ");
			yco-=y;
			console.setContent(yco, xco, "O");
	}

	public void moveY(int x, int y) {

		String prev = console.getContent(yco-y, xco+x);
		System.out.println("y_Prev= "+prev+" | Coordinates: ("+(xco+x)+","+(yco-y)+")");
			console.setContent(yco, xco, prev);
			yco-=y;
			console.setContent(yco, xco, "O");
			System.out.println("moved to ("+xco+","+yco+")");
	}
	
	public void moveY(int x, int y, String previous) {

		String prev = previous;
			console.setContent(yco, xco, prev);
			yco-=y;
			console.setContent(yco, xco, "O");
	}

	public void moveX(int x) {
		
			console.setContent(yco, xco, "-");
			xco+=x;
			console.setContent(yco, xco, "O");

	}	

	public void moveX(int x, int y) {

		String prev = console.getContent(yco-y, xco+x);
			console.setContent(yco, xco, prev);
			xco+=x;
			console.setContent(yco, xco, "O");
	}
	
	public String preMoveX(int x, int y) {
		return console.getContent(yco, xco+x);
	}
	// end of text version
	
	
	// Start of Diagonal Movements 

	// start of GUI
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
	} // end of GUI
	
	//Start for text version
	public void moveDiagonally(int x, int y) { //move Diagonally
		int X = x, Y=y;	
		String previous = this.preMoveX(X, Y);
			this.moveX(X,Y);
			X-=x;
			this.moveY(X,Y,previous);	
	}


	public int[] moveDirection(int x, int y) {
		int [] values = new int[2];
		 if (xco >= console.length()- Math.abs(x) || xco <= Math.abs(x)) {
		// Bounces off the sides
				x*=-1;
		} else if (yco < Math.abs(y)) {
		// Bounces off the top
			y*=-1;

		} else if (yco>=console.height()-1) {
			System.out.println("GAME OVER");
			values[0] = -18; //18 is an arbitrary number that will cause the while loop in Player to break
			return values;
		}

		//Managing collisions with elements bellow
						
		if(this.checkDiagonalCollision(x,y)) { // if ball will collide with something

			String element = this.checkDiagonalElements(x,y);
			if(element.equals("=")) { //Bounces off paddle
				y*=-1;
			} else {
				if(element.equals("0") || element.equals(" ")) {
					console.setContent(yco-y, xco+x," ");
				} else {
					int value = Integer.parseInt(element);
					console.setContent(yco-y, xco+x,value-1+"");
				}
				y*=-1;
			}
		} 
	
		else if (this.checkParallelCollision(x, y)){	// possible sideways collisions 
			String element = this.checkParallelElements(x,y);
			if(element.equals("0")) {
				console.setContent(yco, xco+x," ");
			} else {
				int value = Integer.parseInt(element);
				console.setContent(yco, xco+x,value-1+"");
			}
			x*=-1;
		}
		values[0] = x;
		values[1] = y;
		return values;
	}
	
	public boolean checkDiagonalCollision(int x, int y) {
		
		if (console.getContent(yco-y, xco+x) != " " && console.getContent(yco-y, xco+x) != "|") { // checks the diagonal next spot
			return true;			
		} else if(y<0 && console.getContent(yco-y, xco) == "=") {
	 		return true;
		}		
		return false;
	}
		
	public String checkDiagonalElements(int x, int y) {
		return console.getContent(yco-y, xco+x);		
	}
	
	public boolean checkParallelCollision(int x, int y) {
		if(console.getContent(yco-y, xco) != " ") {
			return true;
		}else if (console.getContent(yco, xco+x) != " ") {
			return true;
		}
		return false;
	}
	
	public String checkParallelElements(int x, int y) {
		String vertical = console.getContent(yco-y, xco);
		String horizontal = console.getContent(yco, xco+x);
		if (vertical.equals(" ")) {
			return horizontal;
		}			
		return vertical;		
	}
	
	public String checkUpDownElement(int x, int y) {
		String value = console.getContent(yco-y, xco);
		if ( value != " ") {
			return value;
		}
		return " ";
	}	

}
