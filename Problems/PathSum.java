/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that 
 * adding up all the values along the path equals the given sum. 
 *
 * Follow Up:  Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum. 
 * Method : pathSum
 * 
 * Solution:
 * Medium difficulty problem.
 * Good Problem to review BST problems.
 */
public class Solution{

	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        
        int count = 0;
        return testPathSum(root, sum, count);
    }
    
    public boolean findPathSum(TreeNode node, int sum, int count){
        if(node.left == null && node.right == null){
            count += node.val;
            return (sum == count);
        }
        
        if(node.left != null)
            if(findPathSum(node.left, sum, count + node.val))
                return true;
        
        if(node.right != null)
            if(findPathSum(node.right, sum, count + node.val))
                return true;
        
        return false;
    }


    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        getPathSum(root, new ArrayList<Integer>(),  result, sum);
        return result;
    }
    
    public void getPathSum(TreeNode node, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result, int sum){
        if(node.left == null && node.right == null){
            int total = 0;
            for(Integer number : path){
                total += number;
            }
            
            total += node.val;
            if(total == sum){
                path.add(node.val);
                result.add(path);
            }
            
            return;
        }
        
        
        if(node.left != null){
            ArrayList<Integer> copy = new ArrayList<Integer>();
            copy.addAll(path);
            getPathSum(node.right, copy,result, sum);
        }
            
        if(node.right != null){
            ArrayList<Integer> copy = new ArrayList<Integer>();
            copy.addAll(path);
            getPathSum(node.right, copy,result, sum);
        } 
    }

}