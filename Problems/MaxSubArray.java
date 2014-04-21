/**
 *  Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *  For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 *  the contiguous subarray [4,−1,2,1] has the largest sum = 6. 
 *
 *
 * Solution:
 * This problem is not about finding all possible combinations in array, 
 * decide if previous sums increase your current number or not.
 */
public class Solution{

	public static void main(String[] args){
		int[] test = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(test));
	}
	
	public static int maxSubArray(int[] A) {
        if(A.length == 0) return 0;
        int[] sums = new int[A.length];
        int max = A[0];
        sums[0] = A[0];
        
        for(int i = 1; i < A.length; i++){
        	sums[i] = Math.max(A[i], sums[i - 1] + A[i]);
        	max = Math.max(sums[i], max);
        }
        
        return max;
    }
}