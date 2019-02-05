package Files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import Expression.ExpressionList;

/**
 * 
 * File Handler class for saving and loading data to and from files.
 *
 */
public class FileHandler {
    private String fileInputPath; // Name of input file
    private String fileOutputPath; // Name of output file
    
    /**
     * Default constructor
     */
    public FileHandler() {
        fileInputPath = "input.text";
        fileOutputPath = "output.text";
    }
    
    /**
     * 
     * @param inputFileName A String representing the name of the input file
     * @param outputFileName A String representing the name of the output file
     */
    public FileHandler(String fileInputPath, String fileOutputPath) {
        this.fileInputPath = fileInputPath;
        this.fileOutputPath = fileOutputPath;
    }
    
    public void setFileInputPath(String value) { fileInputPath = value; }
    public void setFileOutputPath(String value) { fileOutputPath = value; }
    
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
    
    /**
     * Saves the result list to an output file.
     * @param An int[] array representing the result list to save.
     * @throws IOException
     */
    public void saveResults(int[] results) throws IOException {
        FileOutputStream fileOutput = new FileOutputStream(fileOutputPath);
        PrintWriter printWriter = new PrintWriter(fileOutput);
        
        // TODO Save results to file
        
        // Close streams
        fileOutput.close();
        printWriter.close();
    }
}
