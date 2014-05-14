/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining. 
 */
public class TrappingRainWater {

	//DP Solution with memorization
	//2 scans: 
	//Left to Right and Right to Left to compare against current point
	public static int trap(int[] A) {
		if(A.length == 0)
			return 0;
		
		int[] highestLeft = new int[A.length];
		int[] highestRight = new int[A.length];
		
		//get the highest bar coming from left to right
		for(int i = 0; i < highestRight.length; i++){
			if(i == 0)
				highestRight[i] = A[i];
			else{
				highestRight[i] = highestRight[i -1];
				
				if(A[i] > highestRight[i])
					highestRight[i] = A[i];
			}
		}
		
		
		//get the highest bar coming from right to left
		for(int i = A.length - 1; i >= 0; i--){
			if(i == A.length - 1)
				highestLeft[i] = A[i];
			else{
				highestLeft[i] = highestLeft[i + 1];
				
				if(A[i] > highestLeft[i + 1])
					highestLeft[i] = A[i];
			}
		}
		
		int total = 0;
		for(int i = 0; i < A.length; i++){
			total += Math.min(highestRight[i], highestLeft[i]) - A[i];
		}
		
		return total;
	}
	
	//works but useless for inputs with range: 0 - 1500
	//Inneficient as it can be Max in A to N O(Max * A), worst case can get very bad
	public static int trap2(int[] A) {
		if(A.length == 0)
			return 0; 
		
        int max = 0;
        for(int i = 0; i < A.length; i++){
        	if(max < A[i])
        		max = A[i];
        }
        
        int[] register = new int[max];
        int total = 0;
        int currMax = 0;
        
        for(int i = 0; i < A.length; i++){
        	for(int j = A[i]; j < currMax; j++)
        		register[j] += 1;
        	
        	if(A[i] >= currMax){
        		currMax = A[i];
        		for(int k = 0; k < register.length; k++){
        			total += register[k];
        			register[k] = 0;
        		}
        	}
        	else{
        		for(int k = 0; k < A[i]; k++){
        			total += register[k];
        			register[k] = 0;
        		}
        	}
        	
        }
        
        return total;
    }

	public static void main(String[] args){
    	int[] array = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(array));
	}
}