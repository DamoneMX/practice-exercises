/**
 *  Given inorder and postorder traversal of a tree, construct the binary tree.
 *  You may assume that duplicates do not exist in the tree. 
 *
 * Solution:
 * Medium difficulty
 * Recursive solution, to get right node of root you can generate right subtree first and so on.
 * Verify what characteristics hold for every postorder traversal of a tree (last element is always the root)
 */
public class BuildTreeInorderPostorder {
    //
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0)
            return null;
        
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    public TreeNode buildTree(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd){
        if(inorderStart > inorderEnd || postorderStart > postorderEnd)
            return null;
        
        int rootVal = postorder[postorderEnd];
        
        int inordIndex = 0;
        for(; inordIndex <= inorder.length - 1; inordIndex++)
            if(inorder[inordIndex] == rootVal)
                break;
            
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(inorder, inorderStart, inordIndex - 1, postorder, postorderStart, postorderStart + inordIndex - (inorderStart + 1));
        root.right = buildTree(inorder, inordIndex + 1, inorderEnd, postorder, postorderStart + inordIndex - inorderStart, postorderEnd - 1);
        
        return root;
    }
    }
}