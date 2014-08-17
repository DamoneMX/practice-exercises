/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BSTMinDepth {
    public void recoverTree(TreeNode root) {
        TreeNode previous = null;
        TreeNode firstError = null;
        TreeNode secondError = null;
        inOrderCheck(root, previous, firstError, secondError);
     
	        int temp = firstError.val;
	        firstError.val = secondError.val;
	        secondError.val = temp;
        
        
    }
	
	public void inOrderCheck(TreeNode node, TreeNode previous, TreeNode firstError, TreeNode secondError){
		if(node == null)
			return;
		
		inOrderCheck(node.left, previous, firstError, secondError);
		if(previous != null) {
			if(previous.val > node.val) {
				firstError = previous;
			}
			secondError = node;
		}
		inOrderCheck(node.right, previous, firstError, secondError);
		
	}
}