package Expression;

import java.util.ArrayList;
import java.util.Iterator;



@SuppressWarnings("serial")
public class ExpressionList extends ArrayList<Expression>{
    
    /**
     * Iterates through all expressions in the list and outputs
     * the results to the console.
     */
    public void outputResults() {
        Iterator<Expression> it = iterator();
        Expression currentExpression;
        while(it.hasNext()) {
            currentExpression = it.next();
            System.out.printf("%s = %s \n", currentExpression.getExpressionString(), currentExpression.evaluate());
        }
    }
}
