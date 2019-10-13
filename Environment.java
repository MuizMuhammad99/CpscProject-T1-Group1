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
		row = r;
		column = c;
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
	
	public void printEnvironment() {
		for (int i = 0 ; i < row ; i++) {
			for (int j = 0 ; j < column; j++) {
				System.out.print(background[i][j]);
			}
			System.out.println();
		}
	}
}
