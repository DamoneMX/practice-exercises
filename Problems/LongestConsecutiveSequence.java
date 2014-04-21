public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num){
		int max = 0;
		if(num.length == 0)
			return max;
		if(num.length == 1)
			return 1;
		
		HashSet<Integer> belongs = new HashSet<Integer>();
		HashMap<Integer, Integer> beginAt = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> endsAt = new HashMap<Integer, Integer>();
		
		
		for(int i = 0; i < num.length; i++){
			if(belongs.contains(num[i]))
				continue;
			
			int range = 1;
			boolean contained = false;
			
			if(endsAt.containsKey(num[i] - 1)){ //if some range ends at prev. num then we have to add new number
				int begin = endsAt.get(num[i] - 1);
				endsAt.remove(num[i] - 1);
				endsAt.put(num[i], begin);
				range = Math.abs(num[i] - begin) + 1;
				
				beginAt.put(begin, num[i]);
				contained = true;
			}
			
			if(contained == false){
				beginAt.put(num[i], num[i]);
				endsAt.put(num[i], num[i]);
			}
			
			if(beginAt.containsKey(num[i] + 1)){ //now see if num after current val is contained and join ranges
				int end = beginAt.get(num[i] + 1);
				int beginning = endsAt.get(num[i]);
				
				beginAt.put(beginning, end);
				beginAt.remove(num[i] + 1);
				endsAt.put(end, beginning); //updates val
				endsAt.remove(num[i]);
				contained = true;
				range = Math.abs(end - beginning) + 1;
			}

			if(range > max) max = range;
			
			belongs.add(num[i]);
		}
		
		return max;
	}
}