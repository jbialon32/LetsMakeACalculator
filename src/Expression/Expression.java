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
    
    /**
     * Alternative constructor
     * @param expressionString
     */
    public Expression(String expressionString) {
        this.expressionString = expressionString;
    }
    
    public String getExpressionString() { return expressionString; }
    
    /**
     * Returns the precedence of the passed operator. Must be a string, and not a char because 
     * of multi-character operators.
     * @param operator String 
     * @return An integer representing the precedence level of the operator
     */
    private int precedence(String operator) throws Exception {
    	if (operator.equals("^")) {
    		return 7;
    	} 
    	else if (operator.equals("*") || operator.equals("/") || operator.equals("%")) {
    		return 6;
    	}
    	else if (operator.equals("+") || operator.equals("-")) {
    		return 5;
    	}
    	else if (operator.equals(">") || operator.equals(">=") || operator.equals("<") || operator.equals("<=")) {
    		return 4;
    	}
    	else if (operator.equals("==") || operator.equals("!=")) {
    		return 3;
    	}
    	else if (operator.equals("&&")) {
    		return 2;
    	}
    	else if (operator.equals("||")) {
    		return 1;
    	}
    	else {
    		throw new Exception("Invalid operator \"" + operator + "\" at getPrecedence()");
    	}
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
    
    @Override
    public String toString() {
    	return expressionString;
    }
}
