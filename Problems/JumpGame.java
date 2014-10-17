
public class JumpGame {

    //2nd version
    public boolean canJump(int[] A) {
        if(A.length == 0)
            return true;
            
        int length = A.length - 1;
        int maxReach = A[0];
        int limit = A[0];
        for(int i = 1; i <= limit && i < A.length; i++) {
            maxReach = Math.max(i + A[i], maxReach);
            limit = Math.min(length, maxReach);
        }
        
        if(maxReach >= length)
            return true;
        else 
            return false;
    }


	/**
	 * Follow Up: 
	 * Your goal is to reach the last index in the minimum number of jumps. 
	 *
	 **/

    public int jumpFollowup(int[] A) {
		if(A.length == 0 || A.length == 1)
			return 0;
		
        int[] paths = new int[A.length];
        int currMax = 0;
        int nextMax = 0;
        int steps = 0;
        for(int i = 0; i < A.length; i++){
        	if(i + A[i] > nextMax)
        		nextMax = i + A[i];
        	
        	if(i <= currMax)
        		paths[i] = steps;
        	
        	if(currMax == i){
        		currMax = nextMax;
        		steps++;
        	}
        }
        
        return paths[A.length - 1];
    }
}
