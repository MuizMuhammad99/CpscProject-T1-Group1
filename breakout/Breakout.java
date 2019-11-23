public class Breakout {

	public static Environment console = new Environment(20,60); //20 x 38
	public static Player user = new Player();
	public static BallsPlayerCharacter ball = new BallsPlayerCharacter();




	public static void main(String[] args) {
		console.setEnvironment();
		console.level2();
		user.Play();
	}

	public Environment getConsole() {
		return console;
	}

	public BallsPlayerCharacter getBall() {
		return ball;
	}

	public BarPlayerCharacter getBar() {
		return user.gamer;
	}

}