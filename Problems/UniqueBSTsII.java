 /**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * 
 * Solution: 
 * Tricky cases
 */
public class UniqueBSTsII {
    public ArrayList<TreeNode> generateTrees(int n) {
        ArrayList <TreeNode> result = new ArrayList<TreeNode>();
        if(n == 0){
            result.add(null);
            return result;
        }
        result = generateTrees(1, n);
        return result;
    }
    
    public ArrayList<TreeNode> generateTrees(int start, int end){
        ArrayList<TreeNode> results = new ArrayList<TreeNode>();
        if(start == end){
            TreeNode root = new TreeNode(start);
            results.add(root);
            return results;
        }
        
        for(int i = start; i <= end; i++){
            ArrayList<TreeNode> leftSubtrees = new ArrayList<TreeNode>();
            ArrayList<TreeNode> rightSubtrees = new ArrayList<TreeNode>();
            if( ((i - 1) - start) >= 0){
                leftSubtrees = generateTrees(start, i - 1);
            }
            
            if((i + 1) <= end){
                rightSubtrees = generateTrees(i + 1, end);
            }
            
            if(leftSubtrees.size() > 0){
                for(TreeNode child : leftSubtrees){
                    
                    if(rightSubtrees.size() == 0){
                         TreeNode root = new TreeNode(i);
                            root.left = child;
                        results.add(root);
                    }
                    else{
                        for(TreeNode rightChild : rightSubtrees){
                            TreeNode root = new TreeNode(i);
                            root.left = child;
                            root.right = rightChild;
                            results.add(root);
                        }
                    }
                    
                }
            }
            else{
                for(TreeNode rightChild : rightSubtrees){
                    TreeNode root = new TreeNode(i);
                    root.right = rightChild;
                    results.add(root);
                }
            }
        }
        
        return results;
    }
}
