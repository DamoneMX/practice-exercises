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

    //Version 2 -> nov 22, 2014
    public TreeNode sortedArrayToBST(int[] num) {
        if(num.length == 0) {
            return null;
        }
        
        TreeNode root = convert(num, 0, num.length - 1);
        return root;        
    }
    
    public TreeNode convert(int[] num, int start, int end) {
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(num[mid]);
        
        if(mid - 1 >= start) {
            node.left = convert(num, start, mid - 1);
        }
        
        if(mid + 1 <= end) {
            node.right = convert(num, mid + 1, end);
        }
        
        return node;
    }
}
