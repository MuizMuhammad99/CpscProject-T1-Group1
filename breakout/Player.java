package breakout;

import java.util.Scanner;

public class Player extends Breakout{
	
	public static Bar gamer = new Bar();
	public static Ball ball = new Ball();
	public static Scanner reader = new Scanner(System.in); 
	
	public void Play() {
		char ch = 's';
	    gamer.initiateBar();
		ball.initiateBall();
		int xco = ball.getXcoord(), yco = ball.getYcoord();
		int x=1, y=1; 
		
		while (ch != 'e') {
			 console.printEnvironment();
			
			 int [] value = ball.moveConditions(x, y);
			 if(value[0] == -18) {
				break;				 
			 }
			 x = value[0];
			 y = value[1];
			 
	    	 Bar bar = user.getBar();
	    	 bar.moveBarCopy(ch);
	    	 ball.moveDiagonally(x,y);
	
	    	 ch = reader.next().charAt(0);
	     }
     
	}

}
