package Application;

import Expression.ExpressionList;
import Files.FileHandler;

public class Application {
    public static void main(String[] args) throws Exception {
        FileHandler fileHandler = new FileHandler();
        ExpressionList expressionList = new ExpressionList();
        
        System.out.println("Loading data from file...");
        fileHandler.loadData(expressionList);
        System.out.println("Evaluating expressions...");
        // Output results to console.
        expressionList.outputResults();
    }
}
