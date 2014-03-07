/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 *
 * Issues: too many edge cases, think about them more thoroughly
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        
        if(length == 0) return 0;
        
        while(length -1 > 0 && charArray[length - 1] == ' ') //on first try didn't think of this edge case
            length--;
        
        while(length - 1 >= 0 && charArray[length - 1] != ' '){ //probalme on char compare
            count++;
            length--;
        }
            
        return count;    
    }
}
