
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
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
public abstract class AbstractFlashCards {

    // Declaring private variables
    private HashMap<String, String> flashCards;
    private ArrayList<String> unansweredCards;
    private int score;
    private Scanner scanner;
    private Random random;

    // Default constructor
    public AbstractFlashCards() {
        // Initializing variables
        flashCards = new HashMap<>();
        unansweredCards = new ArrayList<>();
        score = 0;
        scanner = new Scanner(System.in);
        random = new Random();
    }

    /**
     *
     * Reads the question and answer and holds it in a HashMap Question is the
     * key, Answer is the element Also holds the question in a list of
     * unanswered cards
     *
     * @param question
     * @param answer
     */
    protected void addCard(String question, String answer) {
        // Putting flashcards in a HashMap
        flashCards.put(question, answer);
        // Holding the question in a separate list
        unansweredCards.add(question);
    }

    /**
     *
     * Re-shuffles deck of unanswered cards
     * 
     */
    public void reset() {
        // Creating array list to temporarily hold the list of unanswered cards
        ArrayList<String> temp = new ArrayList<>(unansweredCards);
        
        // Clears original list of unanswered cards
        unansweredCards.clear();
        
        // Iterating through temp until the list is empty
        while (!temp.isEmpty()) {
            // Randomly removing a card from temp and adding it unansweredCards
            unansweredCards.add(temp.remove(random.nextInt(temp.size())));
        }
    }

    /**
     *
     * Checks if the next card to be shown exists by checking the list size
     *
     * @return true if the next card exists
     */
    public boolean hasNext() {
        // Checking if the size is greater than 1
        // If it isn't, that means the user is on the last card
        return (unansweredCards.size() > 1);
    }

    /**
     *
     * Prints flash cards and first question Allows user to input their answer
     * and checks if it is the right answer Removes flash card if the answer is
     * correct Shuffles deck if they are wrong
     *
     * @return true if next card exists
     */
    public boolean nextCard() {

        // Declaring variables
        String userInput;
        String question = unansweredCards.get(0);
        boolean r = true;

        // Printing list of cards in English
        System.out.println(unansweredCards);

        // Playing the game
        // Printing the question
        System.out.println(question);

        // Getting the user's answer
        userInput = scanner.next();

        // Checks if the answer is correct
        if (userInput.equals(flashCards.get(question))) {
            // Removes card from list
            unansweredCards.remove(0);
            // Increases user's score
            score++;
        } else {
            //Re-shuffles list if the answer is incorrect
            reset();
        }

        // Checks if the next card exists and returns false if it doesn't
        if (hasNext()) {
            r = false;
        }
        return r;
    }

    /**
     *
     * Returns user's score
     *
     * @return user's score
     */
    public int getScore() {
        // Returns player score
        return score;
    }
}
