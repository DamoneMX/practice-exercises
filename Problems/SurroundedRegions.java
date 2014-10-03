/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        return convertToBST(num, 0, num.length - 1);
    }

    //BFS solution, DFS solution is very similar. Use recursion
    // Recursion - Space tradeoff
    public void solve(char[][] board) {
        if(board.length == 0 || board.length == 1)
            return;
        
        if(board[0].length == 0 || board[0].length == 1)
            return;
        
        int rows = board.length;
        int cols = board[0].length;
        
        for(int i = 0; i < rows; i++){
            bfs(board, i, 0);
            bfs(board, i, cols - 1);
        }
        
        for(int i = 1; i < cols - 1; i++) {
            bfs(board, 0, i);
            bfs(board, rows - 1, i);
        }
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                
                if(board[i][j] == 'X')
                    board[i][j] = 'O';
            }
        }
    }
    
    public void bfs(char[][] board, int y, int x){
        Queue<Integer[]> queue = new LinkedList<Integer[]>();
        if(board[y][x] == 'O')
            queue.add(new Integer[]{y,x});
        
        while(!queue.isEmpty()){
            Integer[] curr = queue.poll();
            int yCurr = curr[0];
            int xCurr = curr[1];
            board[yCurr][xCurr] = '+';
            if(xCurr - 1 >= 0 && board[yCurr][xCurr - 1] == 'O')
                queue.add(new Integer[]{y,x-1});
            if(xCurr + 1 < board[0].length && board[yCurr][xCurr + 1] == 'O')
                queue.add(new Integer[]{y,x + 1});
            if(yCurr - 1 >= 0 && board[yCurr - 1][xCurr] == 'O')
                queue.add(new Integer[]{y - 1,x});
            if(yCurr + 1 < board.length && board[yCurr + 1][xCurr] == 'O')
                queue.add(new Integer[]{y + 1,x});  
        }
        
    }
    
    //Works but times out
    public static void solve(char[][] board) {
        if(board.length == 0 || board.length == 1)
            return;
        
        if(board[0].length == 0 || board[0].length == 1)
            return;
        
        int[][] copy = new int[board.length][board[0].length];
        int paths = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board[0].length; j++) {
                if(copy[i][j] > 0 || board[i][j] == 'X') {
                    continue;
                }
                
                //check element on top
                if(i - 1 >= 0 && copy[i - 1][j] != 0) {
                    copy[i][j] = copy[i - 1][j];
                }
                
                if(j - 1 >= 0 && copy[i][j - 1] != 0){  //check element to the left
                    if(copy[i][j] != 0 && copy[i][j] != copy[i][j - 1]) { //unite paths
                        if(map.get(copy[i][j - 1]) == -1){
                            map.put(copy[i][j], -1);
                            map.put(copy[i][j - 1], copy[i][j]);
                        } else {
                            map.put(copy[i][j - 1], copy[i][j]);
                        }
                    } else {
                        copy[i][j] = copy[i][j - 1];
                    }
                }
                
                if(copy[i][j] == 0){
                    paths++;
                    copy[i][j] = paths;
                }
                
                if(i - 1 < 0 || i + 1 >= board.length || j - 1 < 0 || j + 1 >= board[0].length) {
                    map.put(copy[i][j], -1);  //-> should we loop? and find references and set last ref to -1?
                } else if(map.get(paths) == null){
                    map.put(paths, copy[i][j]);
                }
            }
        }
        
        for(int i = 1; i <= paths; i++){
            int path = i;
            int reference = map.get(path);
            while(reference != -1 && reference != map.get(reference)){

                reference = map.get(reference);
            }
            
            if(reference == -1)
                map.put(path, -1);
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(copy[i][j] == 0) 
                    continue;
                
                int path = copy[i][j];
                int reference = map.get(path);

                while(reference != -1 && reference != map.get(reference)){
                    reference = map.get(reference);
                }
                
                if(reference == -1)
                    continue;
                
                board[i][j] = 'X';
            }
        }
        
    }
}
