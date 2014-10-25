/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * 
 * 
 * Solution: Medium Difficulty
 * Make sure NOT to brute force the solution, there is no need to calculate all paths individually, most incorrect way to answer this
 * Bottoms Up DP, generate most probable combination from current member.
 * 
 */
public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int[] sums = new int[triangle.size()];
		
		//fill array with values from next row(last row's next row is empty so just copy it)
		for(int i = 0; i < triangle.size(); i++)
			sums[i] = triangle.get(triangle.size() - 1).get(i);
		
		for(int i = triangle.size() - 2; i >= 0; i--) //start from penultimate row
			for(int j = 0; j <= i; j++) //row has same # of columns as row level
				sums[j] = triangle.get(i).get(j) + Math.min(sums[j], sums[j + 1]); //from available options choose smallest one
		
		return sums[0];
    }

    //version 2
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0)
            return 0;
            
        if(triangle.size() == 1)
            return triangle.get(0).get(0);
            
        int[] results = new int[triangle.size()];
        ArrayList<Integer> initialLevel = (ArrayList<Integer>)triangle.get(triangle.size() - 1);
        for(int i = 0; i < results.length; i++) {
            results[i] = initialLevel.get(i);
        }
        
        for(int i = results.length - 2; i >= 0; i--) {
            ArrayList<Integer> currentLevel = (ArrayList<Integer>)triangle.get(i);
            for(int j = 0; j <= i; j++) {
                int currentNumber = currentLevel.get(j);
                int min = Math.min(results[j], results[j + 1]);
                results[j] = currentNumber + min;
            }
        }
    
        return results[0];    
    }
}