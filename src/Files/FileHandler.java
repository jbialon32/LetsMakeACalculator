package Files;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import Expression.Expression;
import Expression.ExpressionList;

/**
 * 
 * File Handler class for loading data from file
 *
 */
public class FileHandler {
    private String inputFileName; // Name of input file
    
    /**
     * Default constructor
     */
    public FileHandler() {
        inputFileName = "input.txt";
    }
    
    /**
     * 
     * @param inputFileName A String representing the name of the input file
     */
    public FileHandler(String inputFileName) {
        this.inputFileName = inputFileName;
    }
    
    public void setInputFileName(String value) { inputFileName = value; }
    
    /**
     * Loads data from file, filling an array list with Expression objects.
     * @param expressionList
     * @throws IOException
     */
    public void loadData(ExpressionList expressionList) throws IOException {
        FileInputStream fileInput = new FileInputStream(inputFileName);
        Scanner inputScanner = new Scanner(fileInput);
        
        
        // Load data from file and create Expression instances to add to list.
        String expressionString;
        Expression expression;
        while(inputScanner.hasNext()) {
            expressionString = inputScanner.nextLine();
            expression = new Expression(expressionString);
            expressionList.add(expression);
        }
        
        // Close streams
        fileInput.close();
        inputScanner.close();
    }
}
