/**
 *  Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *  For "(()", the longest valid parentheses substring is "()", which has length = 2.
 *
 *  Solution: Record position of parentheses in stack.
 */
public class Solution{

    //Version 2 = DP Solution. November 2, 2014
    // longestValidParentheses(   ")((())()))"  )
    // Array: 0 - 8 - 6 - 2 - 0 - 0 - 2 - 0 - 0 - 0
    public static int longestValidParentheses(String s) {
        if(s.length() < 2) {
            return 0;
        }
        
        int[] memorization = new int[s.length()];
        int maxLength = 0;
        for(int i = s.length() - 2; i >= 0; i--) {
            if(s.charAt(i) == '(') {
                int checkIndex = i + 1 + memorization[i + 1];
                
                if(checkIndex < s.length() && s.charAt(checkIndex) == ')') {
                    memorization[i] = memorization[i + 1] + 2;
                    if(checkIndex + 1 < s.length())
                        memorization[i] += memorization[checkIndex + 1];
                }
            }
            
            maxLength = Math.max(maxLength, memorization[i]);
        }
       
        return maxLength;
    }

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