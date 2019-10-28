package breakout;

public class Levels extends Breakout{
	
	Brick[] barrier; //Array that creates the space for playing field

	public void level1() {
		barrier = (new Brick[]{  // inserts bricks into array given their parameters
				new Brick(0, 2, 6),
				new Brick(0, 2, 14),
				new Brick(0, 2, 21),
				new Brick(0, 2, 29),
				new Brick(1, 3, 6),
				new Brick(1, 3, 14),
				new Brick(1, 3, 21),
				new Brick(1, 3, 29),
				new Brick(2, 5,2),
				new Brick(2, 5,9),
				new Brick(2,6, 5,17),
				new Brick(2, 5,26),
				new Brick(2, 5,33),
				new Brick(0, 9,2),
				new Brick(0, 9,9),
				new Brick(0,6, 9,17),
				new Brick(0, 9,26),
				new Brick(0, 9,33),
				new Brick(1, 7, 6),
				new Brick(1, 7, 14),
				new Brick(1, 7, 21),
				new Brick(1, 7, 29),
		});
		console.drawBricks(barrier);
	}

	public Brick[] getBarrier() {
		return barrier;
	}
}
