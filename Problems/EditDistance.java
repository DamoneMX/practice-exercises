-/**
 * 
 */
public class EditDistance {

    //use stack to keep track of the highest, and how many bars have been accumulated
    public int minDistance(String word1, String word2) {
        if(word1.length() == 0) {
            return word2.length();
        }
        
        if(word2.length() == 0) {
            return word1.length();
        }
        
        
        int[][] matrix = new int[word1.length() + 1][word2.length() + 1];
        
        for(int x = 0; x < matrix[0].length; x++) {
            matrix[0][x] = x;
        }
        
        for(int y = 1; y < matrix.length; y++) {
            matrix[y][0] = y;
        }
        
        for(int y = 1; y < matrix.length; y++) {
            for(int x = 1; x < matrix[0].length; x++) {
                int min = 0;
                if(word1.charAt(y - 1) != word2.charAt(x - 1)){
                    min = matrix[y - 1][x - 1] + 1;
                } else {
                    min = matrix[y - 1][x - 1];
                }
                
                min = Math.min(min, matrix[y][x - 1] + 1);
                min = Math.min(min, matrix[y - 1][x] + 1);
                
                matrix[y][x] = min;
            }
        }
        
        return matrix[matrix.length - 1][matrix[0].length - 1]; 
        
    }

    public static void main(String[] args) {
        System.out.println("    -> " + minDistance("zoologicoarchaeologist", "zoogeologist"));
    }
}