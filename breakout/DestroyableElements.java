package breakout;

public class DestroyableElements extends Environment {
    private int brickType; // number of lives the bricks have
    private int brickLength; // the length of the brick
    private int rowBrick; // the row location of a piece of the brick
    private int columnBrick; // the column location of a piece of the brick

    public DestroyableElements(int brickType, int brickLength, int rowBrick, int columnBrick) { // constructor used to initialize bricks w/specific length
        this.brickType = brickType;
        this.brickLength = brickLength;
        this.rowBrick = rowBrick;
        this.columnBrick = columnBrick;
    }

    public DestroyableElements(int brickType, int rowBrick, int columnBrick) { // constructor used to initialize bricks w/o brick length argument
        this.brickLength = 5;
        this.brickType = brickType;
        this.rowBrick = rowBrick;
        this.columnBrick = columnBrick;
    }

    public int getBrickType() {
        return brickType;
    } // getter for brick type

    public void setBrickType(int brickType) {
        this.brickType = brickType;
    } // setter for brick type

    public int getBrickLength() {
        return brickLength;
    } // getter for length of brick

    public void setBrickLength(int brickLength) {
        this.brickLength = brickLength;
    } // setter for length of brick

    public int getRowBrick() {
        return rowBrick;
    } // getter for the row location of brick piece

    public void setRowBrick(int rowBrick) { // setter for the row location of brick piece
        this.rowBrick = rowBrick;
    }

    public int getColumnBrick() {
        return columnBrick;
    } // getter for the column location of brick piece

    public void setColumnBrick(int columnBrick) { // setter for column location of brick piece
        this.columnBrick = columnBrick;
    }

    public void destroyBrick(){ // decreases the the life of brick by 1
    }

}
