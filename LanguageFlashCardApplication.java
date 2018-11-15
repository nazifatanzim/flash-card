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
public class LanguageFlashCardApplication {

    public static void main(String[] args) {
        // Declaring variables
        String filename;
        Scanner scanner = new Scanner(System.in);
        String next;
        
        // Prompting user to enter file that contains flashcards
        System.out.println("What is the filename containing your flashcards? Exact letters!");
        // Getting user input
        filename = scanner.next();
        // Instanciating a new game of type LanguageFlashCards
        AbstractFlashCards game = new LanguageFlashCards(filename);

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
            
            // Checks if user has gained the max number of points
            if(score < 13){
                // Asks user if they want to move on
                System.out.println("Next? (Y or N)");
                // Gets user's answer
                next = scanner.next();
            }
            else{
                // Forces game to end once all the cards are done
                break; 
            }
        // Continues the game while the user wants to continue
        } while ((next.toUpperCase()).equals("Y"));
        
        // Prints out the user's final score
        System.out.println("You've got a score of " + score + " so far");
    }
}