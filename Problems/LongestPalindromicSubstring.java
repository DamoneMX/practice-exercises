/**
 * Given a string S, find the longest palindromic substring in S.
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args){
        System.out.println(longestPalindrome("ab"));
        System.out.println(longestPalindrome("abba"));
        System.out.println(longestPalindrome("aracecart"));
    }

    //Version 2 -> less checks a bit simpler, same idea
    public String longestPalindrome(String s) {
        if(s.length() == 0)
            return "";
        
        String longestPalindrome = "";
        for(int i = 0; i < s.length(); i++) {
            String pal1 = findPalindrome(i, i, s);
            if(pal1.length() > longestPalindrome.length()) {
                longestPalindrome = pal1;
            }
            
            if(i + 1 < s.length()) {
                if(s.charAt(i) == s.charAt(i + 1)) {
                    String pal2 = findPalindrome(i, i + 1, s);
                    if(pal2.length() > longestPalindrome.length()) {
                        longestPalindrome = pal2;
                    }
                }
            }
        }
        
        return longestPalindrome;
    }
    
    public String findPalindrome(int start, int end, String s){
        while(start - 1 >= 0 && end + 1 < s.length()) {
            if(s.charAt(start - 1) == s.charAt(end + 1)) {
                start--;
                end++;
            } else {
                break;   
            }
        }
        
        return s.substring(start, end + 1);
    }

    //Version 1
    public static String longestPalindrome(String s) {
        if(s.length() == 0 || s.length() == 1) 
            return s; 

        int strLength = s.length();
        int maxLength = 0;
        String longestPalindrome = "";

        for(int i = 0; i < strLength; i++) {
            String pal1 = findLongestPalindrome(s, i, i);
            if(pal1.length() > longestPalindrome.length())
                longestPalindrome = pal1;


            if (i < strLength - 1 && (s.charAt(i) == s.charAt(i + 1) )  ) {
                String pal2 = findLongestPalindrome(s, i, i + 1);
                if (pal2.length() > longestPalindrome.length())
                    longestPalindrome = pal2;
            }
        }

        return longestPalindrome;
    }


    public static String findLongestPalindrome(String s, int center1, int center2){
        int start = center1; 
        int end = center2;

        while (true){
            if ( (start - 1) >= 0 && (end + 1) < s.length() && (s.charAt(start - 1) == s.charAt(end + 1)) ) {
                start--;
                end++;
            } else  {
                break;
            }
        }

        return s.substring(start, end + 1);
    }



    //2 centers, 
    //an even length palindrome has 2 letters as center
    //an uneven length palindrom has 1 letter as center
           // aabbaa
           // racecar
    public static String findPalindrome2(String s, int center1, int center2){
        int start = center1;
        int end = center2;

        if(center2 < s.length() && s.charAt(center1) == s.charAt(center2)){ 
            while(true){
                if( (start - 1 >= 0) && (end  + 1 <= (s.length() - 1)) && s.charAt(start - 1) == s.charAt(end + 1) ) {
                    start--;
                    end++;
                } else {
                    break;
                }
            }
        }
        else{
            start = center1; 
            end = center2;
        }

        System.out.println(start + " " + end);
        //if(center1 == center2)
            end += 1;

        return s.substring(start, end);
    }

    //REVISED DP: much easier to understand
    /*
        Matrix looks like this when finished:
    1 -0 -0 -0 -0 -0 -1 -
    0 -1 -0 -0 -0 -1 -0 -
    0 -0 -1 -0 -1 -0 -0 -
    0 -0 -0 -1 -0 -0 -0 -
    0 -0 -0 -0 -1 -0 -0 -
    0 -0 -0 -0 -0 -1 -0 -
    0 -0 -0 -0 -0 -0 -1 -
    */
    if(s.length() == 0 || s.length() == 1)
            return s;
        
        int[][] matrix = new int[s.length()][s.length()];
        String longestPalindrome = "";
        
        for(int i = 0; i < s.length(); i++) {
            matrix[i][i] = 1;
            longestPalindrome = s.substring(i, i + 1);
        }
        
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                matrix[i][i + 1]  = 1;
                longestPalindrome = s.substring(i, i + 2);
            }
        }
        
        for(int i = s.length() - 3; i >= 0; i--) {
            for(int j = s.length() - 1; j > i + 1; j--) {
                if(s.charAt(i) == s.charAt(j)) {
                    matrix[i][j] = matrix[i + 1][j - 1];
                    String sub = s.substring(i, j + 1);
                    if(sub.length() > longestPalindrome.length()) 
                        longestPalindrome = sub;
                }
            }
        }
      
        return s;
    }




    public static String longestPalindrome2(String s) {
        if(s.length() == 0 || s.length() == 1)
            return s;

        String modString = s.replaceAll("\\s", "");
        int[][] table = new int[modString.length()][modString.length()];
        int max = 0;
        int y = 0;

        for(int i = 0; i < modString.length(); i++) {
            if(modString.charAt(i) == modString.charAt(modString.length() - 1)) {
                table[0][i] = 1;
            }
        }

        for(int i = 0; i < modString.length(); i++) {
            if(modString.charAt(0) == modString.charAt( (modString.length() - 1) - i) ) {
                table[i][0] = 1;
            }
        }


        for(int i = 1; i < modString.length(); i++) {
            for(int j = 1; j < modString.length(); j++) {
                if(modString.charAt(j) == modString.charAt((modString.length() -1) - i)) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                    if(table[i][j] > max) {
                        max = table[i][j];
                        y = j;
                        //System.out.println(max);
                        //System.out.println(y);
                    }
                }
            }
        }

        //System.out.println(y);

        return modString.substring((y + 1) - max, y + 1);

    }
}
