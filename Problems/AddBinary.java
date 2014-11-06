/**
 *  Given two binary strings, return their sum (also a binary string).
 *  Example:
 *  a = "11"  b = "1" 
 *  a + b = "100"
 */
public class AddBinary {

    //Version 2 = Nov. 5 2014
    public String addBinary(String a, String b) {
        if(a.length() == 0) {
            return b;
        }
        
        if(b.length() == 0) {
            return a;
        }
        
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuffer buffer = new StringBuffer();
        while(i >= 0 || j >= 0){
            int sum = 0;
            if(i >= 0) {
                if(arr1[i] == '1') 
                    sum += 1;
                i--;
            }
            
            if (j >= 0) {
                if(arr2[j] == '1')
                    sum += 1;
                j--;
            }
            
            sum += carry;
            
            if(sum == 2){
                buffer.insert(0,'0'); //this will be in reverse
                carry = 1;
            } else if (sum == 3){
                buffer.insert(0,'1'); //this will be in reverse
                carry = 1;
            }else {
                buffer.insert(0,sum);
                carry = 0;
            }
            
        }
        
        if(carry == 1){
            buffer.insert(0, 1);
        }
        
        return new String(buffer);
    }

    public String addBinary(String a, String b) {
        if(a.length() == 0)
        	return b;
        
        if(b.length() == 0)
        	return a;
        
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        reverseArray(aChars);
        reverseArray(bChars);
        
        String result = "";
        int carry = 0; 
        for(int i = 0; i < Math.max(aChars.length, bChars.length); i++){
        	int numA = getNum(aChars, i);
        	int numB = getNum(bChars, i);
        	int sum = carry + numA + numB;
        	result = (sum % 2) + result;
        	carry = sum / 2;
        }
        
        if(carry == 1)
        	result = 1 + result;
        
        return result;
    }
	
	public int getNum(char[] array, int i){
		int response = 0;
		if(i < array.length && array[i] == '1')
			response = 1;
		
		return response;
	}
	
	public void reverseArray(char[] array){
		int i =0;
		int j = array.length-1;
        while(i<=j){
            char t = array[i];
            array[i] = array[j];
            array[j] = t;
            i++;
            j--;
        }
	}
	
}