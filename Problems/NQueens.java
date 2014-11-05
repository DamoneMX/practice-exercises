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


    //Version 2 = nov. 2 2014
    public static ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<String[]>();
        if(n == 0) {
            return result;
        }
        
        int[] positions = new int[n];
        for(int i = 0; i < positions.length; i++) {
            positions[0] = i;
            solveNQueens(1, positions, result);
        }
        
        return result;
    }
    
    public static void solveNQueens(int currentIndex, int[] positions, ArrayList<String[]> result){
        if(currentIndex == positions.length) {
            //create strings
            String[] arr = new String[positions.length];
            for(int i = 0; i < positions.length; i++) {
                int column = positions[i];
                StringBuffer buffer = new StringBuffer();
                for(int j = 0; j < positions.length; j++) {
                    if(j == column) {
                        buffer.append("Q");
                    } else {
                        buffer.append(".");
                    }
                }
                arr[i] = new String(buffer);
            }
            result.add(arr);
            
            return;
        }
        
        //i = column, j = row
        for(int i = 0; i < positions.length; i++) {
            boolean invalid = false;
            for(int j = 0; j < currentIndex; j++) {
                int column = positions[j];
                int dist = Math.abs(j - currentIndex);
                int dist1 = Math.abs(column - i);
                if(column == i || (dist == dist1 )) //find diagonal
                    invalid = true;
            }
            
            if(invalid == true) {
                continue;
            }
            
            int[] copy = new int[positions.length];
            for(int k = 0; k < positions.length; k++) {
                copy[k] = positions[k];
            }
            copy[currentIndex] = i;
            solveNQueens(currentIndex + 1, copy, result);
        }
    }
}
