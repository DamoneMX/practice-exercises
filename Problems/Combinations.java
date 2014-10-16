/**
 *  Given two integers n and k, return all possible combinations of k numbers out of 1 ... n. 
 *
 *
 * Solution:
 * 
 */
public class Combinations {

	//2nd version, a little bit cleaner
	public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(n == 0 || k == 0)
            return results;
            
        for(int i = 1; i <= n; i++) {
        	ArrayList<Integer> current = new ArrayList<Integer>();
            current.add(i);
            findCombinations(i + 1, n, k, current, results);
        }
        
        return results;
    }
    
    public static void findCombinations(int current, int n, int k, ArrayList<Integer> result, ArrayList<ArrayList<Integer>> results){
        if(result.size() == k) {

            results.add(result);
            return;
        }
        
        for(int i = current; i <= n; i++) {
            ArrayList<Integer> copy = new ArrayList<Integer>();
            copy.addAll(result);
            copy.add(i);
            findCombinations(i + 1, n, k, copy, results);
        }  
    }

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		if(k > n)
			return new ArrayList<ArrayList<Integer>>();
		
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        int[] availableNumbers = new int[n];
        for(int i = 1; i <= n; i++){
        	availableNumbers[i - 1] = i;
        }
        
        combine(new ArrayList<Integer>(), availableNumbers, k, results);
        
        return results;
    }
	
	public void combine(ArrayList<Integer> current, int[] remainingNumbers, int length ,ArrayList<ArrayList<Integer>> results){
		if(current.size() == length){
			results.add(current);
			return;
		}
		
		for(int i = 0; i < remainingNumbers.length; i++){
			int[] newSet =  Arrays.copyOfRange(remainingNumbers, i + 1, remainingNumbers.length);
			
			ArrayList<Integer> set = new ArrayList<Integer>();
			set.addAll(current);	
			set.add(remainingNumbers[i]);
			combine(set, newSet, length, results);
		}
		
	}

	public static void main(String[] args){
		ArrayList<ArrayList<Integer>> results = combine(4 , 2);
		for(ArrayList<Integer> number : results){
			System.out.println("");
			for(Integer num : number){
				System.out.print(num + " - ");
			}
		}
	}
}