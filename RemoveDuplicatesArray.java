/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory. 
 *
 *
 * Before Start: Do we need to set remaining elements to 0?? 
 */
public class Solution {
    public int removeDuplicates(int[] A) {
        int removedItems = 0;
        for(int i = A.length - 1; i >= 1; i--){
            if(A[i] == A[i - 1]){
                int j = i + 1;
                while(j < A.length - removedItems)
                    A[j - 1] = A[j++];
                
                removedItems++;
                //1st version was lazy, looped through all elements to assign to 0
                A[A.length - removedItems] = 0; 
            }
        }
        
        return A.length - removedItems;
    }

	/*
	 * Second solution:
	 * This is assuming we don't care about setting elements to zero the elements that were removed
	 int count = 0;
	     int len = A.length;
	     for (int i = 0; i < len; i++) {
	 	if (count == 0 || A[i] != A[count - 1]) {
	 	    A[count++] = A[i];
	 	}
	     }
	 return count;
	*/

}
