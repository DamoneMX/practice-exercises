/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * 
 * Solution: 
 * Easier to do this in the same way, but only with 2 stacks.
 */
public class ZigzagLevelOrder{
	public ArrayList<ArrayList<Integer>> zigzagLevelOrderComplex(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null)
        	return result;
        
        Stack<TreeNode> currLevelStack = new Stack<TreeNode>();
        Queue<TreeNode> currLevelQueue = new LinkedList<TreeNode>();
        Stack<TreeNode> nextLevelStack = new Stack<TreeNode>();
        Queue<TreeNode> nextLevelQueue = new LinkedList<TreeNode>();
        
        boolean queue = true;
        ArrayList<Integer> levelNumbers = new ArrayList<Integer>();
        
        currLevelStack.push(root);
        currLevelQueue.add(root);
        
        
        while(!currLevelQueue.isEmpty()){
        	TreeNode node; 
        	TreeNode mock;
        	if(queue){
        		currLevelStack.pop();
        		node = currLevelQueue.poll();
        		mock = node;
        	}
        	else{
        		node = currLevelStack.pop();
        		mock = currLevelQueue.poll();
        	}
        	
        	if(mock.left != null){
        		nextLevelQueue.add(mock.left);
        		nextLevelStack.add(mock.left);
        	}
        	
        	
        	if(mock.right != null){
        		nextLevelQueue.add(mock.right);
        		nextLevelStack.add(mock.right);
        	}
        	
        	levelNumbers.add(node.val);
        	
        	if(currLevelQueue.isEmpty()){
        		queue = !queue;
        		result.add(levelNumbers);
        		currLevelStack = nextLevelStack;
        		currLevelQueue = nextLevelQueue;
        		nextLevelStack = new Stack<TreeNode>();
        		nextLevelQueue = new LinkedList<TreeNode>();
        		levelNumbers = new ArrayList<Integer>();
        	}
        	
        }
        
        return result;
    }
}