public class RecursionNQueens{

    public static void main(String[] args){
	ArrayList<Integer[]> results = nQueens(8);
	for(Integer[] array: results){
		System.out.println("Next Solution");
	    	for(int i = 0; i < array.length; i++){
			System.out.print(array[i]);
	    	}
	    	System.out.println("");
	}
    }

    public static ArrayList<Integer[]> nQueens(int n){
    	ArrayList<Integer[]> result = new ArrayList<Integer[]>();
    	placeQueen(0, new Integer[n], result, n);
    	return result;
    }
    
    public static void placeQueen(int row, Integer[] columns, ArrayList<Integer[]> results,  int gridSize){
    	if(row == gridSize){
    		results.add(columns.clone());
    	}
    	else{
    		for(int col = 0; col <  gridSize; col++){
    			if(checkValidSpot(columns, row ,col)){ //if it's possible to add in this cell then add it
    				columns[row] = col;
    				placeQueen(row + 1, columns, results, gridSize);
    			}
    		}
    	}
    }
    
    public static boolean checkValidSpot(Integer[] columns, int newRow, int newColumn){
    	for(int i = 0; i < newRow; i++){ //We are going down row by row, so previous rows have already been placed somewhere in the array.
    		
    		int storedColumn = columns[i];
    		
    		//we don't have to worry about being in same row	    	
	    	//first check that queens are not in same column
    		if(newColumn == storedColumn)
    			return false;
	    	
    		int yDistance = Math.abs(newColumn - storedColumn);
    		
    		if(yDistance == (newRow - i)) //i represents the row we are currently checking
    			return false;
	    	//now check that queens are not in diagonal
    	}
    	
    	return true;
    }

}
