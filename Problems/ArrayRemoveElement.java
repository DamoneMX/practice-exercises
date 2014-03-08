/**
 * Given an array and a value, remove all instances of that value in place and return the new length. 
 * Order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * Solution: Invert the way you think of the solution. 
 * Instead of deleting when finding matching element, copy everytime we need to persist an element
 */
public class Solution {
    public int removeElement(int[] A, int elem) {
        int newLength = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] != elem)
                A[newLength++] = A[i];
        }

        return newLength;
    }
}
