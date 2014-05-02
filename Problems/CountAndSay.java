 /**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 */
public class CountAndSay {
    public static String countAndSay(int n) {
        if(n == 0)
        	return "";
        if(n == 1)
        	return "1";
        
        String number = countAndSay(n - 1);
        char[] charArray = number.toCharArray();
        
        String result = "";
        int count = 1;
        char current = charArray[0];
        for(int i = 1; i < charArray.length; i++){
        	if(charArray[i] == current)
        		count++;
        	else{
        		result = result + count + current;
        		count = 1;
        		current = charArray[i];
        	}
        }

        result = result + count + current;
        return result;
    }

    public static void main(String[] args){
		System.out.println(countAndSay(6));
	}
    
}
