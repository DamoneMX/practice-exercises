/**
 *  Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *  For "(()", the longest valid parentheses substring is "()", which has length = 2.
 *
 *  Solution: Record position of parentheses in stack.
 */
public class Solution{
    //improvement to this method: 
    //just use an int to record length of last longest string, no need for hashmap, but both work.
    public static int longestValidParentheses(String s) {
		if(s.length() == 0 || s.length() == 1)
			return 0;
		
		char[] chars = s.toCharArray();
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < s.length(); i++){
        	if(chars[i] == '('){
        		stack.push(i);
        	}
        	else{
        		if(stack.isEmpty())
        			continue;
        		else{
        			int pos = stack.pop();
        			int length = (i - pos) + 1;
        			int prev = pos -1 ;
        			int oldLength = 0;
        			if(prev >= 0){
        				if(map.containsKey(prev)){
        					oldLength = map.get(prev);
        					map.remove(prev);
        				}
        			}
        			
        			length += oldLength;
        			map.put(i, length);
        			if(length > max)
        				max = length;
        		}
        	}
        }
        
		return max;
    }
}