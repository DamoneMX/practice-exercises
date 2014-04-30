/**
 *  A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below). 
 *  The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *  How many possible unique paths are there?
 *
 * Solution:
 *  Dynamic programming -> memorization: from [x],y how many ways do i have to get to [m][n]
 *  [6][3][1]
 *  [3][2][1]
 *  [1][1][1]
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
		int[][] matrix = new int[n + 2][m + 2];
		for(int i = 0; i < n + 2; i++){
			for(int j = 0; j < m + 2; j++){
				matrix[i][j] = -1;
			}
		}
		
        return uniquePaths(1,1, m, n, matrix);
    }
	
	public int uniquePaths(int x, int y, int xLimit, int yLimit, int[][] matrix) {
		if(x == xLimit && y == yLimit)
			return 1;
		
		if(x > xLimit || y > yLimit)
			return 0;
		
		
		if(matrix[y + 1][x] == -1)
			matrix[y + 1][x] = uniquePaths(x, y + 1, xLimit, yLimit, matrix);
		if(matrix[y][x + 1] == -1)
			matrix[y][x + 1] = uniquePaths(x + 1, y, xLimit, yLimit, matrix);
		
		return matrix[y + 1][x] + matrix[y][x + 1];
	}
}