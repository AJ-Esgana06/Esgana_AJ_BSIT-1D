import java.util.*;
public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in
        int remainingAttempts = 5;
        String secretWord = "grouptwo";
        
        while (remainingAttempts > 0) {
            System.out.println("What is the secret word: ");
            String guess = sc.next();
            
        if (guess.equals(secretWord)) {
            System.out.println("Correct!");
        } else if (guess.length > secretWord.length()) {
            System.out.println("Too long");
        } else if (guess.length < secretWord.length()) {
            System.out.println("Too short");   
        } else {
            System.out.println("Okay");
        } 
        } remainingAttempts
        System.out.println("You have remaining "+ remainingAttempts);
        
        if (remainingAttempts == 0) {
            System.out.println("The secret word is " + secretWord);
            System.out.println("You have 0 remaining attempts left
        }
        
        System.out.println("Thank you for playing");
        System.out.println();
        
    
    
    
    
    }
}
