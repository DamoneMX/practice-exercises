/*
 *
 * Maximum Product Subarray 
 * 
 */
public class MaximumProductSubarray {
    
    public static int maxProduct(int[] A) {
        if(A.length == 0)
            return 0;
        
        if(A.length == 1)
            return A[0];
        
        int max = Integer.MIN_VALUE;
        int n = A.length;
        int[][] matrix = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            matrix[i][i] = A[i];
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                matrix[i][j] = matrix[i][j - 1] * A[j];
                max = Math.max(max, matrix[i][j]);
            }
        }
        
        return max;
    }
}