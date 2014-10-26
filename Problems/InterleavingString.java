/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * Example: 
 * s1 = "aabcc", s2 = "dbbca",
 * When s3 = "aadbbcbcac", return true.
 */
public class WordLadder {
    
    /**
     * DP Solution, a bit different from other string matrix problems
     */
    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() == 0 && s2.equals(s3))
            return true;
        
        if(s2.length() == 0 && s1.equals(s3)) 
            return true;
        
        if(s3.length() != (s1.length() + s2.length()))
            return false;
        
        boolean[][] matrix = new boolean[s1.length() + 1][s2.length() + 1];
        
        for(int i = 1; i < s1.length() + 1; i++) {
            if(s3.charAt(i - 1) == s1.charAt(i - 1))
                matrix[i][0] = true;
        }
        
        for(int j = 1; j < s2.length() + 1; j++) {
            if(s3.charAt(j - 1) == s2.charAt(j - 1)) 
                matrix[0][j] = true;
        }
        
        for(int y = 1; y < s1.length() + 1; y++) {
            for(int x = 1; x < s2.length() + 1; x++) {
                
                if(s1.charAt( (y - 1) ) == s3.charAt( (y + x) - 1) && matrix[y - 1][x] == true )
                    matrix[y][x] = true;
                
                if(s2.charAt( (x - 1) ) == s3.charAt( (y + x) - 1) && matrix[y][x - 1] == true )
                    matrix[y][x] = true;
                
            }
        }
        
        return matrix[s1.length()][s2.length()];
    }

    /**
     * Recursive solution, works however it's complexity is higher
     */
    public boolean isInterleaveRecursive(String s1, String s2, String s3) {
        if(s1.length() == 0 && s2.equals(s3)) {
            return true;
        }
        
        if(s2.length() == 0 && s1.equals(s3)) {
            return true;
        }
        
        if(s3.length() != (s1.length() + s2.length()))
            return false;
        
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();
        
        return isInterleave(array1, array2, 0, 0, 0, s3);
    }
    
    public boolean isInterleave(char[] array1, char[] array2, int position1, int position2, int index, String s3) {
        if(position1 == array1.length && position2 == array2.length && index == s3.length()) {
            return true;
        }
        
        if(position1 < array1.length) {
            if(s3.charAt(index) == array1[position1]) {
                if(isInterleave(array1, array2, position1 + 1, position2, index + 1, s3))
                    return true;
            }
        }
        
        if(position2 < array2.length) {
            if(s3.charAt(index) == array2[position2]) {
                if(isInterleave(array1, array2, position1, position2 + 1, index + 1, s3))
                    return true;
            }
        }
        
        return false;
    }

}