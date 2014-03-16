//TODO: REPEAT THIS!

public class Solution {
    public String reverseWords(String s) {
        if(s.isEmpty() || s.length() == 0)   return s;
         
        StringBuffer res = new StringBuffer();
         
        int t, h;
        for(int i = s.length() - 1; i >= 0; i--) {
            while(i >= 0 && s.charAt(i) == ' ') i--;
             
            // set tail pointer
            if(i < 0) break;
            t = i;
            h = t;
             
            // set head pointer
            while(i >= 0 && s.charAt(i) != ' ') { h = i; i--; }
             
            // append this word (append a space if find more than two words)
            if(h <= t && res.length() > 0) res.append(' ');
            for(int j = h; j <= t; j++) {
                res.append(s.charAt(j));
            }
        }
         
        return res.toString();
    }
}