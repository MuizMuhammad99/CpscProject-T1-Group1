import java.util.Scanner;

public class Player extends Breakout{

	public static BarPlayerCharacter gamer = new BarPlayerCharacter();
	public static Scanner reader = new Scanner(System.in);

    public int xcoord, ycoord = console.height()-1; // these coordinates are for the bottom left coordinates of the bar

    /**
     * plays level 0 on console
     */
	public void Play() {
		console.level0();
		char ch = 's';
		gamer.initiateBar();
		ball.initiateBall();

		int x=-1, y=1;

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
			if (console.levelCleared()) {
				this.playLevel2();
				break;
			}

			ch = reader.next().charAt(0);
		}

	}

    /**
     * plays level 2 on console
     */
	public void playLevel2() {
		console.clearConsole();
		console.level2();
		char ch = 's';
		gamer.initiateBar();
		ball.initiateBall();

		int x=-1, y=1;

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
			if (console.levelCleared()) {
				this.playLevel2();
				break;
			}

			ch = reader.next().charAt(0);
		}

	}

    //Getters

    /**
     * @return xcoord
     * method that returns the x coordinate of the bar
     */
    public int getXcoord() {
        return xcoord;
    }

    /**
     * @return ycoord
     * method that returns the y coordinate of the bar
     */
    public int getYcoord() {
        return ycoord;
    }

    //Setters

    /**
     * @param xcoord
     * method that sets the x coordinate of the bar
     */
    public void setXcoord(int xcoord) {
        this.xcoord = xcoord;
    }

}
