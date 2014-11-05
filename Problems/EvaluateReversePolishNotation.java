/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression
 * 
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 0)
            return 0;
        
        if(tokens.length == 1)
            return Integer.parseInt(tokens[0]);

        Stack<String> stack = new Stack<String>();
        int total = 0;
        int i = 0;
        while(i < tokens.length) {
            String elem = tokens[i++];
            if(elem.equals("+") || elem.equals("-") || elem.equals("*") || elem.equals("/")) {
                int value2 = Integer.parseInt(stack.pop());
                int value1 = Integer.parseInt(stack.pop());
                total = evaluate(value1, value2, elem);
                stack.push(Integer.toString(total));
                total = 0;
            } else {
                stack.push(elem);
            }     
        }
        
        total = Integer.parseInt(stack.pop());
        return total;
    }
    
    public int evaluate(int value1, int value2, String operator){
        int total = 0;
        switch(operator){
            case "+":  
                total = value1 + value2;
                break;
            case "-":  
                total = value1 - value2;
                break;
            case "*":  
                total = value1 * value2;
                break;
            case "/":  
                total = value1 / value2;
                break;
        }
        
        return total;
    }

    //Version 2
    public int evalRPN(String[] tokens) {
        if(tokens.length == 0) {
            return 0;
        }
        
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
            //check valid input
        }
        
        int total = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < tokens.length; i++) {
            String current = tokens[i];
            // +, -, *, /
            if(current.equals("+")||current.equals("-")||current.equals("*")||current.equals("/")){
                int num2 = stack.pop();
                int num1 = stack.pop();
                
                Integer result = 0;
                switch(current) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-": 
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                }
                
                stack.push(result);
                total = result;
            } else {
                stack.push(Integer.parseInt(current));
            }
        }
        
        return total;
    }
}
