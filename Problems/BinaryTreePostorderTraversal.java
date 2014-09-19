/**
 *  Given a binary tree, return the postorder traversal of its nodes' values.
 *  Recursive solution is trivial, could you do it iteratively? 
 *
 * Solution:
 * This is a version that modifies the original tree, it modifies in order to mark the paths already visited
 * this can also be achieved by using a node that keeps track of the last visited node
 */
public class BinaryTreePostorderTraversal{
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return result;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = null;
        stack.push(root);
        while(true){
            if(node == null){
                node = stack.pop();
            }
            else if(node.left != null){
                stack.push(node);
                stack.push(node.left);
                node.left = null;
                node = stack.pop();
            }
            else if(node.right != null){
                stack.push(node);
                stack.push(node.right);
                node.right = null;
                node = stack.pop();
            }
            else{
                result.add(node.val);
                if(stack.isEmpty())
                    break;
                node = stack.pop();
            }
        }
        
        return result;
    }

    public ArrayList<Integer> preorderTraversalV2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty()) {
            TreeNode currNode = stack.pop();
            if(currNode.right != null){
                stack.push(currNode.right);
            }
            
            if(currNode.left != null) {
                stack.push(currNode.left);
            }
            
            result.add(currNode.val);
        }
        
        return result;
    }
}