/**
 * Problem: 
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
 * 
 */
public class Solution {
    //Keys to solution: 
    //B will always be bigger than A
    //No need for array copy to be in parallel, the way we copy from B and A can be independent:
    //currentA-- can change at a different rate than currentB--
    //Less than O(N) as once B finishes it's done
    public void merge(int A[], int m, int B[], int n) {
        int insertionLocation = A.length - 1; //initially forgot this
        int currentA = m - 1;
        int currentB = n - 1;
       
            while(currentB >= 0){
                if(currentA < 0) //didnt think of this case before first submission, forgot edge case when A was empty
                    A[insertionLocation--] = B[currentB--];
                else if(B[currentB] > A[currentA])
                    A[insertionLocation--] = B[currentB--];
                else
                    A[insertionLocation--] = A[currentA--];
            }
        
    }
}
