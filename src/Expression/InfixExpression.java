package Expression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Class representing a single expression loaded in from the input file
 */
public class InfixExpression {
    private String expressionString; // String representing the initial expression
    
    /**
     * Default constructor
     */
    public InfixExpression() {
        expressionString = "1 + 1";
    }
    
    /**
     * Alternative constructor
     * @param expressionString
     */
    public InfixExpression(String expressionString) {
        this.expressionString = expressionString;
    }
    
    public String getExpressionString() { return expressionString; }
    public void setExpressionString(String expressionString) { this.expressionString = expressionString; }
    
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
     * @throws Exception 
     */
    public String convertToPostfix() throws Exception {
        // TODO Convert the infix expression to post-fix expression and return it.
        String[] expressionTokens = expressionString.split("");
        String currentToken;
        String postfixString = "";
        Stack<String> tokenStack = new Stack<String>();
        ArrayList<String> singleOperators = new ArrayList<String>(
                Arrays.asList("^", "*", "/", "%", "+", "-",
                        ">", "<", "=", "!", "&", "|"));
        
        for(int i = 0; i < expressionTokens.length; i++) {
            currentToken = expressionTokens[i];
            if(currentToken.matches("\\d")) { // currentToken is 0-9
                while((i != expressionTokens.length - 1) && expressionTokens[i + 1].matches("\\d")) { // While the next token in array is also an integer
                    currentToken += expressionTokens[i + 1]; // Add to current token and increase iterator over token
                    i++;
                }
                postfixString += currentToken + " "; // Add the number to the postfixString
            } else if(currentToken.equals("(")) {
                tokenStack.push(currentToken);
            } else if(singleOperators.contains(currentToken)) { 
                if(i != expressionTokens.length - 1) { // Ensure not last token
                    
                    // TODO Would like to handle this in another method if possible?
                    if(currentToken.equals("<") && expressionTokens[i + 1].equals("=")) {
                        currentToken += expressionTokens[i + 1];
                        i++;
                    }
                    if(currentToken.equals(">") && expressionTokens[i + 1].equals("=")) {
                        currentToken += expressionTokens[i + 1];
                        i++;
                    }
                    if(currentToken.equals("=") && expressionTokens[i + 1].equals("=")) {
                        currentToken += expressionTokens[i + 1];
                        i++;
                    }
                    if(currentToken.equals("!") && expressionTokens[i + 1].equals("=")) {
                        currentToken += expressionTokens[i + 1];
                        i++;
                    }
                    if(currentToken.equals("&") && expressionTokens[i + 1].equals("&")) {
                        currentToken += expressionTokens[i + 1];
                        i++;
                    }
                    if(currentToken.equals("|") && expressionTokens[i + 1].equals("|")) {
                        currentToken += expressionTokens[i + 1];
                        i++;
                    }
                }
                
                while(!tokenStack.isEmpty() && !tokenStack.peek().equals("(")
                        && precedence(currentToken) <= precedence(tokenStack.peek())) {
                    postfixString += tokenStack.pop() + " ";
                }
                tokenStack.push(currentToken);
            } else if(currentToken.equals(")")){
                while(!tokenStack.peek().equals("(")) {
                    postfixString += tokenStack.pop() + " ";
                }
                tokenStack.pop();
            }
        }
        
        while(!tokenStack.isEmpty()) {
            postfixString += tokenStack.pop() + " ";
        }
        return postfixString.substring(0, postfixString.length() - 1);
    }
    
    /**
     * This should first convert the expressionString to a post-fix expression
     * via the convertToPostFix method, and then evaluate it, returning the result.
     * @return
     * @throws Exception 
     */
    public int evaluate() throws Exception {
        PostfixExpression postfix = new PostfixExpression(convertToPostfix());
        return postfix.evaluate();
    }
    
    @Override
    public String toString() {
    	return expressionString;
    }
}