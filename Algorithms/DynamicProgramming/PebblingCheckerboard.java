/**
 * Given a checkerboard, 4 rows N columns = Integer written in each square
 * Given set of 2n pebbles, 
 * We want to place some or all pebbles on checkerboard as to maximize sum of integers in squares covered by pebbles.
 * Constraint:
 * - No two of them can be on horizontally or vertically adjacent squares.
 *
 * (A) Determine number of legal patterns that can occur in any column (ignore pebbles in adjacent columns), describe these patterns
 * 2 patterns compatible if: they can be placed on adjacent columns to form a legal placement.
 *
 * Consider subproblems consisting of first k columns (1 <= k <= n), each subproblem can be assigned a type, which is pattern occurring in last col.
 * 
 * B) Use notions of compatibility and type, give O(n)-time algorithm for computing optimal placement
 */
public class PebblingCheckerboard {
    //DP Solution: maximize 1 to k, when computing (k + 1) you only care about the type of (k)

	//A - 
	//At given time you can place at most 2 pebbles per row
	//Each type gives you a certain sum.
	//8 available types in one row -> assuming there are negative values
	//3 available types if there's no negative values

	//Compute sum of all types for a row
	//B) DP problem
	//Type 1 is not compatible with type 2 and 3. is compatible with type 4, 5, 7
	//Type 1 = 0 and 2
	//Type 2 = 1 and 3
	//Type 3 = none (will not be used)

	//Algorithm
	//2 matrixes if we want to return placements
	//Matrix 1 = Holds computation of sums per type
	//Matrix 2 = Holds DP sum
	//start at row 2, since row 1 already has no predecessor from which to add value
	//for each cell, choose maximum value from compatible types in previous row

	//to give result it has to be bottoms up, substract sum from cellvalue and go back one step.
	//Complexity = At most 3 comparisons per type

	//Solution assuming there are only positive values in checkerboard
	//checkerboard = int[N][4]
    public int computeMaxPlacement(int[][] checkerboard) {
    	int N = checkerboard.length;
    	int[][] typeSums = new int[N][2];

    	//compute sum of each type
    	for(int i = 0; i < N; i++){
    		//sum type 1 placement
    		typeSum[i][0] = checkerboard[i][0] + checkerboard[i][2];
    		//sum type 2 placement
    		typeSum[i][1] = checkerboard[i][1] + checkerboard[i][3];
    	}

    	//make a copy of type table
    	int[][] result = new int[N][2];
    	result[0][0] = typeSum[0][0];
    	result[0][1] = typeSum[0][1];

    	for(int i = 1; i < N; i++){
    		for(int j = 0; j < 2; j++){
    			if(j == 0){
    				//look for max compatible types
    				int max = 0;
    				max = Math.max(max, typeSum[i - 1][1]);
    				result[i][j] = typeSum[i][j] + max;
    			} else {
    				//look for max compatible types
    				int max = 0;
    				max = Math.max(max, typeSum[i - 1][0]);
    				result[i][j] = typeSum[i][j] + max;
    			}
    		}
    	}

    	int result = 0;
    	for(int i = 0; i < typeSum[N - 1].length; i++){
    		result = Math.max(typeSum[N - 1][i], result);
    	}

        return result;
    }
}
