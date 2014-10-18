/*
 *  Given a sorted array of integers, find the starting and ending position of a given target value.
 *  Your algorithm's runtime complexity must be in the order of O(log n).
 *  If the target is not found in the array, return [-1, -1].
 */
public class SearchForARange {

    //O(n) solution
    public int[] searchRange(int[] A, int target) {
        int[] result = {-1, -1};
        if(A.length == 0)
            return result;
        
        searchRange(A, 0, A.length - 1, target, result);    
            
        return result;
    }
    
    public void searchRange(int[] A, int start, int end, int target, int[] result){
        while(end >= start){
            int mid = (start + end) / 2;
            
            if(A[mid] == target) {
                result[0] = mid;
                result[1] = mid;
                
                int[] left = {-1, -1};
                searchRange(A, start, mid - 1, target, left);
                if(left[0] != -1)
                    result[0] = left[0];
                
                    
                int[] right = {-1, -1};
                searchRange(A, mid + 1, end, target, right);
                if(right[1] != -1)
                    result[1] = right[1];
                    
                return;
            } else if(target > A[mid]){
                start = mid + 1; 
            } else {
                end = mid - 1;
            }
        }
    }
    
}