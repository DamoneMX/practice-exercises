/**
 * 6.2 Longest Increasing subsequence: Receive input of sequence of numbers a1, ...., aN
 * subsequence => subset of these numbers taken in order of the form ai1, ai1, ..., aiN where 1 <= i1 <= i2 <= N, 
 * increasing subsequence = sequence in which numbers are getting strictly larger
 * 
 * Example: 
 * 5, 2, 8, 6, 3, 6, 9, 7 
 * longest increasing subsequence is 2, 3, 6, 9:
 */
public class LongestIncreasingSubsequence{
    public static int computeLongestIncreasingSubsequence(int[] sequence) {
        if(sequence.length == 0)
            return 0;

        int max = 1;
    	int[] maxSubsequenceLength = new int[sequence.length];
        //Initialize all to 1, value itself leads toa subsequence of 1
        for(int i = 0; i < sequence.length; i++)
            maxSubsequenceLength[i] = 1;


        for(int i = 1; i < sequence.length; i++) {
            for(int j = 0; j < i; j++) {
                if(sequence[i] > sequence[j]) {

                    if(maxSubsequenceLength[j] + 1 > maxSubsequenceLength[i]){
                        maxSubsequenceLength[i] = maxSubsequenceLength[j] + 1;

                        if(maxSubsequenceLength[i] > max)
                            max = maxSubsequenceLength[i];
                    }

                } 
            }
        }

        return max;
    }

    public static void main(String[] args){
        int[] sequence = {5,2,8,6,3,6,9,7};
        System.out.println(computeLongestIncreasingSubsequence(sequence));
    }
}
