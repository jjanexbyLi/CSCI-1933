public class Board {

    // Instance variables
    Piece[][] board;

    //TODO:
    // Construct an object of type Board using given arguments.
    public Board() {
         board = new Piece[8][8];
    }

    // Accessor Methods

    //TODO:
    // Return the Piece object stored at a given row and column
    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    //TODO:
    // Update a single cell of the board to the new piece.
    public void setPiece(int row, int col, Piece piece) {
        board[row][col]=piece;
    }

    // Game functionality methods

    //TODO:
    // Moves a Piece object from one cell in the board to another, provided that
    // this movement is legal. A constraint of a legal move is:
    // - there exists a Piece at (startRow, startCol) and the destination square is seizable.
    // Returns a boolean to signify success or failure.
    // This method calls all necessary helper functions to determine if a move is legal,
    // and to execute the move if it is.
    // Your Game class should not directly call any other method of this class.
    // Hint: this method should call isMoveLegal() on the starting piece. 
    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {
        if (board[startRow][startCol] != null && board[endRow][endCol] == null){ //make sure there's a piece at start position and no piece at end position
            if(board[startRow][startCol].isMoveLegal( this, endRow, endCol)){ //make sure a move is legal by the method provided by Piece class
                board[startRow][startCol].setPosition(endRow,endCol);  //update the current position of the successfully moved piece
                board[endRow][endCol] = new Piece(board[startRow][startCol].character,endRow,endCol,board[startRow][startCol].isBlack);  //create a new Piece object at the end position with original character and color
                board[startRow][startCol] = null;   // remove the piece from the start position since it's already moved
                return true;// only when all these conditions satisfied will return true otherwise false
            }
        }
        return false;
    }

    //TODO:
    // Determines whether the game has been ended, i.e., if one player's King
    // has been captured.
    public boolean isGameOver() {
        int num = 0;
        for (int i =0; i<8;i++){
            for (int j =0;j<8;j++) { //loop through all spots on 8x8 board
                if (board[i][j] != null) {
                    if (board[i][j].toString().equals("\u265a") || board[i][j].toString().equals("\u2654")) {
                        num += 1;// a king is on the board of either color
                    }
                    if (num == 2) {
                        return false; //because that means two kings still on the board
                    }
                }
            }
        }
        return true; //that means only one king on the board and that's the end of the game
    }

    // Constructs a String that represents the Board object's 2D array.
    // Returns the fully constructed String.
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(" ");
        for(int i = 0; i < 8; i++){
            out.append(" ");
            out.append(i);
        }
        out.append('\n');
        for(int i = 0; i < board.length; i++) {
            out.append(i);
            out.append("|");
            for(int j = 0; j < board[0].length; j++) {
                out.append(board[i][j] == null ? "\u2001|" : board[i][j] + "|");
            }
            out.append("\n");
        }
        return out.toString();
    }

    //TODO:
    // Sets every cell of the array to null. For debugging and grading purposes.
    public void clear() {
        for (int i = 0; i< board.length;i++){
            for (int j = 0; j<board[i].length;j++){
                board[i][j] = null;
            }
        }
    }

    // Movement helper functions

    //TODO:
    // Ensure that the player's chosen move is even remotely legal.
    // Returns a boolean to signify whether:
    // - 'start' and 'end' fall within the array's bounds.
    // - 'start' contains a Piece object, i.e., not null.
    // - Player's color and color of 'start' Piece match.
    // - 'end' contains either no Piece or a Piece of the opposite color.
    // - where 'start' = (startRow, startCol) and 'end' = (endRow, endCol)
    public boolean verifySourceAndDestination(int startRow, int startCol, int endRow, int endCol, boolean isBlack) {
        if(startRow<8 && startCol <8 && endCol<8 && endRow<8 && startRow>=0 && endCol>=0 && startCol >=0 && endRow>=0){//make sure all the positions input are valid
            if (board[startRow][startCol] != null){ //first to make sure source: there's a piece at the start position
                if (board[endRow][endCol] == null || board[endRow][endCol].getIsBlack() !=board[startRow][startCol].getIsBlack() ){ // Then we have two cases: either no piece at the end position or three's a piece of opposite color
                    if (board[startRow][startCol].getIsBlack() == isBlack ){ //last verify Player's color and color of 'start' Piece match
                        return true;//only when all these conditions satisfied will return true otherwise false
                    }
                }
            }
        }
        return false;
    }

    //TODO:
    // Check whether the 'start' position and 'end' position are adjacent to each other
    public boolean verifyAdjacent(int startRow, int startCol, int endRow, int endCol) {

        if ((Math.abs(endRow-startRow) == 1) && (endCol == startCol)){//adjacent case: one square vertical
            return true;
        } else if ((Math.abs(endCol-startCol)==1) & (endRow == startRow)) { //adjacent case: one square horizontal
            return true;
        } else if (endRow== startRow && endCol == startCol) { //stay still
            return true;
        } else return (Math.abs(endRow - startRow) == 1) & (Math.abs(endCol - startCol) == 1); //adjacent case: one square diagonal
    }

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid horizontal move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one row.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyHorizontal(int startRow, int startCol, int endRow, int endCol) {
        if (endRow == startRow) { //make the move occurs on the same row
            if (endCol < startCol) { //move left
                for (int k = endCol + 1; k < startCol; k++) { // make sure no piece between the start position and the end position
                    if (board[startRow][k] != null) {
                        return false;
                    }
                }
                return true;
            } else if (endCol > startCol) { //move right
                for (int k = startCol + 1; k < endCol; k++) {
                    if (board[startRow][k] != null) {
                        return false;
                    }
                }
                return true;
            } else {
            return true;} //stay still
        }
        return false;
    }


    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid vertical move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one column.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyVertical(int startRow, int startCol, int endRow, int endCol) {
        if (endCol == startCol) { //make the move occurs on the same column
            if (endRow < startRow) { //move downwards
                for (int k = endRow + 1; k < startRow; k++) {
                    if (board[k][endCol] != null) {
                        return false;
                    }
                }
                return true;
            } else if (endRow > startRow) { //move upwards
                for (int k = startRow + 1; k < endRow; k++) {
                    if (board[k][endCol] != null) {
                        return false;
                    }
                }
                return true;
            }else {
                return true;} //stay still
        }
        return false;
    }

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid diagonal move.
    // Returns a boolean to signify whether:
    // - The path from 'start' to 'end' is diagonal... change in row and col.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyDiagonal(int startRow, int startCol, int endRow, int endCol) {
        if (Math.abs(endRow-startRow) == Math.abs(startCol-endCol)) { //Diagonal property check
            if (endRow>startRow && endCol > startCol) {//move right down
                for (int k = 1; k < endRow-startRow; k++) {
                    if (board[startRow+k][startCol+k] !=null){
                        return false;
                    }
                }
                return true;
            } else if (endRow>startRow && endCol < startCol) { //move right down
                for (int k = 1; k < endRow-startRow; k++) {
                    if (board[startRow+k][startCol-k] !=null){
                        return false;
                    }
                }
                return true;
            } else if (endRow<startRow && endCol < startCol) {//move right up
                for (int k = 1; k < startCol-endCol; k++) {
                    if (board[startRow-k][startCol-k] !=null){
                        return false;
                    }
                }
                return true;
            }else if (endRow<startRow && endCol > startCol){//move right up
                for (int k = 1; k < endCol-startCol; k++) {
                    if (board[startRow-k][startCol+k] !=null){
                        return false;
                    }
                }
                return true; //stay still
            } else{return true;}

        }else {
            return false;
        }

    }



}
