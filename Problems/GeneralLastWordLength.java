/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 *
 * Issues: too many edge cases, think about them more thoroughly
 */
public class Solution {

    public int lengthOfLastWord(String s) {
        if(s.length() == 0)
            return 0;
            
        char[] arr = s.toCharArray();
        int count = 0; int whitespace = 0;
        boolean foundLetter = false;
        for(int i = arr.length - 1; i >= 0; i--, count++) {
            if(arr[i] == ' '){
                if(foundLetter == false){
                    whitespace++;
                    continue;
                } else {
                    break;
                }
            } else {
                foundLetter = true;
            }
        }
        
        if(whitespace == arr.length)
            return 0;
        else{
            return (count - whitespace);
        }
    }
    
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
