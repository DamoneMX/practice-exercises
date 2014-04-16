/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility) 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Solution: Focus on the result you have to give back, not the process they request.
 */
public class ZigZagConversion{
	
	public static void main(String[] args){
		System.out.println(convert("PAYPALISHIRING", 3));
	}
	
	public static String convert(String s, int nRows) {
		if(s == null || s.length() <= 1 || nRows == 1)
			return s;
		
		ArrayList<StringBuilder> rows = new ArrayList<StringBuilder>();
		for(int i = 0; i < nRows; i++){
			rows.add(i, new StringBuilder());
		}
		
		int i = 0;
		boolean down = true;
		int currentRow = 0;
		
		while(i < s.length()){
			rows.get(currentRow).append(s.charAt(i));
			
			if(currentRow == 0 && !down)
				down = true;
			else if(currentRow == nRows - 1 && down)
				down = false;
			
			if(down)
				currentRow++;
			else if(!down)
				currentRow--;
			
			i++;
		}
		
		StringBuilder newString = new StringBuilder();
		for(int j = 0; j < nRows; j++)
			newString.append(rows.get(j).toString());
		
		return newString.toString();
	}
}	