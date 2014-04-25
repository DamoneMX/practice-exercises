/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that 
 * adding up all the values along the path equals the given sum. 
 *
 *
 * Solution:
 * Medium difficulty problem.
 * Good Problem to review BST problems.
 */
public class Solution{

	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        
        int count = 0;
        return testPathSum(root, sum, count);
    }
    
    public boolean findPathSum(TreeNode node, int sum, int count){
        if(node.left == null && node.right == null){
            count += node.val;
            return (sum == count);
        }
        
        if(node.left != null)
            if(findPathSum(node.left, sum, count + node.val))
                return true;
        
        if(node.right != null)
            if(findPathSum(node.right, sum, count + node.val))
                return true;
        
        return false;
    }
}