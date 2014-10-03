-/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram. 
 * 
 * 
 * Solution: Medium Difficulty
 * This is a solution that has worst case O(n^2), and O(n) space complexity, however it's better than simply brute forcing solution
 * as in the best case it's much better than the O(n^2) comparison solution
 * 
 */
public class LargestRectangleHistogram {

    //use stack to keep track of the highest, and how many bars have been accumulated
    public int largestRectangleArea(int[] height) {
        if(height.length == 0)
            return 0;
        
        Stack<Integer> stack = new Stack<Integer>();
       
        int maxArea = 0;
        for(int i = 0; i < height.length; i++){
            if(stack.isEmpty() || height[i] >= stack.peek())
                stack.push(height[i]);
            else{
                int count = 0;
                while(!stack.isEmpty() && stack.peek() > height[i]){
                    int num = stack.pop();
                    count++;
                    int area = num * count;
                    maxArea = Math.max(area, maxArea);
                }
                while(count >= 0){
                    stack.push(height[i]);
                    count--;
                }
            }
        }
        
        int count = 0;
        while(!stack.isEmpty()){
            int num = stack.pop();
            count++;
            int area = num * count;
            maxArea = Math.max(area, maxArea);
        }
        
       return maxArea;
        
    }
}