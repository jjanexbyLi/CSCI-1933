public class King {
    int row;
    int col;
    boolean isBlack;

    public King(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        if (board.verifySourceAndDestination(row,col,endRow,endCol,isBlack)) {
            return board.verifyAdjacent(row,col,endRow,endCol) ; //king can move adjacent
        }else {
            return false;
        }
    }
}
