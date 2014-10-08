/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 */
public class PascalsTriangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(numRows == 0)
            return results;
            
        ArrayList<Integer> levelOne = new ArrayList<Integer>();
        levelOne.add(1);
        results.add(levelOne);    
        for(int i = 1; i < numRows; i++) {
            ArrayList<Integer> prevRow = results.get(i - 1);
            ArrayList<Integer> newRow = new ArrayList<Integer>();
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    newRow.add(1);
                } else {
                    newRow.add(prevRow.get(j) + prevRow.get(j -1));
                }
            }
            results.add(newRow);
        }

        return results;
    }
}
