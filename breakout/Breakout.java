public class Breakout {
	
	public static Environment console = new Environment();
	public static Levels level = new Levels();
	public static Player user = new Player();
	
	public static void main(String[] args) {
	     console.setEnvironment();
	     level.level1();
	     user.Play();     

	   }
}
