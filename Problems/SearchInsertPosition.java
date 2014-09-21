/**
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        if(A.length == 0)
            return 0;
            
        int start = 0;
        int end = A.length - 1;
        int mid = (start + end) / 2;
        
        while(start <= end){ 
            if(A[mid] == target){
                return mid;
            } else if(target < A[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }
        
        if(start > end) 
            return start;
        else 
            return end;
    }
}
