package Expression;

/**
 * Class representing a single expression loaded in from the input file
 */
public class Expression {
    private String expressionString; // String representing the initial expression
    
    /**
     * Default constructor
     */
    public Expression() {
        expressionString = "1 + 1";
    }
    
    public Expression(String expressionString) {
        this.expressionString = expressionString;
    }
    
    /**
     * 
     * @param operator A char representing the operator to get the precedence level of
     * @return An integer representing the precedence level of the operator
     */
    private int precedence(char operator) {
        // TODO Return the precedence value of the operator 
        return 0;
    }
    
    /**
     * Converts the infix expression to a post-fix expression
     * @return A String representing the same expression as a post-fix expression.
     */
    private String convertToPostFix(String expression) {
        // TODO Convert the infix expression to post-fix expression and return it.
        return "";
    }
    
    /**
     * This should first convert the expressionString to a post-fix expression
     * via the convertToPostFix method, and then evaluate it, returning the result.
     * @return
     */
    public int evaluate() {
        // TODO Evaluate expression here and return result
        return 0;
    }
}
