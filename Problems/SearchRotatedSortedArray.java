/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * Reminder: 
 * This is NOT a Binary Search problem, 
 * It's a Divide and Conquer problem
 */
public class SearchRotatedSortedArray {


    public int search(int[] A, int target) {
        if(A.length == 0)
            return -1;
            
        int start = 0;
        int end   = A.length - 1;
        
        while(end >= start){
            int mid = (start + end) / 2;
            if(A[mid] == target)
                return mid;
                
            if(A[start] <= A[mid]) { //this means that left side of array is ordered
                if(target >= A[start] && target < A[mid])
                    end = mid - 1;
                else 
                    start = mid + 1;
            } else { //this means that right side is the ordered side
                if(target > A[mid] && target <= A[end])
                    start = mid + 1;
                else 
                    end = mid - 1;
            }
        }
        
        return -1;
        
    }



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