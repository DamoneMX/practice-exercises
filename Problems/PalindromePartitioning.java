/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 */
public class PalindromePartitioning{
	public static ArrayList<ArrayList<String>> partition(String s){
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if(s.length() == 0)
			return result;
		
		ArrayList<String> partition = new ArrayList<String>();
		partition(s, partition,result);
		return result;
	}
	
	public static void partition(String remaining, ArrayList<String> partitions, ArrayList<ArrayList<String>> results){
		if(remaining.length() == 0){
			results.add(partitions);
			return;
		}
		
		for(int i = 1; i <= remaining.length(); i++){
			String sub = remaining.substring(0, i);
			if(!isPalindrome(sub))
				continue;
			
			ArrayList<String> newParts = new ArrayList<String>();
			newParts.addAll(partitions);
			newParts.add(sub);
			partition(remaining.substring(i , remaining.length()), newParts, results);
		}
			
	}
	
	public static boolean isPalindrome(String s){
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