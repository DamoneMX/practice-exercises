/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Solution:
 * Very tricky, pointers keep track or where we will write a number.
 * 
 */
public class SortColors {
    public void sortColors(int[] A) {
        if(A.length == 0 || A.length == 1){
            return;
        }
        
        int Apos = 0;
        int Bpos = 0;
        int Cpos = 0;
        
        for(int i = 0; i < A.length; i++){
            if(A[i] == 0) {
                A[Cpos] = 2;
                A[Bpos] = 1;
                A[Apos] = 0;
                Apos++;
                Bpos++;
                Cpos++;
            } else if(A[i] == 1) {
                A[Cpos] = 2;
                A[Bpos] = 1;
                Bpos++;
                Cpos++;
            } else {
                A[Cpos] = 2;
                Cpos++;
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {0,1,2,0,1,2,0,1,2};
        sortColors(A);
        for(int i : A) {
            System.out.print(i + " - ");
        }
    }

}
