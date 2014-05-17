/**
 *  Given inorder and preorder traversal of a tree, construct the binary tree.
 *  You may assume that duplicates do not exist in the tree. 
 *
 * Solution:
 * Medium difficulty
 * Recursive solution, to get right node of root you can generate right subtree first and so on.
 * Verify what characteristics hold for every postorder traversal of a tree (first element is always the root)
 */
public class BuildTreeInorderPreorder {
    //
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
            return null;
        
        return buildTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length -1);
    }
    
    public TreeNode buildTree(int[] inorder, int instart, int inend, int[] preorder, int prestart, int preend){
        if(instart > inend)
            return null;
        
        int rootValue = preorder[prestart];
        int inorderIndex = 0;
        for(; inorderIndex < inorder.length; inorderIndex++)
            if(inorder[inorderIndex] == rootValue)
                break;
        
        TreeNode root = new TreeNode(rootValue);
        
        int length = inorderIndex - instart;
        
        root.left = buildTree(inorder, instart, inorderIndex - 1, preorder, prestart + 1, prestart + length);
        root.right = buildTree(inorder, inorderIndex + 1, inend, preorder, prestart + 1 + length, preend);
        
        return root;
    }
}