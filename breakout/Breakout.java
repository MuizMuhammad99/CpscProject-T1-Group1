package breakout;

import java.util.Scanner;

public class Breakout {

	public static Environment console = new Environment(20,38);
	public static Player user = new Player();
	private static Ball ball = new Ball();


	public static void main(String[] args) {
		console.setEnvironment();
		console.level1();
		user.Play();
	}

	public void setBall(Ball ball) {
		Breakout.ball = ball;
	}

	public Environment getConsole() {
		return console;
	}

	public Ball getBall() {
		return ball;
	}

	public Bar getBar() {
		return user.gamer;
	}
}