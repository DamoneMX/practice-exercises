/*
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * 100 -> [1][0][0]
 *
 * Solution: low difficulty
 */
public class PlusOne{
	public int[] plusOne(int[] digits) {
        if(digits.length == 0){
        	int[] result = {1};
        	return result;
        }
        
        int length = digits.length;
        int carry = 1;
        
        for(int i = length - 1; i >= 0; i--){
        	if(carry == 0)
        		break;
        		
        	int temp = digits[i] + carry;
        	//System.out.println(temp);
        	if(temp == 10){
        		digits[i] = 0;
        		carry = 1;
        	}
        	else{
        		digits[i] = temp;
        		carry = 0;
        	}
        }
        
        if(carry == 1){
        	int[] newresult = new int[digits.length + 1];
        	newresult[0] = 1;
        	for(int i = 0; i < digits.length; i++){
        		newresult[i + 1] = digits[i];
        	}
        	digits = newresult;
        }
        
        return digits; 
    }

    //Version 2 = Oct. 18 2014
    public int[] plusOne(int[] digits) {
        
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] == 9 && carry == 1) {
                digits[i] = 0;
                carry = 1;
            } else {
                digits[i] = digits[i] + carry;
                carry = 0;
            }
        }
        
        if(carry == 1) {
            int[] newArray = new int[digits.length + 1];
            newArray[0] = 1;
            carry = 0;
            for(int i = 0; i < digits.length; i++) {
                newArray[i + 1] = digits[i];
            }
            digits = newArray;
        }
        
        return digits;
    }
}