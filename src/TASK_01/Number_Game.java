package TASK_01;

import java.util.Random;
import java.util.Scanner;

public class Number_Game {
    public static void main(String[] args) {
        
        int wonRounds = 0;
        int totalRounds = 0;
        boolean playAgain =true;
        Scanner sc = new Scanner(System.in);
        
        while (playAgain) {            
            wonRounds += playGame();//increase winning rounds on winning
            totalRounds++; //incease total rounds playing
            
            //Ask user to replay the game
            System.out.println("Do you like to play the game again? (Y/N)");
            String playChoice = sc.next();
            
            //check answer without case sensitivity
            playAgain = playChoice.equalsIgnoreCase("y"); 
        }
        
        System.out.println("Thank you for playing!!!");
        
        if (totalRounds > 0) {
            double score = ((double)wonRounds/totalRounds)*100;
            System.out.println("Total Rounds Played: " + totalRounds);
            System.out.println("Total Rounds Won: " + wonRounds);
            System.out.printf("You have scored: %.2f%%\n", score);
        } else {
            System.out.println("You haven't played the game.");
        }
    }

    private static int playGame() {
        
        Random rnd = new Random();
        int numGuess = rnd.nextInt(100) + 1;
        Scanner scan = new Scanner(System.in);
        int guess;
        int attempt = 0;
        int maxAttempt = 5;//Maximum allowed guessing attempts
        
        System.out.println("Welcome to the Number Game!!!");
        System.out.println("Guess what is the number generated by the computer.(1-100)");
        
        while(attempt < maxAttempt){
            guess = scan.nextInt();
            attempt++;
            
            if (guess == numGuess) {
                System.out.println("""
                                   Congratulations!!! You guessed the correct number.
                                   The number is: """ + numGuess);
                return 1;
            }else if (guess < numGuess) {
                System.out.println("Your guess is too low. \n Try Again !!!");
            }else {
                System.out.println("Your guess is too high. \n Try Again!!!");
            }
        }
        
        System.out.println("Sorry you have reached the maximum number of attempts.");
        System.out.println("The correct number was: " + numGuess);
        return 0;
    }
}
