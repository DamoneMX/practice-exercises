/*
 * Given a set of distinct integers, S, return all possible subsets. 
 * This is a non-recursive solution, IMO more enjoyable.
 */

public class Subsets{
	public static ArrayList<ArrayList<Integer>> subsets(int[] s){
		Arrays.sort(s);
		
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		results.add(new ArrayList<Integer>());		
		
		for(int i = 0; i < s.length; i++){
			int item = s[i];
			ArrayList<ArrayList<Integer>> moreResults = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> result : results){
				ArrayList<Integer> newResult = new ArrayList<Integer>();
				newResult.addAll(result);
				newResult.add(item);
				moreResults.add(newResult);
			}
			
			results.addAll(moreResults);
		}
		
		return results;
	}

	//Version 2 -> Recursive
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>()); 
        if(S.length == 0)
            return result;
        
        Arrays.sort(S);
            
        for(int i = 0; i < S.length; i++) {
            ArrayList<Integer> set = new ArrayList<Integer>();
            set.add(S[i]);
            result.add(set);
            addSubsets(i + 1, set, S, result);   
        }
        
        return result;
    }
    
    public void addSubsets(int index, ArrayList<Integer> set, int[] S, ArrayList<ArrayList<Integer>> result){
        for(; index < S.length; index++) {
            ArrayList<Integer> copy = new ArrayList<Integer>();
            copy.addAll(set);
            copy.add(S[index]);
            result.add(copy);
            addSubsets(index + 1, copy, S, result);
        }
    }



	public static void main(String[] args){
		int[] input = {1,2,3};
		ArrayList<ArrayList<Integer>> result = subsets(input);
		
		for(ArrayList<Integer> r : result){
			System.out.println("");
			for(Integer entero : r)
				System.out.print(entero + ",");
		}
	}
}