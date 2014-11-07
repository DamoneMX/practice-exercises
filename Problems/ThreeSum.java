
public class ThreeSum{

    //Improved Brute Force: O(n^2)
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num.length < 3) {
            return result;
        }
        
        HashSet<Integer> map = new HashSet<Integer>();
        for(int i = 0; i < num.length; i++) {
            map.add(num[i]);
        }
        
        for(int i = 0; i < num.length; i++) {
            for(int j = i + 1; j < num.length; j++) {
                int sum = num[i] + num[j];
                if(map.contains(-sum) == true) {
                    ArrayList<Integer> set1 = new ArrayList<Integer>();
                    set1.add(sum);
                    set1.add(num[i]);
                    set1.add(num[j]);
                    result.add(set1);
                }
            }
        }
        
        return result;
    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num.length < 3) {
            return result;
        }
        
        Arrays.sort(num);
        
        for(int i = 0; i < num.length - 2; i++) {
            //int negate = -1 * num[1];
            if(i == 0 || num[i] > num[i - 1]) {
            
                int start = i + 1;
                int end = num.length - 1;
                
                while(start < end) {
                    if(num[start] + num[end] + num[i] == 0) {
                        ArrayList<Integer> set = new ArrayList<Integer>();
                        set.add(num[i]);
                        set.add(num[start]);
                        set.add(num[end]);
                        result.add(set);
                        
                        start++;
                        end--;
                        
                        while(start < end && num[end] == num[end + 1])
                            end--;
                            
                        while(start < end && num[start]== num[start - 1])
                            start++;
                        
                    } else {
                        if(num[start] + num[end] + num[i] > 0) {
                            end--;
                        } else {
                            start++;
                        }
                    }
                }
            
            }
        }
        
        return result;
    }


}
