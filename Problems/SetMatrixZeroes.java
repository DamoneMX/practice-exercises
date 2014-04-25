/**
 *  Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place. 
 *
 * Solution:
 * Use first column and row to identify if either column or row should be set to zero
 */
public class SetMatrixZeroes{
    public void setZeroes(int[][] matrix) {
        boolean horizontal = false;
        boolean vertical   = false;
        
        for(int i = 0; i < matrix[0].length;i++){
            if(matrix[0][i] == 0)
                horizontal = true;
        }
        
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == 0)
                vertical = true;
        }
        
        //set zeros in first row and column to 0
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        //check first row
        for(int i = 1; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                for(int j = 1; j < matrix.length; j++){
                    matrix[j][i] = 0;
                }
            }
        }
        
        //check first column
        for(int i = 1; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                for(int j = 1; j < matrix[0].length; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(horizontal){
            for(int i = 0; i < matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }
        
        if(vertical){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        } 
    }
}