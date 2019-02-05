# InfixExpressionEvaluator
CPT-287 Project #2 Creating a Infix expression evaluator.

James Bialon, Sean Stewart, Thomas Hopkins, Michael Steffens

# Contributing
* Make comments. The final project should be 20% comments as per instructor guidelines.
  * Comments describing a function/method should be done as follows: 
    ```java
    /**
     * This method preforms this function
     * @param parameter1 Type
     * @param parameter2 Type
     */
     public function() { } 
    ```
  * Other comments may be done inline if the function descriptor does not provide enough context
* Keep code as clean as possible 
  * Minimize messy whitespace
  

# Todo 
* Read infix expression(s) from input file
* Expression will be parsed and evaulated utilizing stacks
  * Parsing (Reading from input)
  * Use a stack (first in first out)
  * Evaluating
  * Return final answer to console
* Support expressions regardless of whitespace ( 1+2 vs 1 + 2)
* Support the following operators
  * ^, *, /, %, +, -, <, <=, >, >=, ==, !=, &&, ||
  * (See instructor guidelines for extra info)
* Efficent 
* Handle divide by zero errors
* Divisions should return an integer ( 1/2 returns 1 not 1.5 )
* Comparison operators return booleans in the form 0 or not zero 0
  * 0 = false
  * not 0 = true


