import java.util.Random;
import java.util.Scanner;;

class hangman{
    String[] words = {"HELLO", "JAVA", "WORLD", "PUBLIC"};
    int MAX_TRIES = 7;

    Random random = new Random();
    Scanner sc = new Scanner(System.in);
    int tries = MAX_TRIES;
    String word = words[random.nextInt(words.length)];
    StringBuilder CurrentWord = new StringBuilder("_".repeat(word.length()));
    int userTries = 0;

    void main(){
        System.out.println("Welcome to Hangman!");
        System.out.println("This is the word: ");
        System.out.println(CurrentWord);

        while(tries > 0 && CurrentWord.toString().contains("_")){
            System.out.println("Tries left: " + tries);
            System.out.println("Enter your guess: ");
            char guess = sc.next().toUpperCase().charAt(0);

            if(!UpdateWord(guess)){
                tries--;
                userTries++;
                System.out.println("Incorrect guess! Try again.");
            }
            else{
                userTries++;
                System.out.println("Correct guess!");
            }

            System.out.println(CurrentWord);
        }

        if(CurrentWord.toString().contains("_")){
            System.out.println("You lost! The word was: " + word);
        }
        else{
            System.out.println("Congratulations! You won! You did it in: " + userTries + " tries.");
        }
    }

    boolean UpdateWord(char guess){
        boolean isUpdate = false;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == guess){
                CurrentWord.setCharAt(i, guess);
                isUpdate = true;
            }
        }
        return isUpdate;
    }


}