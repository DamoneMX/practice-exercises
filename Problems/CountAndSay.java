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

    //2nd version: Recursive
    public String countAndSay(int n) {
        if(n == 0)
            return "";
        ArrayList<String> counts = new ArrayList<String>();
        counts.add("1");
        for(int i = 2; i <= n; i++) {
            generateReads(i, counts);
        }
        
        return counts.get(n - 1);
    }
    
    public void generateReads(int current,  ArrayList<String> counts){
        String pastCount = counts.get(current - 2);    
        char[] charArr = pastCount.toCharArray();
        StringBuffer buffer = new StringBuffer();
        char lastSeenCharacter = 'a';
        int count = 0;
        
        for(int i = 0; i < charArr.length; i++) {
            if(lastSeenCharacter == 'a') {
                lastSeenCharacter = charArr[i];
                count = 1;
            } else if (lastSeenCharacter != charArr[i]) {
                //add to String
                buffer.append(count);
                buffer.append(lastSeenCharacter);
                lastSeenCharacter = charArr[i];
                count = 1;
            } else {
                count++;
            }
        }
        
        buffer.append(count);
        buffer.append(lastSeenCharacter);
        
        counts.add(new String(buffer));
    }

    public static void main(String[] args){
		System.out.println(countAndSay(6));
	}
    
}
