/**
 * @author T1 Group 1
 * CPSC 233 Fall 2019
 */

public class DestroyableElements extends Environment {
    private int brickType; // number of lives the bricks have
    private int brickLength; // the length of the brick
    private int rowBrick; // the row location of a piece of the brick
    private int columnBrick; // the column location of a piece of the brick
    
    /**
     * @param brickType
     * @param brickLength
     * @param rowBrick
     * @param columBrick
     * 
     * constructor used to initialize bricks w/specific length
     */
    
    public DestroyableElements(int brickType, int brickLength, int rowBrick, int columnBrick) { 
        this.brickType = brickType;
        this.brickLength = brickLength;
        this.rowBrick = rowBrick;
        this.columnBrick = columnBrick;
    }
    
    /**
     * @param brickType
     * @param rowBrick
     * @param columnBrick
     * 
     * constructor used to initialize bricks w/o brick length argument
     */

    public DestroyableElements(int brickType, int rowBrick, int columnBrick) { 
        this.brickLength = 5;
        this.brickType = brickType;
        this.rowBrick = rowBrick;
        this.columnBrick = columnBrick;
    }
    
    /**
     * @return brickType
     * method that returns the brick type
     */

    public int getBrickType() {
        return brickType;
    } // getter for brick type
    
    /**
     * @param brickType
     * method that sets the brick type
     */

    public void setBrickType(int brickType) {
        this.brickType = brickType;
    } // setter for brick type

    /**
     * @return brickLength
     * method that returns the length of brick
     */
    public int getBrickLength() {
        return brickLength;
    } // getter for length of brick
    
    /**
     * @param brickLength
     * method that sets the length of the brick
     */

    public void setBrickLength(int brickLength) {
        this.brickLength = brickLength;
    } // setter for length of brick
    
    /**
     * @param rowBrick
     * method that sets the row location of brick piece 
     */

    public void setRowBrick(int rowBrick) { // setter for the row location of brick piece
        this.rowBrick = rowBrick;
    }
    
    /**
     * @return rowBrick
     * method that returns the row location of brick piece
     */

    public int getRowBrick() {
        return rowBrick;
    } // getter for the row location of brick piece
    
    /**
     * @return columnBrick
     * method that returns the column location of brick piece
     */

    public int getColumnBrick() {
        return columnBrick;
    } // getter for the column location of brick piece
    
    /**
     * @return rowBrick*40
     * method that returns the row location of brick piece
     */

    public int getBrickY() {
        return rowBrick*40;
    } // getter for the row location of brick piece
    
    /**
     * @return colmnBrick*20
     * method that returns the column location of brick piece
     */

    public int getBrickX(){
        return columnBrick*20;
    } // getter for the column location of brick piece
    
    /**
     * @return brickLength*20
     * returns the length of brick
     */


    public int getBrickLengthGUI() {
        return brickLength*20;
    } // getter for length of brick
    
    /**
     * @param columnBrick
     * method that sets the column location of brick piece
     */


    public void setColumnBrick(int columnBrick) { // setter for column location of brick piece
        this.columnBrick = columnBrick;
    }
    
    /**
     * method that decreases the of a brick by 1
     */

    public void destroyBrick(){ 
    }

}
