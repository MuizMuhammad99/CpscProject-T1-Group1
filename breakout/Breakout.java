public class Breakout {

	public static Environment console = new Environment(20,60); //20 x 38
	public static Player user = new Player();
	public static BallsPlayerCharacter ball = new BallsPlayerCharacter();


	/**
	 * main method
	 * @param args is the main argument
	 */
	public static void main(String[] args) {
		console.setEnvironment();
		console.level0();
		user.Play();
	}

	/**
	 * getter for console
	 * @return console
	 */
	public Environment getConsole() {
		return console;
	}

	/**
	 * getter for bar
	 * @return user.gamer
	 */
	public BarPlayerCharacter getBar() {
		return user.gamer;
	}

}