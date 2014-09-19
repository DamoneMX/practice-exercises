/**
 * Given a string S, find the longest palindromic substring in S.
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args){
        System.out.println(longestPalindrome("ab"));
        System.out.println(longestPalindrome("abba"));
        System.out.println(longestPalindrome("aracecart"));
    }

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
