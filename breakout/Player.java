import java.util.Scanner;

public class Player extends Breakout{
	
	public static BarPlayerCharacter gamer = new BarPlayerCharacter();
	public static Scanner reader = new Scanner(System.in);

	/**
	 * initiates the visual updates for text-game
	 */
	public void Play() {

		char ch = 's';
		gamer.initiateBar();
		ball.initiateBall();

		int x=1, y=1;

		while (ch != 'e') {
			console.printEnvironment();

			int [] value = ball.moveDirection(x, y);
			if(value[0] == -18) {
				break;
			}
			x = value[0];
			y = value[1];

			BarPlayerCharacter bar = user.getBar();
			bar.moveBarCopy(ch);
			ball.moveDiagonally(x,y);

			ch = reader.next().charAt(0);
		}

	}
}
