/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * Example: 
 * "25525511135" => ["255.255.11.135", "255.255.111.35"]
 * 
 * Solution: DFS solution, try all combos and see if it's valid or not
 * Note: Code had a bug on OJ judge but does give correct answer
 */
public class RestoreIP {

    public static void main(String[] args){
        ArrayList<String> result = restoreIpAddresses("010010");
        for(String res : result) {
            System.out.println(res);
        }   
    }
    
    public static ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> results = new ArrayList<String>();
        generateAddresses("", "", s, 4, results);
        return results;
    }
    
    public static void generateAddresses(String currSet, String resSet, String remString, int remainingSets, ArrayList<String> results){
        int numericalValue;
        if(currSet.equals("")) {
            numericalValue = 0;
        } else {
            numericalValue = Integer.parseInt(currSet) ;
        }
        
        if(remString.equals("")) {
            if(remainingSets == 0 && numericalValue <= 255) {
                resSet = resSet + "." + currSet;
                results.add(resSet);
            } else {
                return;
            }
        }
        
 
        if(remString.length() <= remainingSets * 3 && numericalValue <= 255) {
            if(remainingSets != 4 )
                if(remainingSets == 3){
                    resSet = resSet  + currSet;
                } else
                    resSet = resSet + "." + currSet;
            
            for(int i = 1; i <= 3 && i <= remString.length() ; i++) {
                generateAddresses(remString.substring(0, i), resSet + "", remString.substring(i, remString.length()), remainingSets - 1, results);
            }
        }
        
    }

    //Version 2: 
    // quick to find solution, lazy to make it bug - free(took too long)
        public static ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();      
        if (s.length() == 0) {
           return result;
        }
        
        generateAddresses(new StringBuffer(), 0, s, result);    
        return result;
    }
    
    public static void generateAddresses(StringBuffer buffer, int count, String remaining, ArrayList<String> result){
        if(remaining.length() == 0 && count == 4) {
            result.add(new String(buffer));
            return;
        }    
        
        if(count > 4)
            return;
    
        boolean flag = false;
        for(int i = 1; i <= 3 && i <= remaining.length(); i++) {
            String temp = remaining.substring(0 , i);
            
            if(i == 1 && temp.equals("0")) {
                flag = true;
            }
                
            if(i == 2 && flag) {
                return;
            }
                
            if(Integer.parseInt(temp) <= 255) {
                StringBuffer copy = new StringBuffer();
                copy.append(buffer);
                copy.append(temp);
                int dots = count;
                dots++;
                if(count <= 2) 
                    copy.append(".");
                
                String newRemaining = remaining.substring(i , remaining.length());
                if(dots == 4 && newRemaining.length() > 0)
                    continue;
                
                generateAddresses(copy, dots, newRemaining, result);
            }
        }
        
    }


}
