public class WordSearch{

	public static void main(String[] args){
		char[] one = {'a', 'b', 'c', 'e'};
		char[] two = {'s', 'f', 'c', 's'};
		char[] three = {'a', 'd', 'e', 'e'};
		char[][] array = new char[3][3];
		array[0] = one;
		array[1] = two;
		array[2] = three;
		
		for(char[] charAr : array){
			System.out.println("");
			for(char caracter : charAr){
				System.out.print(caracter + ", ");
			}
		}
		System.out.println("");
		
		System.out.println(exist(array, "abcced"));
		
	}

	public static boolean exist(char[][] board, String word){
		if(board.length == 0 || word == null || board[0].length==0)
			return false;
		
		if(word.length() == 0)
			return true;
		
		int yLimit = board.length;
		int xLimit = board[0].length;
		
		word = word.toLowerCase();
		boolean[][] visited = new boolean[board.length][board[0].length];
		
		for(int i = 0; i < board.length; i++){ //next row
			for(int j = 0; j < board[0].length; j++){ //next column
				if(checkForWord(word, board, j, i, 0, visited, xLimit, yLimit)){
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static boolean checkForWord(String word, char[][] board, int x, int y, int count, boolean[][] visited, int xLimit, int yLimit){

		if(board[y][x] != word.charAt(count) || visited[y][x])
			return false;
		
		visited[y][x] = true;

		
        if(count == word.length() - 1) //Base case: we have succesfully gone through the whole word
			return true;
        
		
		if(y - 1  > 0 && checkForWord(word, board, x, y - 1, count + 1, visited, xLimit, yLimit)) //move up
			return true;
		
		if(y + 1 < board.length  && checkForWord(word, board, x, y + 1, count + 1, visited, xLimit, yLimit)) //move down
			return true;
		
		if(x - 1 > 0 && checkForWord(word, board, x - 1, y, count + 1, visited, xLimit, yLimit)) //move to the left
			return true;
			
		if(x + 1 < board[0].length && checkForWord(word, board, x + 1, y, count + 1, visited, xLimit, yLimit)) //move to the right
			return true;
		
		visited[y][x] = false;
		return false;
	}

	//Version 2: Oct. 25, 2014
	public boolean exist(char[][] board, String word) {
        if(word.length() == 0 || board.length == 0 || board[0].length == 0) {
            return false;
        }
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        //1. find start point
        for(int y = 0; y < board.length; y++) {
            for(int x = 0; x < board[0].length; x++) {
                if(board[y][x] == word.charAt(0)) { //start looking at that point
                    if(trackWord(y, x, 0, word, board, visited) == true) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    public boolean trackWord(int y, int x, int charIndex, String word, char[][] board, boolean[][] visited) {
        if (board[y][x] != word.charAt(charIndex)) {
            return false;
        }
        
        if (charIndex == word.length() -1) {
            return true;
        }
        
        visited[y][x] = true;
        
        if ( (y + 1) < board.length && !visited[y + 1][x]) {
            if(trackWord(y + 1, x, charIndex + 1, word, board, visited) == true)
                return true;
        }
        
        if ( (y - 1) >= 0  && !visited[y - 1][x]) {
            if(trackWord(y - 1, x, charIndex + 1, word, board, visited) == true)
                return true;
        }
        
        if ( (x+ 1) < board[0].length  && !visited[y][x + 1]) {
            if(trackWord(y, x + 1, charIndex + 1, word, board, visited) == true)
                return true;
        }
        
        if ( (x - 1) >= 0  && !visited[y][x - 1]) {
            if(trackWord(y, x - 1, charIndex + 1, word, board, visited) == true)
                return true;
        }
        
        visited[y][x] = false;
        return false;
    }


}