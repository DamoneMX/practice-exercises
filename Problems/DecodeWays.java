/**
 * Problem: 
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 */
public class DecodeWays {

    //Version 2: Nov. 1, 2014
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        return countWays(s, map);
    }
    
    public int countWays(String s, HashMap<String, Integer> map) {
        if(s.length() == 0) {
            return 1;
        }
        
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            String str = s.substring(0, i + 1);
            if(Integer.parseInt(str) < 1 || Integer.parseInt(str) > 26 ) {
                break;
            }
             
            String substr = s.substring(i + 1, s.length());
            if(map.containsKey(substr)) {
                count += map.get(substr);
            } else {
                count += countWays(substr, map);
                map.put(substr, count);
            }
        }
        
        return count;
    }

    public static int numDecodings(String s){
        if(s.length() == 0 || s.length() == 1)
            return s.length();
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int paths = findPaths("", s, map);
        return paths;
    }
    
    public static int findPaths(String current, String remaining, HashMap<String, Integer> map){
        //System.out.println("curr: " + current + " rem:" + remaining + " ");
        if(remaining.length() == 0){
            //System.out.println("length is 1");
            return 1;
        }
        
        int count = 0;
        for(int i = 1; i < remaining.length() + 1; i++) {
            String s1 = current + remaining.substring(0 , i);
            
            if(Integer.parseInt(s1) > 26)
                break;
            
            String s2 = remaining.substring(i, remaining.length());
            //System.out.println(s1 + " " + s2 + " " + current + " " + remaining + " " + i);
            if(map.containsKey(s2)) {
                count += map.get(s2);
            } else {
                int paths = findPaths("", s2, map);
                map.put(s2, paths);
                count += paths;
            }
            
        }
        
        
        return count;
    }
}
