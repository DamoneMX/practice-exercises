/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // handle edge case
        if (num.length == 0 || target <= 0) return null;
        // sort the array
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        getResult(num, target, result, current, -1);
        return new ArrayList<List<Integer>>(new LinkedHashSet<List<Integer>>(result));
    }
    private void getResult(int[] num, int target, List<List<Integer>> result, List<Integer> current, int start) {
        if (target == 0) {
            List<Integer> tmp = new ArrayList<Integer>(current);
            result.add(tmp);
            return;
        } else {
            for (int i = start + 1; i < num.length; i++) {
                int offset = target - num[i];
                if(offset < 0) {
                    return;
                }
                current.add(num[i]);
                getResult(num, offset, result, current, i);
                current.remove(current.size()-1);
            }
        }
    }

    //Version 2 = Nov 8, 2014
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (candidates.length == 0) {
            return result;
        }
        
        Arrays.sort(candidates);
        
        for(int i = 0; i < candidates.length; i++) {
            if(candidates[i] > target)
                continue;
            
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            numbers.add(candidates[i]);
            
            findSum(i, target, candidates[i],  numbers, result, candidates);
        }
        
        return result;
    }
    
    public void findSum(int index, int target, int sum, ArrayList<Integer> numbers, ArrayList<ArrayList<Integer>> result, int[] candidates) {
        if(sum == target) {
           result.add(numbers);
           return;
        }
        
        for(int i = index; i < candidates.length; i++) {
            if(sum + candidates[i] > target) 
                break;
            
            ArrayList<Integer> copy = new ArrayList<Integer>();
            copy.addAll(numbers);
            copy.add(candidates[i]);
            findSum(i, target, sum + candidates[i], copy,  result, candidates);
        }
        
    }
}