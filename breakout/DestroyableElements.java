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
     * @param columnBrick
     *
     * constructor used to initialize bricks w/specific length
     */

    public DestroyableElements(int brickType, int brickLength, int rowBrick, int columnBrick) { // constructor used to initialize bricks w/specific length
        this.brickType = brickType;
        this.brickLength = brickLength;
        if (rowBrick<0) {
            throw new IndexOutOfBoundsException();
        }else {
            this.rowBrick = rowBrick;
        }
        if (columnBrick<0) {
            System.out.println(columnBrick);
            System.out.println(this.length());

            throw new IndexOutOfBoundsException();
        } else {
            this.columnBrick = columnBrick;
        }

    }

    /**
     * @param brickType
     * @param rowBrick
     * @param columnBrick
     *
     * constructor used to initialize bricks w/o brick length argument
     */

    public DestroyableElements(int brickType, int rowBrick, int columnBrick) { // constructor used to initialize bricks w/o brick length argument
        this.brickLength = 5;
        this.brickType = brickType;
        if (rowBrick<0) {
            throw new IndexOutOfBoundsException();
        }else {
            this.rowBrick = rowBrick;
        }
        if (columnBrick<0) {
            throw new IndexOutOfBoundsException();
        } else {
            this.columnBrick = columnBrick;
        }
    }

    /** getter that returns the brick type
     * @return brickType
     */

    public int getBrickType() {
        return brickType;
    } // getter for brick type

    /** setter that sets the brick type

     * @param brickType
     */

    public void setBrickType(int brickType) {
        this.brickType = brickType;
    } // setter for brick type

    /** getter that returns the length of brick
     * @return brickLength
     */
    public int getBrickLength() {
        return brickLength;
    } // getter for length of brick

    /** getter that returns the row location of brick piece
     * @return rowBrick
     * method that returns the row location of brick piece
     */

    public int getRowBrick() {
        return rowBrick;
    } // getter for the row location of brick piece

    /** getter that returns the column location of brick piece
     * @return columnBrick
     */

    public int getColumnBrick() {
        return columnBrick;
    } // getter for the column location of brick piece

    /** getter that returns the row location of brick piece
     * @return rowBrick*40
     */

    public int getBrickY() {
        return rowBrick*40;
    } // getter for the row location of brick piece

    /** getter that returns the column location of brick piece
     * @return colmnBrick*20
     */

    public int getBrickX(){
        return columnBrick*20;
    } // getter for the column location of brick piece

    /** getter for the length of brick
     * @return brickLength*20
     */
    public int getBrickLengthGUI() {
        return brickLength*20;
    } // getter for length of brick

}
