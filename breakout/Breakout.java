package breakout;

public class Breakout {
	public static void main(String[] args) {
		Environment console = new Environment();
		console.setEnvironment();

		console.drawBricks(new Brick[]{
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
		//console.setContent(2, console.length()/2, "H");
		//console.setContent(2, console.length()/2+1, "I");
		console.printEnvironment();
	   }
}
