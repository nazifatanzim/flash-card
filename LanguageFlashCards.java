import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nazifa Tanzim
 */
public class LanguageFlashCards extends AbstractFlashCards{
    // Declaring variables
    private static String COMMA_DELIMETER = ",";
    private String filename;
    
    /**
     *
     * Opens file containing language flash cards info and
     * creates and saves flash cards in a HashMap
     * 
     * @param filename
     */
    public LanguageFlashCards(String filename) {
        // Initializing variables
        this.filename = filename;
        BufferedReader reader = null;
        
        try
        {   
            // Declaring and initializing variables
            Reader inputFile = new FileReader(filename);
            reader = new BufferedReader(inputFile);
            String line = reader.readLine(); // Starting at first line so that 
                                             // the title lines are skipped
            
            // Iterates through each line (not including title lines)
            while((line = reader.readLine()) != null)
            {
                // Creates a new card and stores it in HashMap
                super.addCard(line.split(COMMA_DELIMETER)[0], line.split(COMMA_DELIMETER)[1]);
            }
            // Closes reader
            reader.close();
        }    
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
