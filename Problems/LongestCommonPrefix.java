/**
 * Problem: 
 * Write a function to find the longest common prefix string amongst an array of strings. 
 * 
 *
 * Solution: All good, just unclear on complexity, make sure to analyze it. 
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        
        int shortest = 0;
        int shortestLength = Integer.MAX_VALUE;
        
        for(int i = 0; i < strs.length; i++){
            if(strs[i].length() < shortestLength){
                shortestLength = strs[i].length();
                shortest = i;
            }
        }
        
        String prefix = strs[shortest];
        prefix = prefix.toLowerCase();
        
        for(int i = 0; i < strs.length; i++){
            if(strs[i].toLowerCase().startsWith(prefix) == false){
                if(prefix.equals(""))
                        break;
                
                while(prefix.length() > 0){
                    int newLength = prefix.length() - 1;
                    if(newLength < 0)
                        newLength = 0;
                    
                    prefix = prefix.substring(0 , newLength);
                    
                    if(strs[i].toLowerCase().startsWith(prefix))
                        break;
                }
            }
        }
        
        return prefix;
    }

    //Version 2 - Oct 18, 2014
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < strs[0].length(); i++) {
            char currChar = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++) {
                String currString = strs[j];
                if(i >= currString.length()  || currString.charAt(i) != currChar){
                    return new String(buffer);
                }
            }
            
            buffer.append(currChar);
        }
        
        return new String(buffer);
    }

    public static void main(String[] args){
        String[] test = {"ca", "a"};
        System.out.println(longestCommonPrefix(test));
    }
}
