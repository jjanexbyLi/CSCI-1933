public class Rook {
    int row;
    int col;
    boolean isBlack;
    public Rook(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        if (board.verifySourceAndDestination(row,col,endRow,endCol,isBlack)) { //check id legal to move
            return board.verifyVertical(row,col,endRow,endCol) || board.verifyHorizontal(row,col,endRow,endCol);//rook can move horizontal and vertical
        }else {
            return false;
        }
    }
}
