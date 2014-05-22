/*
 *  
 */
public class UniquePermutations {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for(int i = 0; i < num.length; i++)
			numbers.add(num[i]);
		
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		permuteUnique(new ArrayList<Integer>(), numbers, results);
		
		return results;
		
    }
	
	public void permuteUnique(ArrayList<Integer> current, ArrayList<Integer> remaining, ArrayList<ArrayList<Integer>> results){
		if(remaining.size() == 0){
			results.add(current);
			return;
		}
		
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < remaining.size(); i++){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.addAll(remaining.subList(0, i));
			temp.addAll(remaining.subList(i + 1, remaining.size()));
			ArrayList<Integer> newArray = new ArrayList<Integer>();
			newArray.addAll(current);
			
			newArray.add(current.size(), remaining.get(i));
			if(!set.contains(remaining.get(i)) ){
				permuteUnique(newArray, temp, results);
				set.add(remaining.get(i));
			}
		}
		
	} 
}