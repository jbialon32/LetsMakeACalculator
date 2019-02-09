package Expression;

import java.util.ArrayList;
import java.util.Iterator;



@SuppressWarnings("serial")
public class ExpressionList extends ArrayList<InfixExpression>{
    
    /**
     * Iterates through all expressions in the list and outputs
     * the results to the console.
     * @throws Exception 
     */
    public void outputResults() throws Exception {
        Iterator<InfixExpression> it = iterator();
        InfixExpression currentExpression;
        while(it.hasNext()) {
            currentExpression = it.next();
            try {
                System.out.printf("%s = %s\n", currentExpression.getExpressionString(), currentExpression.evaluate());
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
