 /**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 */
public class DistinctSubsequences {

    public int numDistinct(String S, String T) {
        if(T.length() == 0 || S.length() == 0)
            return 0;
        
        int[][] matrix = new int[T.length()][S.length()];
        for(int x = 0; x < S.length(); x++) {
            if(S.charAt(x)  == T.charAt(0)) {
                if(x == 0) {
                    matrix[0][x] = 1;
                } else {
                    matrix[0][x] = matrix[0][x - 1] + 1;
                }
            } else {
                if(x == 0) {
                    matrix[0][x] =  0;
                } else {
                    matrix[0][x] = matrix[0][x - 1];
                }
            }
        }
    
        
        for(int y = 1; y < T.length(); y++) {
            for(int x = 1; x < S.length(); x++) {
                if(x < y )
                    continue;
                if(S.charAt(x)  == T.charAt(y)) {
                    int val = matrix[y - 1][x - 1] + matrix[y][x -1];
                    matrix[y][x] = val;
                } else {
                    matrix[y][x] = matrix[y][x - 1];
                }
            }
        }
  
        return matrix[T.length() - 1][S.length() - 1];
    }

}
