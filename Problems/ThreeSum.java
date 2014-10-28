
public class ThreeSum{

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
}
