/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 *
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        return convertToBST(num, 0, num.length - 1);
    }
    
    public TreeNode convertToBST(int[] array, int start, int end){
        if(end < start) return null;
        
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(array[mid]);
        node.left = convertToBST(array, start, mid - 1);
        node.right = convertToBST(array, mid + 1, end);
        return node;
    }
}
