/**
 *  Given a binary tree, determine if it is height-balanced.
 *  For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        
        int leftHeight = 1;
        if(root.left != null)
            leftHeight = calculateHeight(root.left, 2);
        
        int rightHeight = 1;
        if(root.right != null) 
            rightHeight = calculateHeight(root.right, 2);
            
        if((rightHeight == -1 || leftHeight == -1) || Math.abs(leftHeight - rightHeight) > 1)
            return false;
            
        return true;
    }
    
    public int calculateHeight(TreeNode node, int currentHeight){
        int leftHeight = currentHeight;
        if(node.left != null)
            leftHeight = calculateHeight(node.left, currentHeight + 1);
            
        int rightHeight = currentHeight;
        if(node.right != null)
            rightHeight = calculateHeight(node.right, currentHeight + 1);
            
        if(leftHeight == -1 || rightHeight == -1)
            return -1;
            
        int difference = Math.abs(leftHeight - rightHeight);
        if(difference > 1)
            return -1;
            
        return Math.max(leftHeight, rightHeight);    
    }
}