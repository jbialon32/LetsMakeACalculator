package Expression;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class ExpressionTest {

    
    @Test
    public void infixToPostFixTest() throws Exception {
        InfixExpression tester = new InfixExpression("3 + 3");
        
        assertEquals("3 3 +", "3 3 +", tester.convertToPostfix());
        tester.setExpressionString("3 + 4 - 7");
        assertEquals("3 4 + 7 -", "3 4 + 7 -", tester.convertToPostfix());
        tester.setExpressionString("3 / 1 + 2 - 7 * 4");
        assertEquals("3 1 / 2 + 7 4 * -", "3 1 / 2 + 7 4 * -", tester.convertToPostfix());
        tester.setExpressionString("22*100/23+(14*11)");
        assertEquals("22 100 * 23 / 14 11 * +", "22 100 * 23 / 14 11 * +", tester.convertToPostfix());
        tester.setExpressionString("22 > 1");
        assertEquals("22 1 >", "22 1 >", tester.convertToPostfix());
        tester.setExpressionString("22 <= 1");
        assertEquals("22 1 <=", "22 1 <=", tester.convertToPostfix());
        
        tester.setExpressionString("22*34/100-(65-100) >= 2 && 1 == 3");
        assertEquals("22 34 * 100 / 65 100 - - 2 >= 1 3 == &&", "22 34 * 100 / 65 100 - - 2 >= 1 3 == &&", tester.convertToPostfix());
        
        tester.setExpressionString("(3*4/16) + 204 - (16 ^ 5) * (203/4)");
        assertEquals("3 4 * 16 / 204 + 16 5 ^ 203 4 / * -", "3 4 * 16 / 204 + 16 5 ^ 203 4 / * -", tester.convertToPostfix());
        
        tester.setExpressionString("30 / ((6*6) - 36)");
        assertEquals("30 6 6 * 36 - /", "30 6 6 * 36 - /", tester.convertToPostfix());
    }
    
    @Test
    public void evaluateTest() throws Exception {
        InfixExpression tester = new InfixExpression("3 + 3");
        
        assertEquals("3 + 3 = 6", 6, tester.evaluate());
        tester.setExpressionString("1+2*3");
        assertEquals("1+2*3 = 7", 7, tester.evaluate());
        tester.setExpressionString("2+2^2*3");
        assertEquals("2+2^2*3 = 14", 14, tester.evaluate());
        tester.setExpressionString("1==2");
        assertEquals("1==2 = 0", 0, tester.evaluate());
        tester.setExpressionString("1+3 > 2");
        assertEquals("1+3 > 2 = 1", 1, tester.evaluate());
        tester.setExpressionString("(4>=4) && 0");
        assertEquals("(4>=4) && 0 = 0", 0, tester.evaluate());
        tester.setExpressionString("(1+2)*3");
        assertEquals("(1+2)*3 = 9", 9, tester.evaluate());
        tester.setExpressionString("2%2+2^2-5*(3^2)");
        assertEquals("2%2+2^2-5*(3^2) = -41", -41, tester.evaluate());
        
        try {
            tester.setExpressionString("30 / ((6*6) - 36)");
            assertEquals("30 / ((6*6) - 36)", "Divide by zero error.", tester.evaluate());
        } catch(Exception e) {
            String msg = "Divide by zero error.";
            assertEquals("Should be divide by zero error message", msg, e.getMessage());
        }
        
        
        
        
        
        tester.setExpressionString("(3*4/16) + 204 - (16 ^ 5) * (203/4)");
        assertEquals("(3*4/16) + 204 - (16 ^ 5) * (203/4) = -52428596", -52428596, tester.evaluate());
    }
}
