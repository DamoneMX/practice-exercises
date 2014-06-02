/**
 *  You are given a string, S, and a list of words, L, that are all of the same length. 
 *  Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
 *  
 *  Example: 
 *  S: "barfoothefoobarman"      L: ["foo", "bar"]
 *  Answer: [0,9]
 *  Solution: 
 */
public class SubstringConcatenationAllWords{
    //O(N) complexity, good to analyze why
    //It's a O((n - k*m)*m) complexity really
    public List<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        if(S.length() == 0)
            return results;

        HashMap<String, Integer> register = new HashMap<String, Integer>();
        for(String str : L){
            if(register.containsKey(str))
                register.put(str, register.get(str) + 1);
            else
                register.put(str, 1);
        }
        
        int wordLength = L[0].length();
        int words = L.length;
        
        for(int i = 0; i <= S.length() - (wordLength * words); i++){
            HashMap<String, Integer> duplicate = new HashMap<String, Integer>(register);
            for(int j = i; j < i + (wordLength * words); j += wordLength){
                String substring = S.substring(j, j + wordLength);
                if(!duplicate.containsKey(substring))
                    break;
                else{
                    int quantity = duplicate.get(substring);
                    quantity -= 1;
                    if(quantity == 0)
                        duplicate.remove(substring);
                    else{
                        duplicate.put(substring, quantity);
                    }
                }
            }
            
            if(duplicate.isEmpty())
                results.add(i);
        }
        
        return results;
    }
}