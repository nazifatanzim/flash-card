import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nazifa Tanzim
 */
public class MultiplicationFlashCardApplication {
    public static void main(String[] args){
        // Declaring variables
        Scanner scanner = new Scanner(System.in);
        int num;
        String next;
        
        // Prompting user to input how many times tables they want to practice
        System.out.println("How many multipliers would you like to test? Max 12");
        // Getting user input
        num = scanner.nextInt();
        
        // Declaring and initializing array
        int[] multipliers = new int[num];
        
        // Prompting user to input which times table(s) they would like to practice
        System.out.println("Which times tables would you like to test? (Between 1 and 12 inclusive)");
        
        // Filling array with the times tables that the user wants to practice
        for(int i = 0; i < num; i++){
            multipliers[i] = scanner.nextInt();
        }
        
        // Creating new game
        AbstractFlashCards game = new MultiplicationFlashCards(multipliers);
        
        // Shuffles cards in advance
        game.reset();
        
        // Keeping track of score
        int score = game.getScore();

        // Playing the actual game
        do {
            // Getting the question from the list of cards
            game.nextCard();
            // Checks if the answer is correct by seeing if the score increased
            if (score != game.getScore()) {
                // Updating the score
                score = game.getScore();
                // Telling the user that they are correct
                System.out.println("You're correct!");
            } else {
                // Tells the user they are wrong if the score stays the same
                System.out.println("Sorry, please try again");
            }

            // Outputs the score
            System.out.println("Score = " + score);
            
            if(score < (num * 12)){
                // Asks user if they want to move on
                System.out.println("Next? (Y or N)");
                // Gets user's answer
                next = scanner.next();
            }
            else{
                // Forces game to end once all the cards are done
                next = "n"; 
            }
        // Continues the game while the user wants to continue
        } while ((next.toUpperCase()).equals("Y"));
        
        // Prints out the user's final score
        System.out.println("You've got a score of " + score + " so far");
    }
}
