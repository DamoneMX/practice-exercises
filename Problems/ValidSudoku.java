/**
 *  Determine if a Sudoku is valid
 *  The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Solution:
 * Tricky for's just don't be lazy, and use a HashSet, keep comparisons to O(n) N being the number of chars in board
 */
public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board){
        HashSet<Character> register = new HashSet<Character>();
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == '.')
                    continue;
                
                if(register.contains(board[i][j]))
                    return false;
                else
                    register.add(board[i][j]);
            }
            register = new HashSet<Character>();
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[j][i] == '.')
                    continue;
                
                if(register.contains(board[j][i]))
                    return false;
                else
                    register.add(board[j][i]);
            }
            register = new HashSet<Character>();
        }
        
        System.out.println("here");
        for(int i = 0; i < 7; i = i + 3){
            for(int j = 0; j < 7; j = j + 3){
                for(int k = i; k < i + 3; k++){
                    for(int l = j; l < j + 3; l++){
                        if(board[k][l] == '.')
                            continue;
                        
                        if(register.contains(board[k][l]))
                            return false;
                        else
                            register.add(board[k][l]);
                    }
                }
                register = new HashSet<Character>();
            }
        }
        
        return true;
    }
}