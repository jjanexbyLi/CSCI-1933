
import java.lang.Math;

public class Knight {
    int row;
    int col;
    boolean isBlack;
    public Knight(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        if (board.verifySourceAndDestination(row,col,endRow,endCol,isBlack)){
            return (Math.abs(endRow-row)== 1 && Math.abs(endCol-col) == 2) || (Math.abs(endRow-row)== 2 && Math.abs(endCol-col) == 1);//two cases for knight: either 2 rows and 1 col away or 1 row and 2 cols away
        } else {
            return false;
        }
    }
}
