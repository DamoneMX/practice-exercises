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

	/**
	  *	Follow up:
	  *	Now consider if some obstacles are added to the grids. How many unique paths would there be?
	  *	An obstacle and empty space is marked as 1 and 0 respectively in the grid.
	**/


	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1)
            return 0;
            
		int rows = obstacleGrid.length;
		int columns = obstacleGrid[0].length;
        int[][] matrix = new int[rows + 1][columns + 1];
        for(int i = 0; i < (rows + 1); i++){
			for(int j = 0; j < (columns + 1); j++){
				if(i == rows || j == columns)
					matrix[i][j] = -1;
				else{
					if(obstacleGrid[i][j] == 1)
						matrix[i][j] = 0;
					else
						matrix[i][j] = -1;
				}
			}
		}
        
        return uniquePathsObstacles(0, 0,  columns - 1, rows - 1, matrix);
    }
	
	public int uniquePathsObstacles(int x, int y, int xLimit, int yLimit, int[][] matrix){
		if(x == xLimit && y == yLimit){
			if(matrix[y][x] == 0)
				return 0;
			else 
			    return 1;
		}
		
		if(x > xLimit || y > yLimit )
			return 0;
		
		if(matrix[y + 1][x] == -1)
			matrix[y + 1][x] = uniquePathsObstacles(x, y + 1, xLimit, yLimit, matrix);
		
		if(matrix[y][x + 1] == -1)
			matrix[y][x + 1] =  uniquePathsObstacles(x + 1, y, xLimit, yLimit, matrix);
		
		return matrix[y + 1][x] + matrix[y][x + 1];
	}

	public static void main(String[] args){

	}
}