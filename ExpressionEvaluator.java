/*  Guillermo Alvarez
    masc0863
*/

import data_structures.*;
import java.util.StringTokenizer;


public class ExpressionEvaluator {
    private Stack<String> stack = new Stack<String>();
    private Queue<String> queue = new Queue<String>();
    private String answer;

    public String processInput(String s) {

        //Validate input
        String[] tokenArray = s.split("\\s+");

        //Make sure there is something entered
        if (tokenArray.length == 0)
            return " ";

        //1 - Check for matching parenthesis
        if (!isMatched(s))
            return "ERROR";

        //2 - Check to see if expression has Unary Operator
        if (expressionHasUnaryOperator(tokenArray))
            return "ERROR";

        //3 - Check to see if expression ends with operator or decimal
        if (expressionEndsWithOperator(tokenArray))
            return "ERROR";

        //4 - Check to see if there is an operator followed by a parenthesis
        if (expressionHasOperatorFollowedByRightParenthesis(tokenArray))
            return "ERROR";

        //5 - Check to see if a left parenthesis is preceded by operator
        if (!LeftParenthesisArePrecededByOperator(tokenArray))
            return "ERROR";

        //6 - Check to see if there is division by zero
//        if (divisionByZero(tokenArray))
//            return "Infinity";

        //If no errors, continue with conversion algorithm
        //Switched it up to StringTokenizer just for fun...
        StringTokenizer st = new StringTokenizer(s);

        //Convert from infix to postfix
        String currentToken;
        while (st.hasMoreTokens()) {
            currentToken = st.nextToken();
            if (currentToken.equals("("))
                stack.push(currentToken);
            else if (currentToken.equals(")")) {
                while (!stack.peek().equals("("))
                    queue.enqueue(stack.pop());
                stack.pop();
            }
            else if (isOperator(currentToken)) {
                while(!stack.isEmpty() &&
                        !stack.peek().equals("(") &&
                        topOfStackOperatorHasHigherPrecedence(currentToken,stack.peek())) {
                    queue.enqueue(stack.pop());
                }
                stack.push(currentToken);
            }
            else if(isNumeric(currentToken))             //checks if token is a number
                queue.enqueue(currentToken);
            else
                throw new RuntimeException("Unidentified token");
        }

        while (!stack.isEmpty())
            queue.enqueue(stack.pop());
        //Conversion to postfix is complete

        // Now we evaluate the postfix expression
        double currentResult;
        while (!queue.isEmpty()) {
            currentToken = queue.peek();
            if (isNumeric(currentToken))              //checks if token is a number
                stack.push(queue.dequeue());
            else if (isOperator(currentToken)) {
                currentResult = performOperation(queue.dequeue());
                stack.push(Double.toString(currentResult));
            }
        }
        answer = stack.pop();
        queue.makeEmpty();
        stack.makeEmpty();
        return answer;
    }



    private double performOperation(String currentToken) {
        Double numberFromStack1, numberFromStack2;
        numberFromStack1 = Double.parseDouble(stack.pop());
        numberFromStack2 = Double.parseDouble(stack.pop());

        switch(currentToken) {
            case "+": return numberFromStack2 + numberFromStack1;
            case "-": return numberFromStack2 - numberFromStack1;
            case "*": return numberFromStack2 * numberFromStack1;
            case "/": return numberFromStack2 / numberFromStack1;
            case "^": return Math.pow(numberFromStack2,numberFromStack1);
            default: throw new RuntimeException("Unexpected error");
        }
    }

    private boolean topOfStackOperatorHasHigherPrecedence(String current, String topOfStack) {

        if (topOfStack.equals("^"))
            return true;
        else if ((topOfStack.equals("*") || topOfStack.equals("/")) &&
                (current.equals("+") || current.equals("-")))
            return true;
        else if (current.equals("+") || current.equals("-"))
            return true;
        else
            return false;
    }

    private boolean isNumeric(String s) {
        try
        {
            Double.parseDouble(s);
        }
        catch(NumberFormatException e)
        {
            return false;
        }
        return true;
    }

    private boolean isOperator(String s) {

        return s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-") || s.equals("^");
    }

    private boolean isOperator(Character c) {

        return c.equals('*') || c.equals('/') || c.equals('+') || c.equals('-') || c.equals('^');
    }

    private boolean isMatched(String str) {
        Stack<Character> buffer = new Stack<>();

        for (char c: str.toCharArray()) {
            if ("(".indexOf(c) != -1)       //found left parenthesis, push onto stack
                buffer.push(c);
            else if (")".indexOf(c) != -1) {   //found right parenthesis, look for match
                if (buffer.isEmpty())
                    return false;
                if (")".indexOf(c) != "(".indexOf(buffer.pop()))
                    return false;
            }
        }
        return buffer.isEmpty();
    }

    private boolean divisionByZero(String[] tokenArray) {
        for (int i = tokenArray.length-2; i>0; i--)
            if(tokenArray[i].equals("/") && tokenArray[i+1].equals("0"))
                return true;
        return false;
    }

    private boolean expressionEndsWithOperator(String[] tokenArray) {

        int last = tokenArray.length-1;
        if (isOperator(tokenArray[last])) //ends with operator
            return true;
        else //ends with operator followed by decimal
            return (tokenArray[last]).equals(".") && isOperator(tokenArray[last-1]);
    }

    private boolean expressionHasOperatorFollowedByRightParenthesis(String str) {

        for (int i=0, n = str.length()-1; i < n; i++) {
            if (isOperator(str.charAt(i)) && (Character.toString(str.charAt(i+1)).equals(")")))
                return true;
        }
        return false;
    }

    private boolean expressionHasOperatorFollowedByRightParenthesis(String[] tokenArray) {

        for (int i=0, n = tokenArray.length-1; i < n; i++) {
            if (isOperator(tokenArray[i]) && (tokenArray[i+1].equals(")"))) {
                return true;
            }
        }
        return false;
    }

    private boolean expressionHasUnaryOperator(String[] tokenArray) {

        for (int i = tokenArray.length-1; i >0; i--) {
            if (isOperator(tokenArray[i]) && !isNumeric(tokenArray[i-1]) && !tokenArray[i-1].equals(")"))
                return true;
        }

        return false;
    }

    private boolean LeftParenthesisArePrecededByOperator(String[] tokenArray) {

        for (int i = 1; i < tokenArray.length; i++) {
            if (tokenArray[i].equals("(") && !isOperator(tokenArray[i - 1]))
                return false;
        }
        return true;
    }
}