/*
 *  Given a collection of numbers, return all possible permutations. 
 */
public class RecursionPermutations{

    public static void main(String[] args) {
    	Solution solution = new Solution();
    	int[] num = new int[3];
    	for(int i = 0; i < num.length; i++)
    		num[i] = i + 1;
    	ArrayList<ArrayList<Integer>> answer = solution.permute(num);
    	for(ArrayList<Integer> i : answer){
    		System.out.print(i);
    		System.out.println("");
    	}
    	
    }
    
    public static class Solution2{
    	public ArrayList<ArrayList<Integer>> permute(int[] num) {
	        ArrayList<Integer> numbers = new ArrayList<Integer>();
	        for(int i = 0; i < num.length; i++){
	        	numbers.add(num[i]);
	        }
	        
	        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
	        permute(new ArrayList<Integer>(), numbers, results, num.length);
	        return results;        
    	}
    	
    	public void permute(ArrayList<Integer> prefix, ArrayList<Integer> remaining, ArrayList<ArrayList<Integer>> results, int length){
    		if(prefix.size() == length){
    			results.add(prefix);
    			return;
    		}
    			
    		
    		for(int i = 0; i < remaining.size(); i++){
    			ArrayList<Integer> temp = new ArrayList<Integer>();
    			temp.addAll(remaining.subList(0, i));
    			temp.addAll(remaining.subList(i + 1, remaining.size()));
    			ArrayList<Integer> newArray = new ArrayList<Integer>();
    			newArray.addAll(prefix);
    			
    			newArray.add(prefix.size(), remaining.get(i));
    			
    			permute(newArray, temp, results, length);
    		}
    	}	
    }

}
