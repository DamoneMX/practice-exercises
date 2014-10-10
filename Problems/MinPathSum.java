/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to 
 * bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0 && grid[0].length == 0)
            return 0;
            
        int[][] visited = new int[grid.length][grid[0].length];
        
        for(int x = grid[0].length - 1; x >= 0; x--) {
            for(int y = grid.length - 1; y >= 0; y--) {
                int right = getValue(x + 1, y, visited);
                int bottom = getValue(x, y + 1, visited);
                int min = 0;
                if(right == -1 && bottom == -1)
                    min = 0;
                else if(right == -1)
                    min = bottom;
                else if(bottom == -1) 
                    min = right;
                else
                    min = Math.min(right, bottom);
                    
                visited[y][x] = grid[y][x] + min;
            }
        }
        
        return visited[0][0];
    }
    
    public int getValue(int x, int y, int[][] grid){
        if(x == grid[0].length || y == grid.length)
            return -1;
            
        return grid[y][x];    
    }
}
