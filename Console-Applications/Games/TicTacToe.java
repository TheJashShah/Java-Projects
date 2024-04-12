import java.util.*;

class TicTacToe{

    Scanner Tscanner = new Scanner(System.in);

    String PlayerOne = " ";
    String PlayerTwo = " ";
    String[] board = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "};

    boolean GameOver = false;

    void InitialPrint(){
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Enter character for Player 1(Player 1 goes first (X/O)): ");
        PlayerOne = Tscanner.next().toUpperCase();

        if(PlayerOne.equals("X")){
            PlayerTwo = "O";
        }
        else if(PlayerOne.equals("O")){
            PlayerTwo = "X";
        }

        DisplayBoard();
    }

    void TakeInputOne(){
        System.out.println("Player 1, enter where would you place your mark(enter 1-9): ");
        int place = Tscanner.nextInt();

        if(board[place].equals(" ")){
            board[place] = PlayerOne;
        }
        else{
            System.out.println("A mark already exists there.");
            TakeInputOne();
        }

        DisplayBoard();
    }

    void TakeInputTwo(){
        System.out.println("Player 2, enter where would you place your mark(enter 1-9): ");
        int place = Tscanner.nextInt();

        if(board[place].equals(" ")){
            board[place] = PlayerTwo;
        }
        else{
            System.out.println("A mark already exists there.");
            TakeInputTwo();
        }

        DisplayBoard();
    }

    void DisplayBoard(){

        System.out.println("Here is the Board: ");

        System.out.println("---|---|---");
        System.out.println(board[1] + "  | " + board[2] + " | " + board[3]);
        System.out.println("---|---|---");
        System.out.println(board[4] + "  | " + board[5] + " | " + board[6]);
        System.out.println("---|---|---");
        System.out.println(board[7] + "  | " + board[8] + " | " + board[9]);
        System.out.println("---|---|---");
    }

    boolean CheckWin(String mark){
        boolean isWon = false;

        if((board[1].equals(mark) && board[2].equals(mark) && board[3].equals(mark)) || (board[4].equals(mark) && board[5].equals(mark) && board[6].equals(mark)) || (board[7].equals(mark) && board[8].equals(mark) && board[9].equals(mark)) || (board[1].equals(mark) && board[4].equals(mark) && board[7].equals(mark)) || (board[2].equals(mark) && board[5].equals(mark) && board[8].equals(mark)) || (board[3].equals(mark) && board[6].equals(mark) && board[9].equals(mark)) || (board[1].equals(mark) && board[5].equals(mark) && board[9].equals(mark)) || (board[3].equals(mark) && board[5].equals(mark) && board[7].equals(mark))){
            isWon = true;
        }

        return isWon;
    }

    boolean isDraw(){
        boolean isDraw = false;
        int space = 0;

        for(int i = 0; i < board.length; i++){
            if(board[i].equals(" ")){
                space += 1;
            }
        }

        if(CheckWin(PlayerOne)){
            isDraw = false;
        }
        else if(CheckWin(PlayerTwo)){
            isDraw = false;
        }
        else if(!CheckWin(PlayerOne) && !CheckWin(PlayerTwo) && space == 1){
            isDraw = true;
        }

        return isDraw;
    }

    void main(){
        InitialPrint();

        do{
            TakeInputOne();

            if(CheckWin(PlayerOne)){
                System.out.println("Player 1 wins!");
                GameOver = true;
                break;
            }

            if(CheckWin(PlayerTwo)){
                System.out.println("Player 2 wins!");
                GameOver = true;
                break;
            }

            if(isDraw()){
                System.out.println("It's a Draw!");
                GameOver = true;
                break;
            }

            TakeInputTwo();

            if(CheckWin(PlayerOne)){
                System.out.println("Player 1 wins!");
                GameOver = true;
                break;
            }

            if(CheckWin(PlayerTwo)){
                System.out.println("Player 2 wins!");
                GameOver = true;
                break;
            }

            if(isDraw()){
                System.out.println("It's a Draw!");
                GameOver = true;
                break;
            }

        }while(!GameOver);
    }
}