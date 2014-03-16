/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<Tree>();
	ArrayList<Integer> result = new ArrayList<Integer>();

	stack.push(root);
	while(stack.peek() != null){
		if(node != null){
			stack.push(node.left);
			node = node.left;
		}
		else{
			node = stack.pop();
			result.add(node.val);
			stack.push(node.right);
			node = node.right;
		}

		//Everytime you pop you push the right child
	}

	return result;
 
    }
}
