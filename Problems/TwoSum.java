public class Solution{
    public int[] twoSum(int[] numbers, int target) {
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	int start = 0;
    	int end = numbers.length - 1;
   	int[] result = new int[2];
   	
   	for(; start < numbers.length; start++, end--){
   		if(map.get(numbers[start]) == null){
   			map.put(numbers[start], start);
   		}
   		
   		//if(numbers[start] <= target){
    		Integer storedIndex = map.get(target - numbers[start]);
    			if(storedIndex != null && storedIndex != start){
    				result[0] = storedIndex + 1;
				result[1] = start + 1;
				return result;
    			}
       		}
    		
    		return result;
	}

    public static void main(String[] args) {
    	
    	Solution4 s3 = new Solution4();
    	int[] numbers = {-3,4,3,90};
    	int[] results = s3.twoSum(numbers, 6);
    	for(int i : results){
    		System.out.println(i);
    	}
    		
    }
}
