/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 */
public class NQueens {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<String[]>();
        int[] board = new int[n];
        Arrays.fill(board, -1);
        solveQueens(0, board, result);
        
        return result;
    }
    
    public void solveQueens(int row, int[] board, ArrayList<String[]> result){
        if(row >= board.length){
            String[] s = new String[board.length];
            for(int i = 0; i < board.length; i++){
                String rowString = "";
                char[] rowChars = new char[board.length];
                Arrays.fill(rowChars, '.');
                rowChars[board[i]] = 'Q';
                s[i] = new String(rowChars);
            }
            
            result.add(s);
        }
        
        for(int i = 0; i < board.length; i++){
            if(board[i] >= 0)
                continue;
            
            boolean flag = false;
            for(int j = 0; j < board.length; j++)
                if(board[j] >= 0)
                    if(Math.abs(row - board[j]) == Math.abs(i - j))
                        flag = true;
            
            if(flag)
                continue;
            
            board[i] = row;
            solveQueens(row + 1, board, result);
            board[i] = -1;
        }
    }

    /*** 
     * Follow Up :
     * Now, instead outputting board configurations, return the total number of distinct solutions.
     ***/


    public int totalNQueens(int n) {
        int[] board = new int[n];
        Arrays.fill(board, -1);
        return solveQueens(0, board);
    }
    
    public int solveQueens(int row, int[] board){
        if(row >= board.length){
            return 1;
        }
        
        int count = 0;
        
        for(int i = 0; i < board.length; i++){
            if(board[i] >= 0)
                continue;
            
            
            boolean flag = false;
            for(int j = 0; j < board.length; j++)
                if(board[j] >= 0)
                    if(Math.abs(row - board[j]) == Math.abs(i - j))
                        flag = true;
            
            if(flag)
                continue;
            
            board[i] = row;
            count += solveQueens(row + 1, board);
            board[i] = -1;
        }
        
        return count;
    }
}
