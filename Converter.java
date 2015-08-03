import data_structures.*;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Converter {
    private Stack<String> stack = new Stack<String>();
    private Queue<String> queue = new Queue<String>();
    private String currentToken;

    public Converter() {

        runTests();
    }

    private void runTests() {
        String stringExpression = "  4 + - 7 ";
        String leftParenthesis = "(";
        String rightParenthesis = ")";
        //Code to validate input
        //1 - Check for matching parenthesis
        Stack<Character> buffer = new Stack<>();
        for (char c: stringExpression.toCharArray()) {
            if (leftParenthesis.indexOf(c) != -1)       //found left parenthesis, push onto stack
                buffer.push(c);
            else if (rightParenthesis.indexOf(c) != -1) {//found right parenthesis
                if (buffer.isEmpty())
                    System.out.println("FALSE");        //return false
                if (rightParenthesis.indexOf(c) != leftParenthesis.indexOf(buffer.pop()))
                    System.out.println("FALSE..mismatched parenthesis");
            }
        }
        if (buffer.isEmpty())
            System.out.println("If no errors, your parenthesis are ok");
        else
            System.out.println("Error!");

        //Check if there are two operators side by side
        String expressionWithoutSpaces = stringExpression.replaceAll("\\s","");//remove spaces

        for (int i=0, n = expressionWithoutSpaces.length(); i < n; i++) {
            System.out.println(expressionWithoutSpaces.charAt(i));
        }

        for (int i=0, n = stringExpression.length(); i < n; i+=1) {
//            System.out.println(stringExpression.charAt(i));
            if (isOperator(stringExpression.charAt(i)) && isOperator(stringExpression.charAt(i+1))) {
                System.out.println("There are two operators side by side!!!");
            }
        }

        //Check if there is an operator followed by closing parenthesis
        for (int i=0, n = expressionWithoutSpaces.length(); i < n; i++) {
            if (isOperator(expressionWithoutSpaces.charAt(i)) && (Character.toString(expressionWithoutSpaces.charAt(i+1)).equals(rightParenthesis))) {
                System.out.println("There is an operator followed by right parenthesis!!!");
            }
        }

//        System.out.println(!Character.toString(expressionWithoutSpaces.charAt(0)).matches("\\d"));
//        System.out.println(!Character.toString(expressionWithoutSpaces.charAt(0)).equals(")"));
//        //Check to see if there is a Unary Operator
        if (isOperator(expressionWithoutSpaces.charAt(0)))
            System.out.println("Unary Operator Error in first spot!");
        for (int i = expressionWithoutSpaces.length()-1; i >0; i--) {
            if (isOperator(expressionWithoutSpaces.charAt(i))) {
                if (Character.toString(expressionWithoutSpaces.charAt(i - 1)).matches("\\d"))
                    continue;
                else if (Character.toString(expressionWithoutSpaces.charAt(i - 1)).equals(")"))
                    continue;
                else
                    System.out.println("Unary Operator Error inside");
            }
        }
        System.out.println("No Unary Operators");

        StringTokenizer st = new StringTokenizer(stringExpression);

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
                while(!stack.isEmpty() && !stack.peek().equals("(") && topOfStackOperatorHasHigherPrecedence(currentToken,stack.peek())) {
                    queue.enqueue(stack.pop());
                }
                stack.push(currentToken);
            }

            else if(currentToken.matches("\\d+"))
                queue.enqueue(currentToken);
            else
                throw new RuntimeException("Unidentified token");

        }

        while (!stack.isEmpty())
            queue.enqueue(stack.pop());

        System.out.print("+ is located at index: ");
        System.out.println(stringExpression.indexOf("+"));

//        System.out.println("The stack currently holds");
//        while (!stack.isEmpty())
//            System.out.println(stack.pop());
//
//        System.out.println("The queue currently holds");
//        while (!queue.isEmpty())
//            System.out.println(queue.dequeue());

       // Now we evaluate the postfix expression
        double currentResult;
        while (!queue.isEmpty()) {
            currentToken = queue.peek();
            if (currentToken.matches("\\d+"))
                stack.push(queue.dequeue());
            else if (isOperator(currentToken)) {
                currentResult = performOperation(queue.dequeue());
                System.out.println("The current Result is: " +currentResult);
                stack.push(Double.toString(currentResult));
            }
        }
        System.out.println("The answer is: " +stack.pop());
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
            case "^": return Math.pow(numberFromStack2, numberFromStack1);
            default: throw new RuntimeException("Unexpected error");
        }
    }

    private boolean topOfStackOperatorHasHigherPrecedence(String current, String topOfStack) {

        if (topOfStack.equals("^"))
            return true;
        else if ((topOfStack.equals("*") || topOfStack.equals("/")) && current.equals("+") || current.equals("-"))
            return true;
        else if (current.equals("+") || current.equals("-"))
            return true;
        else
            return false;

    }

    private boolean isOperator(String s) {
        if(s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-") || s.equals("^"))
            return true;
        return false;

    }

    private boolean isOperator(Character c) {
        if(c.equals('*') || c.equals('/') || c.equals('+') || c.equals('-') || c.equals('^'))
            return true;
        return false;
    }

    public static void main(String [] args) {
        try {
            new Converter();
        }
        catch(Exception e) {
            System.out.println("ERROR: " + e);
            e.printStackTrace();
        }
    }


}