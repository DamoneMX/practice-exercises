/**
 *  Gray Code problem
 */
public class GrayCodeProblem {
    
    //Version 1 -> October 24, 2014
	public static ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
       
        
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < n; i++) {
            buffer.append("0");
        }
        
        HashSet<String> set = new HashSet<String>();
        set.add(new String(buffer));
        result.add(stringToInteger( new String(buffer) ));
        
        generateGrayCode(buffer, set,  result, n);
        
        return result;
    }
    
    public static void generateGrayCode(StringBuffer buffer, HashSet<String> set, ArrayList<Integer> result, int n) {
        for(int i = n - 1; i >= 0; i--) {
            StringBuffer copy = new StringBuffer();
            copy.append(buffer);
            
            if(copy.charAt(i) == '0')
                copy.setCharAt(i, '1');
            else 
                copy.setCharAt(i, '0');
                
            if(set.contains(new String(copy)) == false) {
                set.add(new String(copy));
                result.add(stringToInteger( new String(copy) ));
                generateGrayCode(copy, set, result,  n);
                return;
            }
        }
    }
    
    public static Integer stringToInteger(String binaryRepresentation){
    	int integerRepresentation = 0;
    	for(int i = binaryRepresentation.length() - 1, j = 0; i >= 0; i--, j++) {
    		if(binaryRepresentation.charAt(i) == '1') {
    			integerRepresentation += Math.pow(2, j);
    		}
    	}
    	//System.out.println(integerRepresentation + "i  b" + binaryRepresentation);
    	
    	return integerRepresentation;
    }

}