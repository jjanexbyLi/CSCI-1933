import java.util.Scanner;
public class Piece {
    // Create Instance Variables
    char character;
    int row;
    int col;
    boolean isBlack;

    /**
     * Constructor.
     * @param character     The character representing the piece.
     * @param row           The row on the board the piece occupies.
     * @param col           The column on the board the piece occupies.
     * @param isBlack       The color of the piece.
     */
    public Piece(char character, int row, int col, boolean isBlack) {
        this.character = character;
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    /**
     * Determines if moving this piece is legal.
     * @param board     The current state of the board.
     * @param endRow    The destination row of the move.
     * @param endCol    The destination column of the move.
     * @return If the piece can legally move to the provided destination on the board.
     */
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        switch (this.character) {
            case '\u2659':
            case '\u265f':
                Pawn pawn = new Pawn(row, col, isBlack);
                return pawn.isMoveLegal(board, endRow, endCol);
            case '\u2656':
            case '\u265c':
                Rook rook = new Rook(row, col, isBlack);
                return rook.isMoveLegal(board, endRow, endCol);
            case '\u265e':
            case '\u2658':
                Knight knight = new Knight(row, col, isBlack);
                return knight.isMoveLegal(board, endRow, endCol);
            case '\u265d':
            case '\u2657':
                Bishop bishop = new Bishop(row, col, isBlack);
                return bishop.isMoveLegal(board, endRow, endCol);
            case '\u265b':
            case '\u2655':
                Queen queen = new Queen(row, col, isBlack);
                return queen.isMoveLegal(board, endRow, endCol);
            case '\u265a':
            case '\u2654':
                King king = new King(row, col, isBlack);
                return king.isMoveLegal(board, endRow, endCol);
            default:
                return false;
        }
    }

    /**
     * Sets the position of the piece.
     * @param row   The row to move the piece to.
     * @param col   The column to move the piece to.
     */
    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Return the color of the piece.
     * @return  The color of the piece.
     */
    public boolean getIsBlack() {
        if(isBlack) {
            return true;
        } else{
            return false;
        }
    }

    /**
     * Handle promotion of a pawn.
     * @param row Current row of the pawn
     * @param isBlack Color of the pawn
     */
    public void promotePawn(int row, boolean isBlack) {
        if (row == 0 && !isBlack || row == 7 && isBlack ){ //check condition for promotion is satisfied
            System.out.println("Pawn can be promoted, what piece do you want this pawn to be turned into aside from King? ");
            Scanner myScanner = new Scanner(System.in);
            String turnPiece = myScanner.nextLine();
            if (!isBlack){//four cases aside from king for white pieces
                if (turnPiece.equals("Rook")){
                    this.character = '\u2656';
                } else if (turnPiece.equals("Bishop")) {
                    this.character= '\u2657';
                } else if (turnPiece.equals("Knight")) {
                    this.character = '\u2658';
                } else{
                    this.character ='\u2655';
                }
            } else{//four cases aside from king for black pieces
                if (turnPiece.equals("Rook")){
                    this.character = '\u265c';
                } else if (turnPiece.equals("Bishop")) {
                    this.character = '\u265d';
                } else if (turnPiece.equals("Knight")) {
                    this.character = '\u265e';
                } else{
                    this.character = '\u265b';
                }
            }
        }
    }


    /**
     * Returns a string representation of the piece.
     * @return  A string representation of the piece.
     */
    public String toString() {
        String s  = "";
        s += this.character;
        return s;
    }


}
