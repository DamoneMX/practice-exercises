/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * Solution: Not that much trouble, just probably refactor this code
 *
 **/
public class Solution {
    public int romanToInt(String s) {
        int value = 0;
	s = s.toLowerCase();
	char[] letters = s.toCharArray();
	for(int i = 0; i < letters.length; i++){
		if(letters[i] == 'm')
			value += 1000;
		else if(letters[i] == 'c'){
			if(i + 1 < letters.length && (letters[i + 1] == 'm' || letters[i + 1] == 'd') )
				value -= 100;
			else
				value += 100;
		}
		else if(letters[i] == 'x'){
			if(i  + 1 < letters.length && (letters[i + 1] == 'c' || letters[i + 1] == 'l' ))
				value -= 10;
			else
				value += 10;
		}
		else if(letters[i] == 'i'){
			if(i  + 1 < letters.length && (letters[i + 1] == 'v' || letters[i + 1] == 'x' ))
				value -= 1;
			else
				value += 1;
		}
		else if(letters[i] == 'd'){
			value += 500;
		}
		else if(letters[i] == 'l')
			value += 50;
		else if(letters[i] == 'v')
			value += 5;
	}
	
	return value;
    }
}
