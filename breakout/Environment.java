package breakout;

public class Environment {
	
	private String[][] background; // Array for playing field
	int row, column;
	
	public Environment() { //default constructor
		row = 15;
		column = 40;
		background = new  String[row][column];
	}
	
	public Environment(int r, int c) { // constructor initializing row and column
		row = r+1;
		column = c+1;
		background = new  String[row][column];
	}
	
	public Environment(Environment e) {
		background = e.background;
		row = e.row;
		column = e.column;
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
	
	public void drawBrick(Brick brick){ // a method that draws a 'piece' of brick
		for (int i = 0; i != brick.getBrickLength();i++){
			setContent(brick.getRowBrick(),brick.getColumnBrick()+i, brick.getBrickType()+"");
		}
	}


	public void drawBricks(Brick[] bricks){ // a method that draws the entire brick
		for (Brick brick: bricks){
			for (int i = 0; i != brick.getBrickLength();i++){
				setContent(brick.getRowBrick(),brick.getColumnBrick()+i, brick.getBrickType()+"");
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
	
	public void drawEnvironment() {
		
	}
}
