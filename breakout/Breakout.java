package breakout;



public class Breakout {
	
	public static Environment console = new Environment(20,60);
	public static Player user = new Player();
	public static BallsPlayerCharacter ball = new BallsPlayerCharacter();
	
	public static void main(String[] args) {
	     console.setEnvironment();
	     //console.level0();
	     user.Play();
	   }

	public Environment getConsole() {
		return console;
	}
	public void setConsole(int rows, int columns) {
		console = new Environment(rows,columns);
	}

	public BallsPlayerCharacter getBall() {
		return ball;
	}

	public BarPlayerCharacter getBar() {
		return user.gamer;
	}	

}
