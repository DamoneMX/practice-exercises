import java.util.*;
/**
 * Works correctly, only thing is to refactor this to make it into decent code.
 */
public class RomanToInteger {
	public String intToRoman(int num) {
        int divisor = 1000;
        String romanResult = "";
        //Initializing reference DS
        Hashtable<Integer, String[]> reference = new Hashtable<Integer, String[]>();
        //Millares
        String[] millares = new String[1];
        millares[0] = "M";
        reference.put(1000, millares);
        //Centenas
        String[] centenas = new String[2];
        centenas[0] = "C";
        centenas[1] = "D";
        reference.put(100, centenas);
        //Decenas
        String[] decenas = new String[2];
        decenas[0] = "X";
        decenas[1] = "L";
        reference.put(10, decenas);
        //Unidades
        String[] unidades = new String[2];
        unidades[0] = "I";
        unidades[1] = "V";
        reference.put(1, unidades);
        
        int unit = num/divisor;
        for(int i = 1; i <= unit; i++){
        	romanResult = romanResult + "M";
        	num -= divisor;
        }
        
        divisor = divisor / 10;
        
        while(divisor > 0){
        	unit = num / divisor;
        	String[] unitRepresentation = reference.get(divisor); 
        	switch(unit){
        		case 1: case 2: case 3:
        			for(int i = 1; i <= unit; i++){
        	        	romanResult = romanResult + unitRepresentation[0];
        	        }
        			break;
        		case 4: 
        			romanResult = romanResult + unitRepresentation[0];
        			romanResult = romanResult + unitRepresentation[1];
        			break;
        		case 5: 
        			romanResult = romanResult + unitRepresentation[1];
        			break;
        		case 6: case 7: case 8:
        			romanResult = romanResult + unitRepresentation[1];
        			for(int i = 1; i <= unit - 5; i++)
        	        	romanResult = romanResult + unitRepresentation[0];
        			break;
        		case 9: 
        			String[] unitRepresentation2 = reference.get(divisor * 10); 
        			romanResult = romanResult + unitRepresentation[0];
        			romanResult = romanResult + unitRepresentation2[0];
        			break;
        	}
        		
        	num -= divisor * unit;
        	divisor = divisor / 10;
        }
        
        return romanResult;
       
    }
}