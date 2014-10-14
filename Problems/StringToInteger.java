 /*
  * Implement atoi to convert a string to an integer.
  */
public class StringToInteger {
    public int atoi(String str) {
        if(str.length() == 0)
            return 0;
        
        str = str.trim();        
    
        int pos = 0;
        long val = 0L;
        char sign = '+';
        
        if(str.charAt(0) == '+' || str.charAt(0) == '-') {
            sign = str.charAt(0);
            pos++;
        }
        
        while(pos < str.length() && str.charAt(pos) >= '0' && str.charAt(pos) <= '9') {
            val = val * 10 + (str.charAt(pos) - '0');
            pos++;
        }
        
        if(sign == '-')
            val = -val;
        
        int res = 0;
        if(val > Integer.MAX_VALUE) 
            res = Integer.MAX_VALUE;
        else if(val < Integer.MIN_VALUE)
            res = Integer.MIN_VALUE;
        else 
            res = (int) val;
            
        return res;
    }

}
