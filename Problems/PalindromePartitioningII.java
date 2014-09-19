/**
 * 
 */
public class PalindromePartitioningII{
	if(s.length() == 0)
			return 0;
		
		int n = s.length();
		boolean[][] palindromes = new boolean[n][n];
		int[][] cuts = new int[n][n];
		
		for(int i = n - 1; i >= 0; i--) {
		    for(int j = i; j < n; j++) {
		        if(i == j) { 
		            palindromes[i][j] = true;
		        } else {
		            if(j == i + 1){
		                if(s.charAt(i) == s.charAt(j))
		                    palindromes[i][j] = true;
		            } else{
		                    palindromes[i][j] = (s.charAt(i) == s.charAt(j)) && palindromes[i + 1][j -1];
		            }
		        }
		        
		        if(palindromes[i][j] == true)
		            cuts[i][j] = 0;
		        else {
		            cuts[i][j] = Integer.MAX_VALUE;
		            for(int k = i; k < j; k++)
		                cuts[i][j] = Math.min(cuts[i][j], cuts[i][k] + cuts[k+1][j] + 1);
		        }
		    }
		}
		
		/*
		for(boolean[] arr : palindromes){
			for(boolean val : arr)
				System.out.print(val);
			System.out.println("   -> ");
		}
		
		for(int[] arr2: cuts){
			for(int num: arr2) {
				System.out.print(num);
			}
			System.out.println(" x");
		}
		*/
		
		return cuts[0][n - 1]; //obtains cut by comparing substrings

}



/*
 	//Second way to obtain min Cuts, uses one dimensio array
 int[] minCut = new int[n + 1];
        for (int i = n; i >= 0; i--)
            minCut[i] = n - 1 - i;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (isPalindrome[i][j]) {
                    minCut[i] = Math.min(minCut[i], 1 + minCut[j + 1]);
                }
            }
        }
        return minCut[0];
 */