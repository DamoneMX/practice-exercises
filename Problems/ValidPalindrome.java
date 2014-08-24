/**
 *  Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *  Example:
 *  "A man, a plan, a canal: Panama" is a palindrome.
 *
 *  Complexity??????
 */
public class ValidPalindrome {

    public static void main(String[] args){
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {
        if(s.length() == 0 || s.length() == 1)
            return true;
        s = s.replaceAll("[\\W|\\s]", "");
        s = s.toLowerCase();
        
        int lo = 0;
        int hi = s.length() - 1;
            
        while(lo < hi){
            if(s.charAt(lo) != s.charAt(hi))
                return false;
            lo++;
            hi--;
        }
        
        return true;
    }
}