import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Arrays;

public class Anagrams{
	
	public static ArrayList<String> anagrams(String[] strs) {
	
		HashMap<String, LinkedList<String>> register = new HashMap<String, LinkedList<String>>();
		ArrayList<String> foundAnagrams = new ArrayList<String>();
		
	
		for(int i = 0; i < strs.length; i++){
			String tempString = strs[i];
			char[] chars = tempString.toCharArray();
	        Arrays.sort(chars);
	        String sorted = new String(chars);
	        
	        if(!register.containsKey(sorted)){
	        	register.put(sorted, new LinkedList<String>());
	        }
	        
	        LinkedList<String> temp = register.get(sorted);
	        temp.add(tempString);
        }
		
		for(Map.Entry<String, LinkedList<String>> entry: register.entrySet()){
			LinkedList<String> temp = entry.getValue();
			if(temp.size() > 1){
				for (String s : temp) {
				    foundAnagrams.add(s);
				}
			}			
		}	
		
		return foundAnagrams;
			
	}
	
	
	public static void main(String[] args){
		String[] strs = new String[5];
		strs[0] = "test";
		strs[1] = "tste";
		strs[2] = "alces";
		strs[3] = "cabra";
		strs[4] = "braca";
		
		ArrayList<String> anagrams = anagrams(strs);
		for(String s : anagrams)
			System.out.println(s);
		
	}
	
}