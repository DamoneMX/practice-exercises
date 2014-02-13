/**
 * Problem: 
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Must have O(n) complexity
 * 
 */
public class Solution {
    public int singleNumber(int[] A) {
        Map<Integer, Integer> keeper = new HashMap<Integer, Integer>();
        for(int i = 0; i < A.length; i++){
            if(keeper.get(A[i]) == null)
                keeper.put(A[i], 1);
            else
                keeper.put(A[i], 2);
        }
        
        int value = -1;
        for(Map.Entry<Integer, Integer> entry: keeper.entrySet()){
            if(entry.getValue() == 1)
                value = entry.getKey();
        }
        
        return value;
    }
}
