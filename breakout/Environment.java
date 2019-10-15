package breakout;

public class Environment {
	private String[][] background;
	int row, column;
	
	public Environment() {
		row = 15;
		column = 40;
		background = new  String[row][column];
	}
	
	public Environment(int r, int c) {
		row = r+1;
		column = c+1;
		background = new  String[row][column];
	}
	
	public void setEnvironment() {
		
		for (int i = 0; i < row; i++) {
			
			if (i == 0 || i == row-1) {
				for (int j = 0; j < column ; j++) {
					background [i][j] = "-";
				}
				
			} else if (i > 0 && i < row-1) {
				
				for (int c = 0 ; c < column; c++) {
					if (c==0 || c==column-1) {
						background [i][c] = "|";
					} else if (c > 0 && c < column-1) {					
						background [i][c] = " ";
					}
				}
			}
		}
	}
	
	public void drawBrick(Brick brick){
		for (int i = 0; i != brick.getBrickLength();i++){
			background[brick.getRowBrick()][brick.getColumnBrick()+i] = brick.getBrickType() +"";
		}
	}


	public void drawBricks(Brick[] bricks){
		for (Brick brick: bricks){
			for (int i = 0; i != brick.getBrickLength();i++){
				background[brick.getRowBrick()][brick.getColumnBrick()+i] = brick.getBrickType() +"";
			}
		}
	}
	
	public void setContent(int r, int c, String value) {
		background [r][c] = value;
	}
	
	public String getContent(int r, int c) {
		String content = background [r][c];
		return content;
	}
	
	public int height(){
		return row-1; 
	}
	
	public int length(){
		return column-1; 
	}
	
	public void printEnvironment() {
		for (int i = 0 ; i < row ; i++) {
			for (int j = 0 ; j < column; j++) {
				System.out.print(background[i][j]);
			}
			System.out.println();
		}
	}
}
