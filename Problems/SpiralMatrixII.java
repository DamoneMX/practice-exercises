/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Sol: Refactor code to make it more readable
 */
public class SpiralMatrixII {

    public static void main(String[] args){
        int[][] matrix = generateMatrix(10);
        for(int i = 0; i < matrix.length; i++){
            System.out.println("");
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + "- ");
            }
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if(n == 0)
            return matrix;
        
        int x = 0;
        int y = 0;
        int counter = 1;
        int direction = 0;
        
        for(; x < n; x++, counter++){
            matrix[y][x] = counter;
        }
        
        direction = 1;
        n = n - 1;
        x = x - 1;
        while(n > 0){
            int temp = n;
            for(; temp > 0; temp--){
                switch(direction){
                    case 0: 
                        x++;
                        break;
                    case 1: 
                        y++;
                        break;
                    case 2: 
                        x--;
                        break;
                    case 3: 
                        y--;
                        break;
                }
                
                matrix[y][x] = counter++;
            }
            
            
            
            if(direction == 0 || direction == 2){
                n = n - 1;
            }
            
            direction++;
            if(direction == 4)
                direction = 0;
        }
            
        
        return matrix;
    }
}
