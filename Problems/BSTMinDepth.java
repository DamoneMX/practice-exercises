/**
 * Given a binary tree, find its minimum depth.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BSTMinDepth {
    public int minDepth(TreeNode root) {
		if(root == null)
			return 0;
			
		return minDepth(root, 1);
    }
	
	public int minDepth(TreeNode node, int depth){
		if(node.left == null && node.right == null)
			return depth;
		
		int n1 = depth; 
		int n2 = depth;
		if(node.left != null)
			n1 = minDepth(node.left, depth + 1);
		
		if(node.right != null)
			n2 = minDepth(node.right, depth + 1);
		
		if(n1 == depth)
			return n2;
		
		if(n2 == depth)
			return n1;
		
		return Math.min(n1, n2);
	}

	//Same solution, different structure
    public int findMinDepth(TreeNode node, int currentDepth){
        if(node.left == null && node.right == null)
            return currentDepth;
            
        int leftDepth = Integer.MAX_VALUE;
        if(node.left != null)
            leftDepth = findMinDepth(node.left, currentDepth + 1);
            
        int rightDepth = Integer.MAX_VALUE;    
        if(node.right != null)
            rightDepth = findMinDepth(node.right, currentDepth + 1);
            
        int response = leftDepth;
        response = Math.min(response, rightDepth);
        return response;
    }

}