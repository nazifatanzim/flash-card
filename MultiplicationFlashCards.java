/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nazifa Tanzim
 */
public class MultiplicationFlashCards extends AbstractFlashCards {

    /**
     *
     * Creates and saves flash cards in a HashMap based on the multiplication
     * table chosen by the user
     *
     * @param multiplier
     */
    public MultiplicationFlashCards(int multiplier) {
        // Calling this method with an array of length 1
        this(new int[]{multiplier});
    }

    /**
     *
     * Creates and saves flash cards in a HashMap based on the multiplication
     * tables chosen by the user
     *
     * @param multipliers
     */
    public MultiplicationFlashCards(int[] multipliers) {
        // Declaring variables
        String question;
        String answer;

        // Iterating through multiplication tables and storing them
        for (int j = 0; j < multipliers.length; j++) {
            for (int i = 1; i <= 12; i++) {
                // Storing multiplicaton expression and answer in HashMap
                question = multipliers[j] + " * " + i;
                answer = Integer.toString(multipliers[j] * i);
                super.addCard(question, answer);
            }
        }
    }
}
