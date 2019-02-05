package Application;

import java.io.IOException;

import Expression.ExpressionList;
import Files.FileHandler;

public class Application {
    public static void main(String[] args) throws IOException {
        FileHandler fileHandler = new FileHandler();
        ExpressionList expressionList = new ExpressionList();
        int[] results;
        
        System.out.println("Loading data from file...");
        fileHandler.loadData(expressionList);
        System.out.println("Evaluating expressions...");
        results = expressionList.generateResultList();
        System.out.println("Saving results...");
        fileHandler.saveResults(results);
    }
}
