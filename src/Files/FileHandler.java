package Files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import Expression.ExpressionList;

/**
 * 
 * File Handler class for loading data from file
 *
 */
public class FileHandler {
    private String fileInputPath; // Name of input file
    
    /**
     * Default constructor
     */
    public FileHandler() {
        fileInputPath = "input.text";
    }
    
    /**
     * 
     * @param inputFileName A String representing the name of the input file
     */
    public FileHandler(String fileInputPath) {
        this.fileInputPath = fileInputPath;
    }
    
    public void setFileInputPath(String value) { fileInputPath = value; }
    
    /**
     * Loads data from file, filling an array list with Expression objects.
     * @param expressionList
     * @throws IOException
     */
    public void loadData(ExpressionList expressionList) throws IOException {
        FileInputStream fileInput = new FileInputStream(fileInputPath);
        Scanner inputScanner = new Scanner(fileInput);
        
        
        // TODO Load data from file and create Expression instances to add to list here.
        
        // Close streams
        fileInput.close();
        inputScanner.close();
    }
}
