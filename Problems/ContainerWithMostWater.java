/**
 *  Given a binary tree, return the postorder traversal of its nodes' values.
 *  Recursive solution is trivial, could you do it iteratively? 
 *
 * Solution:
 * This is a version that modifies the original tree, it modifies in order to mark the paths already visited
 * this can also be achieved by using a node that keeps track of the last visited node
 */
public class ContainerWithMostWater{
    public int maxArea(int[] height) {
		  int max = 0;
		  int i = 0;
		  int j = height.length - 1;

		  while(i < j){
		    int area = (j-i) * (Math.min(height[i], height[j]));
		    if(area > max)
		    	max = area;
		    if(height[i] < height[j]) 
		    	i++;
		    else 
		    	j--;
		  }

		  return max;
	}
}