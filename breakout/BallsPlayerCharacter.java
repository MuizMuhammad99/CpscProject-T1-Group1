public class BallsPlayerCharacter extends Player {
	Breakout breakout = new Breakout();
	Environment console = breakout.getConsole();



	int xco, yco = console.height()-2;
	BarPlayerCharacter bar = breakout.getBar();

	/**
	 *  places the ball half way in console
	 */
	public void initiateBall() {

			bar.initiateBar();
			xco = (console.length()/2-1);
			console.setContent(yco, xco, "O");
	}

	
	// Start of Lateral Movements 
	
	// text version:

	/**
	 * moves the y coordinate for the ball
	 * @param y is the y coordinate for the ball
	 * @param previous is the previous coordinates for the ball
	 */
	public void moveY(int y, String previous) {

		String prev = previous;
			console.setContent(yco, xco, prev);
			yco-=y;
			console.setContent(yco, xco, "O");
	}

	/**
	 * moves the x coordinate for the ball
	 * @param x is the x coordinate for the ball
	 * @param y is the y coordinate for the ball
	 */
	public void moveX(int x, int y) {

		String prev = console.getContent(yco-y, xco+x);
			console.setContent(yco, xco, prev);
			xco+=x;
			console.setContent(yco, xco, "O");
	}

	/**
	 * visual movement console update
	 * @param x is the x coordinate for the ball
	 * @return updated console
	 */
	public String preMoveX(int x) {
		return console.getContent(yco, xco+x);
	}
	// end of text version

	
	//Start for text version

	/**
	 * moves ball diagonally
	 * @param x is the x coordinate for the ball
	 * @param y is the y coordinate for the ball
	 */
	public void moveDiagonally(int x, int y) { //move Diagonally
		int X = x, Y=y;	
		String previous = this.preMoveX(X);
			this.moveX(X,Y);
		this.moveY(Y,previous);
	}

	/**
	 * flips the ball's direction
	 * @param x is the x coordinate for the ball
	 * @param y is the y coordinate for the ball
	 * @return updated console
	 */
	public int[] moveDirection(int x, int y) {
		int [] values = new int[2];
		if (xco >= console.length()- Math.abs(x) || xco <= Math.abs(x)) {
			// Bounces off the sides
			x*=-1;
		} else if (yco < Math.abs(y+1)) {
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
					console.setContent(yco-y, xco+x,value-1);
				}
				y*=-1;
			}
		}

		else if (this.checkParallelCollision(x, y)){	// possible sideways collisions
			String element = this.checkParallelElements(x,y);
			System.out.println(element);
			if (this.checkUpDownElement(x, y).equals(" ")) {
				System.out.println("empty vertical loop");
				if(element.equals("0")) {
					console.setContent(yco, xco+x," ");
				} else {
					int value = Integer.parseInt(element);
					console.setContent(yco, xco+x,value-1);
				}
				x*=-1;
			} else {
				if(element.equals("0")) {
					console.setContent(yco-y, xco," ");
				} else {
					int value = Integer.parseInt(element);
					console.setContent(yco-y, xco,value-1);
				}
				y*=-1;
			}

		}
		values[0] = x;
		values[1] = y;
		return values;
	}

	/**
	 * Checks if ball is colliding diagonally with a brick
	 * @param x is the x coordinate for the ball
	 * @param y is the y coordinate for the ball
	 * @return true or false if ball is colliding diagonally with a brick
	 */
	public boolean checkDiagonalCollision(int x, int y) {
		
		if (console.getContent(yco-y, xco+x) != " " && console.getContent(yco-y, xco+x) != "|") { // checks the diagonal next spot
			return true;			
		} else if(y<0 && console.getContent(yco-y, xco) == "=") {
	 		return true;
		}		
		return false;
	}

	/**
	 * Checks the value in diagonal brick that's about to be hit
	 * @param x is the x coordinate for the ball
	 * @param y is the y coordinate for the ball
	 * @return the value of the diagonal brick
	 */
	public String checkDiagonalElements(int x, int y) {
		return console.getContent(yco-y, xco+x);		
	}

	/**
	 *Checks for parallel collision
	 * @param x is the x coordinate for the ball
	 * @param y is the y coordinate for the ball
	 * @return true or false if there is a collision
 	 */
	public boolean checkParallelCollision(int x, int y) {
		if(console.getContent(yco-y, xco) != " ") {
			return true;
		}else if (console.getContent(yco, xco+x) != " ") {
			return true;
		}
		return false;
	}

	/**
	 *Checks for element that is parallel to ball
	 * @param x is the x coordinate for the ball
	 * @param y is the y coordinate for the ball
	 * @return returns the element
	 */
	public String checkParallelElements(int x, int y) {
		String vertical = console.getContent(yco-y, xco);
		String horizontal = console.getContent(yco, xco+x);
		if (vertical.equals(" ")) {
			return horizontal;
		}			
		return vertical;		
	}

	/**
	 * checks the element up and down
	 * @param x is the x coordinate for the ball
	 * @param y is the y coordinate for the ball
	 * @return value as a String
	 */
	public String checkUpDownElement(int x, int y) {
		String value = console.getContent(yco-y, xco);
		if ( value != " ") {
			return value;
		}
		return " ";
	}


}
