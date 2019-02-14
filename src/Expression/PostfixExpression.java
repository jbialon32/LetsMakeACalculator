package Expression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class PostfixExpression {
    private String expressionString;
    
    public PostfixExpression() {
        expressionString = "1 1 +";
    }
    
    public PostfixExpression(String _expressionString) {
        expressionString = _expressionString;
    }
    
    public String getExpressionString() { return expressionString; }
    
    /**
     * Handles the evaluation of comparison and logical operators between
     * the given left and right operands and pushes the result to the stack.
     * @param currentToken A string representing the current operator
     * @param leftOperand int representing the left operand
     * @param rightOperand int representing the right operand
     * @throws Exception
     */
    public void relationalEval(Stack<Integer> tokenStack, String currentToken, int leftOperand, int rightOperand) throws Exception {
        
        if(currentToken.equals(">")) {
            if(leftOperand > rightOperand) { tokenStack.push(1); }
            else { tokenStack.push(0); }
        } else if(currentToken.equals(">=")) {
            if(leftOperand >= rightOperand) { tokenStack.push(1); }
            else { tokenStack.push(0); }
        } else if(currentToken.equals("<")) {
            if(leftOperand < rightOperand) { tokenStack.push(1); }
            else { tokenStack.push(0); }
        } else if(currentToken.equals("<=")) {
            if(leftOperand <= rightOperand) { tokenStack.push(1); }
            else { tokenStack.push(0); }
        } else if(currentToken.equals("==")) {
            if(leftOperand == rightOperand) { tokenStack.push(1); }
            else { tokenStack.push(0); }
        } else if(currentToken.equals("!=")) {
            if(leftOperand != rightOperand) { tokenStack.push(1); }
            else { tokenStack.push(0); }
        } else if(currentToken.equals("&&")) {
            if(leftOperand == 1 && rightOperand == 1) { tokenStack.push(1); }
            else { tokenStack.push(0); }
        } else if(currentToken.equals("||")) {
            if(leftOperand == 1 || rightOperand == 1) { tokenStack.push(1); }
            else { tokenStack.push(0); }
        } else {
            throw new Exception("Invalid Operator");
        }        
    }
    
    /**
     * Handles the evaluation of non-comparison and non-logical operators(ie: +, -, /, *)
     * between the given left and right operands and pushes the result to the stack.
     * @param currentToken A string representing the current operator
     * @param leftOperand int representing the left operand
     * @param rightOperand int representing the right operand
     * @throws Exception
     */
    public void operatorEval(Stack<Integer> tokenStack, String currentToken, int leftOperand, int rightOperand) 
    		throws Exception {
        
        if(currentToken.equals("+")) {
            tokenStack.push(leftOperand + rightOperand);
        } else if(currentToken.equals("-")) {
            tokenStack.push(leftOperand - rightOperand);
        } else if(currentToken.equals("*")) {
            tokenStack.push(leftOperand * rightOperand);
        } else if(currentToken.equals("/")) {
            if(rightOperand == 0) {
                throw new Exception("Divide by zero error.");
            } else {
                tokenStack.push(Math.floorDiv(leftOperand, rightOperand));
            }
        } else if(currentToken.equals("%")) {
            tokenStack.push(leftOperand % rightOperand);
        } else if(currentToken.equals("^")) {
            tokenStack.push((int)Math.pow((double)leftOperand, (double)rightOperand));
        } else {
            throw new Exception("Invalid operator");
        }
    }
    
    /**
     * Evaluates the expression and returns the result and an int.
     * @return returns an int as the result of the evaluated expression
     * @throws Exception
     */
    public int evaluate() throws Exception {
        // Lists for detecting which method to call to evaluate left and right operands.
        ArrayList<String> normalOperators = new ArrayList<String>(
                Arrays.asList("+", "-", "/", "*", "^", "%"));
        ArrayList<String> relationalOperators = new ArrayList<String>(
                Arrays.asList("<", "<=", "==", ">", ">=", "&&", "||", "!="));
        String[] expressionTokens = expressionString.split(" "); // Split expression into tokens, delimited by spaces
        Stack<Integer> tokenStack = new Stack<Integer>();
        String currentToken;
        int rightOperand;
        int leftOperand;
        
        for(int i = 0; i < expressionTokens.length; i++) {
            currentToken = expressionTokens[i];
            if(currentToken.matches("\\d+")) { // token is operand (regex shorthand for any number of digits)
                tokenStack.push(Integer.valueOf(currentToken));
            } else { // token is operator               
            	rightOperand = Integer.valueOf(tokenStack.pop());
                leftOperand = Integer.valueOf(tokenStack.pop());
                
                if(normalOperators.contains(currentToken)) {
                    operatorEval(tokenStack, currentToken, leftOperand, rightOperand);
                } else if(relationalOperators.contains(currentToken)) {
                    relationalEval(tokenStack, currentToken, leftOperand, rightOperand);
                }
            }
        }
        return tokenStack.pop(); // The only int left in the stack should be the result
    }
}
