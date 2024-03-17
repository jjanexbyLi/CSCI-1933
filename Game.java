import java.util.Scanner;
public class Game {

    public static void main(String[] args){
        Board myBoard = new Board();
        Fen.load("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR", myBoard);
        boolean whichTurn  = false; //create a boolean to change the color
        while(!myBoard.isGameOver()){
            System.out.println(myBoard.toString());
            if(!whichTurn){
                System.out.println("It is currently white's turn to play "); // !whichTurn means white
            } else{
                System.out.println("It is currently black's turn to play "); // whichTurn means black
            }
            System.out.println("What is your move? (format: [start row] [start col] [end row] [end col])");
            Scanner myScanner = new Scanner(System.in);
            String movement = myScanner.nextLine();
            String[] results = movement.split(" ");
            int startRow = Integer.parseInt(results[0]);
            int startCol = Integer.parseInt(results[1]);
            int endRow = Integer.parseInt(results[2]);
            int endCol = Integer.parseInt(results[3]);
            if(myBoard.movePiece(startRow,startCol,endRow,endCol)){// Once the move is legal, change the turn!
                myBoard.getPiece(endRow,endCol).promotePawn(endRow,whichTurn); //check if the pawn can be promoted
                whichTurn = !whichTurn ;
            }
        }
        if (whichTurn == false) {System.out.println("Black has won the game!"); //That means black wins before the turn changes
        }else{
            System.out.println("White has won the game!"); //That means white wins before the turn changes
        }

    }
}
