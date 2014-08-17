/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 */
public class SearchRotatedSortedArray {


	//Follow up:
	//What if duplicates are allowed in array? is complexity affected?
    public boolean search(int[] A, int target) {
        for(int i = 0; i < A.length; i++) {
        	if(A[i] == target)
        		return true;
        }
        
        return false;
    }
}