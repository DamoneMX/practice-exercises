 /**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * 
 * Solution: 
 * Determine number of trees left subtree can generate * number of tree right subtree can generate
 */
public class UniqueBSTs {
    public int numTrees(int n) {
        if(n == 0 || n == 1)
            return 1;
        if(n == 2)
            return 2;
        
        int count = 0;
        for(int i = 1; i <= n; i++){
            int left = i - 1;
            int right = n - i;
            count += numTrees(left) * numTrees(right); //combinations you can have in left subtree and right subtree
        }
        
        return count;  
    }

    public static void main(String[] args){
        System.out.println(numTrees(3));
    }
}
