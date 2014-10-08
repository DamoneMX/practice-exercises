/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class PopulateParentheses {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> results = new ArrayList<String>();
        if(n == 0)
            return results;
            
        char[] result = new char[n * 2];
        generateParenthesis(n, n, 0,  result, results);
        return results;
    }
    

    // a lot of calls are made to this function and they simply return;
    public void generateParenthesis(int remLeft, int remRight, int index, char[] curr, ArrayList<String> results){
        //for call e.g. generatheParenthesis(3, 2, 1, copy, results)
        //")("
        if(remRight < remLeft)
            return;

        if(remLeft == 0 && remRight == 0){
            results.add(new String(curr));
            return;
        }      
          
        if(remLeft > 0){
            curr[index] = '(';

            char[] copy = Arrays.copyOf(curr, curr.length);
                generateParenthesis(remLeft - 1, remRight, index + 1, copy, results);
        }
            
        if(remRight > 0){
            curr[index] = ')';
            char[] copy = Arrays.copyOf(curr, curr.length);
            generateParenthesis(remLeft, remRight - 1, index + 1, copy, results);
        }
        
        
    }
}
