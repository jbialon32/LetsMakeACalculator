package Expression;

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
    
    public int evaluate() throws Exception {
        String[] expressionTokens = expressionString.split(" ");
        Stack<Integer> tokenStack = new Stack<Integer>();
        String currentToken;
        int rightOperand;
        int leftOperand;
        
        for(int i = 0; i < expressionTokens.length; i++) {
            currentToken = expressionTokens[i];
            if(currentToken.matches("\\d+")) { // token is operand
                tokenStack.push(Integer.valueOf(currentToken));
            } else { // token is operator
                rightOperand = Integer.valueOf(tokenStack.pop());
                leftOperand = Integer.valueOf(tokenStack.pop());
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
                } else if(currentToken.equals(">")) {
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
                    else {tokenStack.push(0); }
                } else if(currentToken.equals("&&")) {
                    if(leftOperand == 1 && rightOperand == 1) { tokenStack.push(1); }
                    else { tokenStack.push(0); }
                } else if(currentToken.equals("||")) {
                    if(leftOperand == 1 || rightOperand == 1) { tokenStack.push(1); }
                    else { tokenStack.push(0); }
                }
            }
        }
        return tokenStack.pop();
    }
}
