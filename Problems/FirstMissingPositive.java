/**
 * Given an unsorted integer array, find the first missing positive integer. 
 * Given [1,2,0] return 3,
 * Given [3,4,-1,1] return 2.
 *
 * 
 * Solution:  Make sure this runs on O(n)
 * Medium difficulty problem, tricky.
 */
public class FirstMissingPositive{
    public int firstMissingPositive(int[] A){
        for(int i = 0; i < A.length; i++){
            if(A[i] == i + 1)
                continue;
            
            if(A[i] > A.length || A[i] <= 0){
                A[i] = -1;
                continue;
            }
            
            while(true){
                int current = A[i];
                if(current == A[current - 1]){
                    A[i] = -1;
                    break;
                }
                
                int temp = A[current -1];
                
                A[current - 1] = current;
                if(temp < 0)
                    A[i] = -1;
                else if(temp > A.length)
                    A[i] = -1;
                else
                    A[i] = temp;
                
                
                if(A[i] <= 0 || A[i] == i + 1)
                    break;
            }
        }
        
        for(int i = 0; i < A.length; i++){
            if(A[i] <= 0)
                return i + 1;
        }
        
        return A.length + 1;
    }
}