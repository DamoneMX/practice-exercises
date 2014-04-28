/*
 *  Given a digit string, return all possible letter combinations that the number could represent.
 *  mapping of digit to letters is the same as the one on a telephone.
 */
public class PhoneNumberCombinations {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> results = new ArrayList<String>();
        if(digits.length() == 0){
            results.add("");
            return results;
        }
        
        String[][] dictionary = new String[10][3];
		String[] row1 = {"a","b", "c"};
		dictionary[2] = row1;
		String[] row2 = {"d","e", "f"};
		dictionary[3] = row2;
		String[] row3 = {"g","h", "i"};
		dictionary[4] = row3;
		String[] row4 = {"j","k", "l"};
		dictionary[5] = row4;
		String[] row5 = {"m","n", "o"};
		dictionary[6] = row5;
		String[] row6 = {"p","q", "r", "s"};
		dictionary[7] = row6;
		String[] row7 = {"t","u", "v"};
		dictionary[8] = row7;
		String[] row8 = {"w","x", "y", "z"};
		dictionary[9] = row8;
		
		
		
		letterCombinations(digits.toCharArray(), 0, dictionary, "", results);
		return results;
    }
    
    public static void letterCombinations(char[] input, int index, String[][] dictionary, String current, ArrayList<String> results){
		if(index == input.length){
			results.add(current);
			return;
		}
		
		char element = input[index]; //convert this to integer
		int elementIndex = Character.getNumericValue(element);  
		
		
		int upperEnd = 3;
		if(elementIndex == 7 || elementIndex == 9)
			upperEnd = 4;
		for(int i = 0; i < upperEnd; i++){
			String append = "";
			if(element != 1 || element != 0)
				append = dictionary[elementIndex][i];
			
			letterCombinations(input, index + 1, dictionary, current + append, results);
		}
	}

	public static void main(String[] args){
		ArrayList<String> string = letterCombination("33");
			for(String word : string){
				System.out.println(word);
			}
		}
	}
}