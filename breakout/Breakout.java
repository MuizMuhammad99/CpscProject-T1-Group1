package breakout;

public class Breakout {
	
	public static Environment console = new Environment();
	public static Player user = new Player();
	
	public static void main(String[] args) {
	     console.setEnvironment();
	     console.level1();
	     user.Play();     

	   }
}
