 /**
 * Given a binary tree, determine if it is a valid binary search tree (BST). 
 * Assume a BST is defined as follows: 
 *     The left subtree of a node contains only nodes with keys less than the node's key.
 *     The right subtree of a node contains only nodes with keys greater than the node's key.
 *     Both the left and right subtrees must also be binary search trees.
 * 
 * Solution: Good problem for reviewing BST's
 * Recall that every node to the left of the root must be less than the root, 
 * right subtree of a node contains only nodes with keys greater than the node's key.
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
		if(root == null)
        	return true;
		
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public boolean isValidBST(TreeNode root, int minValue, int maxValue) {
		if(root.left != null)
        	if(root.val <= root.left.val || ((root.left.val <= minValue) || (root.left.val >= maxValue)))
        		return false;
        
        if(root.right != null)
        	if(root.val >= root.right.val || ((root.right.val <= minValue) || (root.right.val >= maxValue)))
        		return false;
        
        if(root.left != null)
        	if(!isValidBST(root.left, minValue, root.val))
        		return false;
        
        if(root.right != null)
        	if(!isValidBST(root.right, root.val, maxValue))
        		return false;
        
        return true;
    }

    //Version 2: Nov. 5 2014
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, int min, int max){
        if(root.val <= min)
            return false;
            
        if(root.val >= max)
            return false;
        
        if(root.left != null) {
            if(root.val < root.left.val) 
                return false;
            
            if(isValidBST(root.left, min, root.val) == false) 
                return false;
        }
        
        if(root.right != null) {
            if(root.val > root.right.val)
                return false;
            
            if(isValidBST(root.right, root.val, max) == false)
                return false;
        }
        
        return true;
    }
}
