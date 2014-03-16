import java.io.*;
import java.util.*;
import java.
public class SentenceAnagrams {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string1 = br.readLine();
		String string2 = br.readLine();
		
    	Hashtable<Character, Integer> register1 = new Hashtable<Character, Integer>();
    	Hashtable<Character, Integer> register2 = new Hashtable<Character, Integer>();
    	
    	processString(string1, register1);
    	processString(string2, register2);
    	
    	if(register1.size() != register2.size()) System.out.println("Not anagrams!");
    	else{    		
    		for (Map.Entry entry : register1.entrySet()) {    			
    			Integer value1 = register1.get(entry.getKey());
    			Integer value2 = register2.get(entry.getKey());
    			if(value2 == null || value1 != value2)
    				System.out.println("Not anagrams!");
    		}
    		
    		System.out.println("Anagrams!");
    	}
    	
    	
    }
    
    publ
    
    public static void processString(String input, Hashtable<Character,Integer> register){
    	char[] stringArray = input.toCharArray();
    	
    	for(int i = 0; i < stringArray.length; i++){
    		if(register.get(stringArray[i]) == null)
    			register.put(stringArray[i], 1);
    		else
    			register.put(stringArray[i], register.get(stringArray[i]) + 1);
    	}
    }
}