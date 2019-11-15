package breakout;

import java.util.Scanner;

public class Breakout {
	
	public static Environment console = new Environment(20,38);
	public static Levels level = new Levels();
	public static Player user = new Player();
	public static Ball ball = new Ball();

	
	public static void main(String[] args) {
		
	     console.setEnvironment();
	     console.drawBricks(level.level1()); 
	     user.Play();   

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
