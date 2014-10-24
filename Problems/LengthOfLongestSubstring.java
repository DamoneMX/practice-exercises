/**
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which 
 * the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LengthOfLongestSubstring {
	
	public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() == 1)
            return s.length();
        
    	//fix this part 
        HashMap<Character, Integer> map = new HashMap<Character,Integer>();
        
        int maxLength = 0;
        int startPoint = 0;
        for(int i = 0; i < s.length(); i++) {
        	if(map.get(s.charAt(i)) == null) {
        		map.put(s.charAt(i), i);
        		maxLength = Math.max(maxLength, (i + 1) - startPoint);
        	} else {
        		if(map.get(s.charAt(i)) + 1 > startPoint)
        			startPoint = map.get(s.charAt(i)) + 1;
        		maxLength = Math.max(maxLength, (i + 1) - startPoint);
        		map.put(s.charAt(i), i);
        	}
        }
        
        return maxLength;
    }
}