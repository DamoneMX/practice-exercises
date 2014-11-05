/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber{

	//Version 2: Nov. 4 2014
	public static boolean isPalindrome(int x) {
		if(x < 0) {
            return false;
        }   
        
        int temp = x;
        int count = 0;
        
        while(temp != 0){
            count += temp % 10;
            temp = temp / 10;
            if(temp != 0)
            	count *= 10;
        }
        
        
        if(x - count == 0)
        	return true;
        else 
        	return false;
    }

	public boolean isPalindrome(int x) {
        if(x < 0)
			return false;
		
		int ceros = 1;
		while((x / ceros) >= 10){
			ceros *= 10;
		}
		
		//if(ceros == 1)
			//return true;
		
		int lowest = 10;
		
		while(lowest <= ceros){
			int high = x / ceros;
			int low = x % lowest;
			low = low / (lowest / 10);
			if(high != low)
				return false;
			
			x = x % ceros;
			ceros = ceros / 10;
			
			lowest = lowest * 10;
			
		}

		return true;
    }

    public static void main(String[] args){	
		System.out.println(isPalindrome(2147483647));
	}
}