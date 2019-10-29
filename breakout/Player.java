package breakout;

public class Player extends Breakout{
	
	public static BarPlayerCharacter gamer = new BarPlayerCharacter();
	
	public void Play() {
	     gamer.initiateBar();
	     gamer.moveBar();
	}

}
