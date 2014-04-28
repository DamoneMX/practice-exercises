/**
 *  Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *  The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 * Solution:
 * Medium difficulty
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if(s.length() == 0)
            return true;
        
        if(s.length() % 2 != 0)
            return false;
        
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < charArray.length;i++){
            if(charArray[i] == '(' || charArray[i] == '{' || charArray[i] == '[')
                stack.push(charArray[i]);
            else{
                if(stack.isEmpty())
                    return false;
                
                char last = stack.pop();
                if(charArray[i] == ')')
                    if(last != '(')
                        return false;
                if(charArray[i] == '}')
                    if(last != '{')
                        return false;
                if(charArray[i] == ']')
                    if(last != '[')
                        return false;
                
            }
        }
        
        if(!stack.isEmpty())
            return false;
        
        return true;
    }
}