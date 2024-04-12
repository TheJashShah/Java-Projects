import java.util.*;
import java.util.Random;

public class games {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Text-Based Games!");
        int loop = 1;
        int choice;

        while(loop == 1){
            System.out.println("Select what Game would you like to play: ");
            System.out.println("1. Guess the number.");
            System.out.println("2. Rock, Paper, Scissors.");
            System.out.println("3. Tic-Tac-Toe(Two Players).");
            System.out.println("4. Hangman.");
            System.out.println("5. Exit.");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    GuessNumber();
                    break;
                case 2:
                    RockPaperScissors();
                    break;
                case 3:
                    TicTacToe game = new TicTacToe();
                    game.main();
                    break;
                case 4:
                    hangman game_Hangman = new hangman();
                    game_Hangman.main();;
                    break;
                case 5:
                    System.out.println("Thanks for playing ths game!");
                    loop = 0;
                    break;
                default:
                    System.out.println("Enter an appropriate number.");
                    break;
            }
        }
    }

    @SuppressWarnings("resource")
    static void GuessNumber(){
        Random GuessRandom = new Random();
        Scanner GuessScan = new Scanner(System.in);

        System.out.println("Welcome to Guess the number! ");
        System.out.println("Enter the maximum value for the number to be: ");
        int bound = GuessScan.nextInt();
        int num = GuessRandom.nextInt(bound) + 1;
        int flag = 0;
        int tries = 0;

        while(flag == 0){
            tries += 1;

            System.out.println("Enter your guess: ");
            int userGuess = GuessScan.nextInt();
            
            if(userGuess < num){
                System.out.println("Your Guess is lower!");
            }
            
            else if(userGuess > num){
                System.out.println("Your Guess is higher!");
            }

            else if(userGuess == num){
                System.out.println("Congratulations! You have guessed the number!");
                flag = 1;
            }
        }

        System.out.println("It took you " + tries + " tries.");
    }

    @SuppressWarnings("resource")
    static void RockPaperScissors(){
        Scanner RPSscan = new Scanner(System.in);
        Random RPSrandom = new Random();

        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("Enter how many sets would you want to play: ");
        int set = RPSscan.nextInt();

        int comp = 0, tie = 0, user = 0;

        String CompChoice;
        String CompDisplay = "";
        String UserDisplay = "";

        for(int i = 0; i < set; i++){
            int CompNum = RPSrandom.nextInt(3) + 1;

            if(CompNum == 1){
                CompChoice = "R";
                CompDisplay = "Rock";
            }
            else if(CompNum == 2){
                CompChoice = "P";
                CompDisplay = "Paper";
            }
            else{
                CompChoice = "S";
                CompDisplay = "Scissors";
            }
            
            System.out.println("Enter your choice([R]ock, [P]aper, or [S]cissors): ");
            String userChoice = RPSscan.next().toUpperCase();

            if(userChoice.equals("R")){
                UserDisplay = "Rock";
            }
            else if(userChoice.equals("P")){
                UserDisplay = "Paper";
            }
            else if(userChoice.equals("S")){
                UserDisplay = "Scissors";
            }

            System.out.println("User: " + UserDisplay);
            System.out.println("Computer: "+ CompDisplay);

            if(userChoice.equals(CompChoice)){
                System.out.println("It's a Tie!");
                tie += 1;
            }
            else if(userChoice.equals("R") && CompChoice.equals("P")){
                System.out.println("Computer Wins!");
                comp += 1;
            }
            else if(userChoice.equals("R") && CompChoice.equals("S")){
                System.out.println("Player Wins!");
                user += 1;
            }
            else if(userChoice.equals("P") && CompChoice.equals("R")){
                System.out.println("Player Wins!");
                user += 1;
            }
            else if(userChoice.equals("P") && CompChoice.equals("S")){
                System.out.println("Computer Wins!");
                comp += 1;
            }
            else if(userChoice.equals("S") && CompChoice.equals("P")){
                System.out.println("User Wins!");
                user += 1;
            }
            else if(userChoice.equals("S") && CompChoice.equals("R")){
                System.out.println("Computer Wins!");
                comp += 1;
            }
        }

        System.out.println("Player wins: " + user);
        System.out.println("Ties: " + tie);
        System.out.println("Computer wins: " + comp);
    }
}

