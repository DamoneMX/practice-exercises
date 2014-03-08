import java.util.*;
public class SymmetricTree{

	public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 	}

	public boolean isSymmetric(TreeNode root){
		if(root == null) return true;
		if(root != null && root.right != null){
			LinkedList<Integer> register1 = new LinkedList<Integer>();			
			LinkedList<Integer> register2 = new LinkedList<Integer>();

			leftTraverse(root.left, register1);
			rightTraverse(root.right, register2);

			if(register1.size() != register2.size())
				return false;
			
			for(int i = 0; i < register1.size(); i++)
				if(register1.get(i) != register2.get(i))
					return false;

			return true;
		}
		
		return false;
	}

	public void leftTraverse(TreeNode node, LinkedList<Integer> register){
		if(node == null){
			register.add(null);
			return;
		}

		leftTraverse(node.left, register);
		rightTraverse(node.right, register);
	}
	
	public void rightTraverse(TreeNode node, LinkedList<Integer> register){
		if(node == null){
			register.add(null);
			return;
		}

		leftTraverse(node.right, register);
		rightTraverse(node.left, register);
	}
	
}
