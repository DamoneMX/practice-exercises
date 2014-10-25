import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Arrays;

public class Anagrams{
	
	//Sort = O(k log k), k = chars in string
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
	
	//Version 2: October 25, 2014. 15 minutes
	//O(n) solution
	//Tradeoff = O(n) space
	public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> result = new ArrayList<String>();
        if(strs.length == 0 || strs.length == 1)
            return result;
        
        HashMap<HashMap<Character, Integer>, Integer> map = new HashMap<HashMap<Character, Integer>, Integer>();
        HashSet<String> set = new HashSet<String>();
        for(int i = 0; i < strs.length; i++) {
            String s = strs[i];
            HashMap<Character, Integer> count = generateMap(s);
            if(map.get(count) == null) {
                map.put(count, i);
            } else {
                String original = strs[map.get(count)];
                if(set.contains(original) == false) {
                    result.add(original);
                    set.add(original);
                };
                
                result.add(s);
                set.add(s);
            }
        }
        
        return result;
    }
    
    public HashMap<Character, Integer> generateMap(String s){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        if(s.length() == 0) {
            return map;
        }
        
        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) != null) {
                map.put(s.charAt(i), (map.get(s.charAt(i))) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        } 
        
        return map;
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