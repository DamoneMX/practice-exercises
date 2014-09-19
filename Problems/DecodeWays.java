/**
 * Problem: 
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 */
public class DecodeWays {
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
