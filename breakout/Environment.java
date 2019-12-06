package breakout;

import java.util.ArrayList;

public class Environment{
//public class Environment {

	private String[][] background; // Array for playing field
	private int row, column;
	private ArrayList<DestroyableElements> barrier= new ArrayList<DestroyableElements>();; //Array that creates the space for playing field


	public Environment() { //default constructor
		row = 15;
		column = 40;
		background = new  String[row][column];
	}
	
	public Environment(int r, int c) { // constructor initializing row and column
		this();
		if (r>0 && c >0) {
			row = r+1;
			column = c+1;
		}		
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

	
	public void setContent(int r, int c, String value) {
		background [r][c] = value;
	} // method that assigns a character or word at any given space within the boundaries of the playing field
	
	public void setContent(int r, int c, int v) {
		String value = v+"";
		background [r][c] = value;
	}
	
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
	
	public void drawRowOfBricks(int brickNum, int brickType, int brickRow, int spaceBetween) {
		int numOfBricks=brickNum;
		int typeOfBricks= brickType;
		int rowOfBricks= brickRow;
		
		int spacing = spaceBetween;
		int lengthOfBricks = (column-2*spacing) / numOfBricks - spacing;
		
		
		for (int i = spacing+1 ; i < column-lengthOfBricks ; i+= lengthOfBricks+spacing) {
			barrier.add(new DestroyableElements(typeOfBricks, lengthOfBricks,rowOfBricks,i));
			
			for (int j = 0 ; j < barrier.size() ; j++) {
				int r, c, type, length;
				length = barrier.get(j).getBrickLength();
				r = barrier.get(j).getRowBrick();
				c = barrier.get(j).getColumnBrick();
				type = barrier.get(j).getBrickType();
				for (int k = c ; k < c+length ; k++) {
					this.setContent(r, k, type);
				}
			}
		}
	}

	public ArrayList<DestroyableElements> getBarrier() {
		return barrier;
	}

}
