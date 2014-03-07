/**
 * Given a binary tree, find its maximum depth.
 *
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Sol: height = max depth, however track edge case which is empty bst (missed on 1st try)
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        int height = height(root);
        if(height == -1)
            return 0;
        
        return height;
    }
    
    public int height(TreeNode root){
        if(root == null) return -1;
        
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
