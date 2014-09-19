/**
 *  Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 *      Only one letter can be changed at a time
 *      Each intermediate word must exist in the dictionary
 */
public class WordLadder {
    
    /*
     * Problem solved through BFS. Using a queue to mimic each level of the tree
     * Guarantee that we will find shortest path as the first solution we will find is by level. 
     * We can remove found words from dict, because if we find same word again, it will be in level below.
     *
     * DFS could also work, but would take more time
     */
    public static int ladderLength(String start, String end, HashSet<String> dict){
        
        if(start.equals(end))
            return 0;
        
        Queue<String> strings = new LinkedList<String>();
        Queue<Integer> stepCount = new LinkedList<Integer>();
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        
        strings.add(start);
        stepCount.add(0);
        while(!strings.isEmpty()){
            String currStr = strings.poll();
            System.out.println(currStr);
            int steps = stepCount.poll();
            
            for(int i = 0; i < currStr.length(); i++){
                char[] strChar = currStr.toCharArray();
                for(int j = 0; j < alphabet.length; j++) {
                    strChar[i] = alphabet[j];
                    String newStr = new String(strChar);
                    if(newStr.equals(end))
                        return steps;
                    
                    if(dict.contains(newStr)) {
                        strings.add(newStr);
                        stepCount.add(steps + 1);
                        dict.remove(newStr);
                    }
                }
            }
        }
        
        return 0;
    }

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<String>();
        set.add("hot");
        set.add("dot");
        set.add("dog");
        set.add("lot");
        set.add("log");
        
        System.out.println(ladderLength("hit", "cog", set));
        
    }

}