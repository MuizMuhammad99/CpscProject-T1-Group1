package breakout;

public class Breakout {
	public static void main(String[] args) {
	     Environment console = new Environment(15,50);
	     console.setEnvironment();
	     
	     // Array modification example:
	     console.setContent(2, console.length()/2, "H");
	     console.setContent(2, console.length()/2+1, "I");
	     console.printEnvironment();
	   }
}
