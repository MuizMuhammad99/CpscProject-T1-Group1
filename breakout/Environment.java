/**
 * @author T1 Group 1
 * CPSC 233 Fall 2019
 */

import java.util.ArrayList;

public class Environment extends Breakout{

	private String[][] background; // Array for playing field
	private int row, column;
	private DestroyableElements[] barrier; //Array that creates the space for playing field
	private ArrayList<DestroyableElements> barrier2= new ArrayList<DestroyableElements>();; //Array that creates the space for playing field

	/**
	 * default constructor
	 */
	public Environment() {
		row = 15;
		column = 40;
		background = new  String[row][column];
	}

	/**	constructor initializing row and column and array

	 * @param r is the row
	 * @param c is the column
	 */

	public Environment(int r, int c) { // constructor initializing row and column
		this();
		if (r>0 && c >0) {
			row = r+1;
			column = c+1;
		}
		background = new  String[row][column];
	}

	/**
	 * method that creates the barrier around the game field
	 */
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



	/**
	 * @param destroyableElements with base type DestroyableElements
	 * method that draws an entire brick
	 */
	public void drawBricks(DestroyableElements[] destroyableElements){
		for (DestroyableElements elements : destroyableElements){
			for (int i = 0; i != elements.getBrickLength(); i++){
				background[elements.getRowBrick()][elements.getColumnBrick()+i] = elements.getBrickType() +"";
			}
		}
	}

	/**	method that assigns a character or word at any given space within the boundaries of the playing field
	 * @param r is the row
	 * @param c is the column
	 * @param value is the bricktype placed in the respective row and column
	 */
	public void setContent(int r, int c, String value) {
		background [r][c] = value;
	}


	public void setContent(int r, int c, int v) {
		String value = v+"";
		background [r][c] = value;
	}

	/** returns the value assigned at any location of the playing field
	 * @param r is the row
	 * @param c is the column
	 * @return content
	 */
	public String getContent(int r, int c) {
		String content = background [r][c];
		return content;
	}

	/** compensated value of row length without counting boarder on one side
	 * @return row-1
	 */

	public int height(){
		return row-1;
	}

	/**	compensated value of column length without counting boarder on one side
	 * @return column-1
	 */

	public int length(){
		return column-1;
	}

	/**	visual view for console
	 */
	public void printEnvironment() {
		for (int i = 0 ; i < row ; i++) {
			for (int j = 0 ; j < column; j++) {
				System.out.print(background[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * method that inserts bricks into array given their parameters
	 */
	public void level1() {
		barrier = (new DestroyableElements[]{
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

	/**
	 * method that inserts bricks into array given their parameters
	 */
	public void level2() {

		this.drawRowOfBricks(4, 0, 2, 3);
		this.drawRowOfBricks(4, 1, 3, 3);
		this.drawRowOfBricks(5, 2, 6, 2);
		this.drawRowOfBricks(4, 0, 9, 3);
		this.drawRowOfBricks(4, 1, 10, 3);
	}

	public void level0() {
		this.drawRowOfBricks(3, 0, this.row/3 ,6);
	}

	public boolean levelCleared() {
		int counter=0;
		for (int i = 1; i < this.row-2; i++ ) {
			for (int j=1; j<this.column-1; j++) {
				if (this.background[i][j].equals(" ") || this.background[i][j].equals("O"))
					counter+=0;
				else
					counter++;
			}
		}
		if (counter == 0) {
			System.out.println("First level cleared! Next level starting now:");
			return true;
		}
		return false;
	}

	public void clearConsole() {
		for (int i = 1; i < this.row-1; i++ ) {
			for (int j=1; j<this.column-1; j++) {
				this.setContent(i,j," ");
			}
		}
	}

	/**
	 * @param brickNum is the number of brick pieces placed side by side
	 * @param brickType is the 'hardness' of the brick
	 * @param brickRow is the row of the brick
	 * @param spaceBetween is the space between bricks
	 * method that creates rows of bricks with appropriate type and spacing
	 */


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

	//Getters

	/**
	 * @return barrier
	 */

	public DestroyableElements[] getBarrier() {
		return barrier;
	}


	//Setters

	/**
	 * @param barrier with base type DestroyableElements
	 */

	public void setBarrier(DestroyableElements[] barrier) {
		this.barrier = barrier;
	}

	/**
	 * @param barrier with base type DestroyableElements
	 */

}
