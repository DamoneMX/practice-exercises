/**
 * Implement strStr().
 * Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
 * Example: 
 * "My House is small" , "House" => House is small
 * 
 * Solution: O(mn) Solution
 * Sliding window solution
 * Loop through array make sure you don't go out of bounds
 * More efficient solutions but with more advanced algorithms
 */
public class RestoreIP {

    public static void main(String[] args){
		System.out.println(strStr("My House is small", "House"));
		System.out.println(strStr("a", "a"));
	}
	
	public static String strStr(String haystack, String needle) {
		if(needle.length() > haystack.length())
			return null;
		
		if(needle.length() == 0)
			return haystack;
		
		boolean found = false;
		
		for(int i = 0; i <= haystack.length() - needle.length(); i++) {
			if(haystack.charAt(i) == needle.charAt(0)) {
				found = checkWindow(i, needle, haystack);
			}  
			
			if(found == true)
				return haystack.substring(i, haystack.length());
		}
		
		return null;
    }
	
	public static boolean checkWindow(int index, String needle, String haystack){
		int length = needle.length();
		for(int i = 0; i < length; i++) {
			if(needle.charAt(i) != haystack.charAt(i + index))
				return false;
		}
		return true;
	}

}
