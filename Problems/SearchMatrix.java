/*
 *  Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *  - Integers in each row are sorted from left to right.
 *  - The first integer of each row is greater than the last integer of the previous row
 *
 *  Solution: low difficulty, good question to review binary search
 */
public class SearchMatrix {

    public static void main(String[] args){
        int[] row1 = {1,3,5};
        int[] row2 = {4,5,6};
        int[] row3 = {7,8,9};
        int[][] matrix = new int[3][3];
        matrix[0] = row1;
        matrix[1] = row2;
        matrix[2] = row3;
        
        System.out.println(searchMatrix(matrix, 4));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int rows = matrix.length; 
        
        for(int i = 0; i < rows; i++){
            if(target >= matrix[i][0])
                row = i;
        }
        
        if(row == rows - 1)
            if(target > matrix[row][matrix[row].length - 1])
                return false;
        
        //Execute binary search
        int[] array = matrix[row];
        int low = 0;
        int hi = array.length - 1;
        while(low <= hi){
            int mid = low + (hi - low) / 2;
            if(target < array[mid])
                hi = mid - 1;
            else if(target > array[mid]){
                low = mid + 1;
            }
            else
                return true;
        
        }
        
        return false;
    }
}