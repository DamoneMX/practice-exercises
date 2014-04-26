/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * Solution:
 * Medium difficulty problem.
 * Good Problem to review BST problems, similar to Path Sum.
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        
        int sum = 0;
        sum += sumNumbers(sum, 0, root);
        
        return sum;
    }
    
    public int sumNumbers(int sum, int current,TreeNode node){
        current += node.val;
        if(node.left == null && node.right == null){
            return current;
        }
        
        if(node.left != null)
            sum += sumNumbers(0, current * 10, node.left);
        
        if(node.right != null)
            sum += sumNumbers(0, current * 10, node.right);
        
        return sum;
    }   
}