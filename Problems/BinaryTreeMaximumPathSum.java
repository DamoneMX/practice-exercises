/**
 *  Given a binary tree, find the maximum path sum.
 *  The path may start and end at any node in the tree. 
 */
public class BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;
	
	public int maxPathSum(TreeNode root) {
		if(root == null)
			return 0;
		
		findMax(root);
		return max;
	}
	
	public void findMax(TreeNode node){
		int leftVal = 0;
		if(node.left != null){
			findMax(node.left);
			leftVal += node.left.val;
		}
		
		int rightVal = 0;
		if(node.right != null){
			findMax(node.right);
			rightVal += node.right.val;
		}
		
		int leftSum = node.val + leftVal;
		int rightSum = node.val + rightVal;
		int totalSum = node.val + leftVal + rightVal;
		int originalVal = node.val;
		int val = Math.max(leftSum, rightSum);
		//val = Math.max(totalSum, val);
		val = Math.max(val, originalVal);
		
		if(val > max)
			max = val;
			
		if(totalSum > max)
		    max = totalSum;
		
		node.val = val;
	}
}