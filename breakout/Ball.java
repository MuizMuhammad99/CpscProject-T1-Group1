package breakout;

public class Ball {
	Breakout breakout = new Breakout();
	Environment console = breakout.getConsole();
	private int xcoord;
	private int ycoord = console.height()-2;
	Bar bar = breakout.getBar();
	
	
	public void initiateBall() { // draws the bottom on top of the bar
		bar.initiateBar();
		setXcoord((console.length()/2-1));
		console.setContent(getYcoord(), getXcoord(), "O");
	}
	
	public int getXcoord() {
		return xcoord;
	}
	
	public int getYcoord() {
		return ycoord;
	}
	
	public void moveY(int x, int y) {

		String prev = console.getContent(getYcoord() -y, getXcoord() +x);
			console.setContent(getYcoord(), getXcoord(), prev);
			setYcoord(getYcoord() - y);
			if(console.getContent(getYcoord() -y, getXcoord() +x) == " ") console.setContent(getYcoord(), getXcoord(), "O");
	}

	public void moveX(int x, int y) {
		String prev = console.getContent(getYcoord() -y, getXcoord() +x);
		console.setContent(getYcoord(), getXcoord(), prev);
		setXcoord(getXcoord() + x);
		if(console.getContent(getYcoord() -y, getXcoord() +x) == " ") console.setContent(getYcoord(), getXcoord(), "O");
	}

	public void moveDiagonally(int x, int y) { //move Diagonally 
		int X = x, Y=y;
		this.moveX(X,Y);
		X-=x;
		this.moveY(X,Y);
	}


	public int[] moveConditions(int x, int y) {
		int [] values = new int[2];
		if (getXcoord() >= console.length()- Math.abs(x) || getXcoord() <= Math.abs(x)) {
			x*=-1;
		} else if (getYcoord() < Math.abs(y)) {
			y*=-1;

		} else if (getYcoord() >=console.height()-1) {
			System.out.println("GAME OVER");
			values[0] = -18;
			return values;

		}else if (console.getContent(getYcoord() -y, getXcoord() +x) != " " && console.getContent(getYcoord() -y, getXcoord() +x) != "|") {
			y*=-1;

		}else if(y<0 && console.getContent(getYcoord() -y, getXcoord()) == "=") {
			y*=-1;
		}
		values[0] = x;
		values[1] = y;
		return values;
	}


	public void setXcoord(int xcoord) {
		this.xcoord = xcoord;
	}

	public void setYcoord(int ycoord) {
		this.ycoord = ycoord;
	}
}
