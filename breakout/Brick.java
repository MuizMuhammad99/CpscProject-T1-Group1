package breakout;

public class Brick {
    private int brickType;
    private int brickLength;
    private int rowBrick;
    private int columnBrick;

    public Brick(int brickType, int brickLength, int rowBrick, int columnBrick) {
        this.brickType = brickType;
        this.brickLength = brickLength;
        this.rowBrick = rowBrick;
        this.columnBrick = columnBrick;
    }

    public Brick(int brickType, int rowBrick, int columnBrick) {
        this.brickLength = 5;
        this.brickType = brickType;
        this.rowBrick = rowBrick;
        this.columnBrick = columnBrick;
    }

    public int getBrickType() {
        return brickType;
    }

    public void setBrickType(int brickType) {
        this.brickType = brickType;
    }

    public int getBrickLength() {
        return brickLength;
    }

    public void setBrickLength(int brickLength) {
        this.brickLength = brickLength;
    }

    public int getRowBrick() {
        return rowBrick;
    }

    public void setRowBrick(int rowBrick) {
        this.rowBrick = rowBrick;
    }

    public int getColumnBrick() {
        return columnBrick;
    }

    public void setColumnBrick(int columnBrick) {
        this.columnBrick = columnBrick;
    }

    public void destroyBrick(){
    }

}
