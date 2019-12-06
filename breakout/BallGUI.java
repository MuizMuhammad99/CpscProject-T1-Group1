public class BallGUI {
	Breakout breakout = new Breakout();
	Environment console = breakout.getConsole();
	private double xcoord;
	private double ycoord = console.height()-2;
	BarPlayerCharacter bar = breakout.getBar();

	public BallGUI(BallGUI ball) {
		this.xcoord = ball.getXcoord();
		this.ycoord = ball.getYcoord();
	}

	public BallGUI() { // draws the bottom on top of the bar
		xcoord = 500;
		ycoord = 500;
	}
	
	public double getXcoord() {
		return xcoord;
	}
	
	public double getYcoord() {
		return ycoord;
	}


	public void moveConditions(double x, double y) {
		this.setXcoord(x+1);
		this.setXcoord(y+1);

	}

	public void setXcoord(double xcoord) {
		this.xcoord = xcoord;
	}

	public void setYcoord(double ycoord) {
		this.ycoord = ycoord;
	}
}
