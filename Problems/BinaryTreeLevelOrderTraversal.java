/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 */
public class BinaryTreeLevelOrderTraversal {

	//Version 2: BFS
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return result;
            
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        ArrayList<Integer> level = new ArrayList<Integer>();
        while(queue.isEmpty() == false) {
            TreeNode node = queue.poll();
            if(node == null) { //we have changed levels, add to results
                //if queue is not empty
                if(queue.isEmpty() == false){
                    queue.add(null);
                }
                result.add(level);
                level = new ArrayList<Integer>();
            } else{
                level.add(node.val);
                
                if(node.left != null)
                    queue.add(node.left);
                
                if(node.right != null)
                    queue.add(node.right);
            }
        }
        
        return result;
    }

    /*
	 * Level Order Traversal implemented using BFS and 1 Queue, 
	 * Same as 2 Queues solutions, But null elements represent we are moving on to next level
	 */
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(root == null)
			return result;
		
		Queue<TreeNode> visited = new LinkedList<TreeNode>();
		visited.add(root);
		visited.add(null);
		ArrayList<Integer> levelNumbers = new ArrayList<Integer>();
		while(!visited.isEmpty()){
			TreeNode node = visited.poll();
			if(node != null){
				levelNumbers.add(node.val);
				if(node.left != null)
					visited.add(node.left);
				
				if(node.right != null)
					visited.add(node.right);
				
				
			}
			else{
				result.add(levelNumbers);
				visited.add(null);
				if(visited.size() == 1)
					break;
				levelNumbers = new ArrayList<Integer>();
			}
		}
		
		return result;
	}
	
	/*
	 * Level Order Traversal implemented using BFS and 2 Queues
	 */
	public ArrayList<ArrayList<Integer>> levelOrder2(TreeNode root) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if(root == null)
			return results;
		
		Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
		Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
		
		currentLevel.add(root);
		
		ArrayList<Integer> levelValues = new ArrayList<Integer>();
		
		while(!currentLevel.isEmpty()){
			TreeNode node = currentLevel.poll();
			
			if(node.left != null)
				nextLevel.add(node.left);
			
			if(node.right != null)
				nextLevel.add(node.right);
			
			levelValues.add(node.val);
			
			if(currentLevel.isEmpty()){
				currentLevel = nextLevel;
				nextLevel = new Queue<TreeNode>();
				results.add(levelValues);
				levelValues = new ArrayList<Integer>();
			}
		}
		
		return results;
    }


	/*
	 * Follow up: 
	 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
	 * (ie, from left to right, level by level from leaf to root).
	 * Solution: Several ways to do this, using stack in this solution
	 * Replaced on Oct/15/2014
	 */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();
        if(root == null)
            return result;
            
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        ArrayList<Integer> level = new ArrayList<Integer>();
        while(queue.isEmpty() == false) {
            TreeNode node = queue.poll();
            if(node == null) { //we have changed levels, add to results
                //if queue is not empty
                if(queue.isEmpty() == false){
                    queue.add(null);
                }
                stack.add(level);
                level = new ArrayList<Integer>();
            } else{
                level.add(node.val);
                
                if(node.left != null)
                    queue.add(node.left);
                
                if(node.right != null)
                    queue.add(node.right);
            }
        }
        
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        
        return result;
    }
}