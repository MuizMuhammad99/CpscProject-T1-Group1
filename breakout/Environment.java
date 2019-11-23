import java.util.ArrayList;

public class Environment extends Breakout{

	private String[][] background; // Array for playing field
	private int row, column;
	private DestroyableElements[] barrier; //Array that creates the space for playing field
	private ArrayList<DestroyableElements> barrier2= new ArrayList<DestroyableElements>();; //Array that creates the space for playing field


	public Environment() { //default constructor
		row = 20;
		column = 38;
		background = new  String[row][column];
	}
	
	public Environment(int r, int c) { // constructor initializing row and column
		row = r+1;
		column = c+1;
		background = new  String[row][column];
	}
	
	public void setEnvironment() { // Creates the barrier around the game field
		
		for (int i = 0; i < row; i++) {
			
			if (i == 0 || i == row-1) { // draws barriers on the top and bottom of the playing field
				for (int j = 0; j < column ; j++) {
					background [i][j] = "-";
				}
				
			} else if (i > 0 && i < row-1) {
				
				for (int c = 0 ; c < column; c++) { // draws barriers on the left and right wall of the playing field
					if (c==0 || c==column-1) {
						background [i][c] = "|";
					} else if (c > 0 && c < column-1) {					
						background [i][c] = " ";
					}
				}
			}
		}
	}
	
	public void drawBrick(DestroyableElements destroyableElements){ // a method that draws a 'piece' of destroyableElements
		for (int i = 0; i != destroyableElements.getBrickLength(); i++){
			background[destroyableElements.getRowBrick()][destroyableElements.getColumnBrick()+i] = destroyableElements.getBrickType() +"";
		}
	}

	public void drawBricks(DestroyableElements[] destroyableElements){ // a method that draws the entire brick
		for (DestroyableElements elements : destroyableElements){
			for (int i = 0; i != elements.getBrickLength(); i++){
				background[elements.getRowBrick()][elements.getColumnBrick()+i] = elements.getBrickType() +"";
			}
		}
	}
	
	public void setContent(int r, int c, String value) {
		background [r][c] = value;
	} // method that assigns a character or word at any given space within the boundaries of the playing field
	
	public String getContent(int r, int c) { // getter to receive the value assigned at any location of the playing field
		String content = background [r][c];
		return content;
	}
	
	public int height(){
		return row-1; 
	} // compensated value of row length without counting boarder on one side
	
	public int length(){
		return column-1; 
	} // compensated value of column length without counting boarder on one side
	
	public void printEnvironment() {
		for (int i = 0 ; i < row ; i++) {
			for (int j = 0 ; j < column; j++) {
				System.out.print(background[i][j]);
			}
			System.out.println();
		}
	}

	public void level1() {
		barrier = (new DestroyableElements[]{  // inserts bricks into array given their parameters
				new DestroyableElements(2, 2, 6),
				new DestroyableElements(1, 2, 14),
				new DestroyableElements(4, 2, 21),
				new DestroyableElements(3, 2, 29),
				new DestroyableElements(2, 3, 6),
				new DestroyableElements(1, 3, 14),
				new DestroyableElements(4, 3, 21),
				new DestroyableElements(3, 3, 29),
				new DestroyableElements(2, 5,2),
				new DestroyableElements(1, 5,9),
				new DestroyableElements(4,6, 5,17),
				new DestroyableElements(3, 5,26),
				new DestroyableElements(2, 5,33),
				new DestroyableElements(1, 9,2),
				new DestroyableElements(4, 9,9),
				new DestroyableElements(3,6, 9,17),
				new DestroyableElements(2, 9,26),
				new DestroyableElements(1, 9,33),
				new DestroyableElements(4, 7, 6),
				new DestroyableElements(3, 7, 14),
				new DestroyableElements(2, 7, 21),
				new DestroyableElements(1, 7, 29),
		});
		console.drawBricks(barrier);
	}


	public void level2() {

		this.drawRowOfBricks(4, 0, 2, 3);
		this.drawRowOfBricks(4, 1, 3, 3);
		this.drawRowOfBricks(5, 2, 6, 2);
		this.drawRowOfBricks(4, 0, 9, 3);
		this.drawRowOfBricks(4, 1, 10, 3);
	}


	public void drawRowOfBricks(int brickNum, int brickType, int brickRow, int spaceBetween) {
		int numOfBricks=brickNum;
		int typeOfBricks= brickType;
		int rowOfBricks= brickRow;

		int spacing = spaceBetween;
		int lengthOfBricks = (column-2*spacing) / numOfBricks - spacing;


		for (int i = spacing+1 ; i < column-lengthOfBricks ; i+= lengthOfBricks+spacing) {
			barrier2.add(new DestroyableElements(typeOfBricks, lengthOfBricks,rowOfBricks,i));

			for (int j = 0 ; j < barrier2.size() ; j++) {
				int r, c, type, length;
				length = barrier2.get(j).getBrickLength();
				r = barrier2.get(j).getRowBrick();
				c = barrier2.get(j).getColumnBrick();
				type = barrier2.get(j).getBrickType();
				for (int k = c ; k < c+length ; k++) {
					this.setContent(r, k, type+"");
				}
			}
		}
	}



	public DestroyableElements[] getBarrier() {
		return barrier;
	}

	public void setBarrier(DestroyableElements[] barrier) {
		this.barrier = barrier;
	}

	public ArrayList<DestroyableElements> getBarrier2() {
		return barrier2;
	}

	public void setBarrier2(ArrayList<DestroyableElements> barrier) {
		this.barrier2 = barrier2;
	}
}
