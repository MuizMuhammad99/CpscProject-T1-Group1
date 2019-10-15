package breakout;

public class Player extends Breakout{
	
	public static Bar gamer = new Bar();
	
	public void Play() {
	     gamer.initiateBar();
	     gamer.moveBar();
	}

}
