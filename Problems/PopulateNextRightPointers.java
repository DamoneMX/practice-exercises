/**
 *  Populating Next Right Pointers in Each Node     
 *  Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *  
 */
public class PopulateNextRightPointers{

    /**
     * Definition for binary tree with next pointer.
     * public class TreeLinkNode {
     *     int val;
     *     TreeLinkNode left, right, next;
     *     TreeLinkNode(int x) { val = x; }
     * }
     */

    //BFS, uses extra space
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        int level = 0;
        queue.add(root);
        TreeLinkNode prev = root;
        int count = 0;
        
        while(!queue.isEmpty()){
            TreeLinkNode curr = queue.poll();
            if(curr.left != null)
                queue.add(curr.left);
            
            if(curr.right != null)
                queue.add(curr.right);
            
            
            if(count == Math.pow(2, level)) {
                curr.next = null;
                level++;
                count = 0;
            } else {
                if(count > 0){
                    prev.next = curr;
                }
            }
            count++;
            prev = curr;
        }
    }

    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
            
        if(root.left != null) {
            if(root.right != null) {
                root.left.next = root.right;
            } else {
                TreeLinkNode temp = root.next;
                while(temp != null) {
                    if(temp.left != null){
                        root.left.next = temp.left;
                        break;
                    } else if(temp.right != null){
                        root.left.next = temp.right;
                        break;
                    } 
                    temp = temp.next;
                }   
            }
        }
        
        if(root.right != null) {
           TreeLinkNode temp = root.next;
                while(temp != null) {
                    if(temp.left != null){
                        root.right.next = temp.left;
                        break;
                    } else if(temp.right != null){
                        root.right.next = temp.right;
                        break;
                    } 
                    
                    temp = temp.next;
                }
        }
        
        if(root.right != null)
            connect(root.right);
            
        if(root.left != null)
            connect(root.left);   
        
    }
}