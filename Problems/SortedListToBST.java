 /**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * Solution: LOW
 */
public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
        	return null;
        
        int count = 1;
        ListNode actionNode = head;
        
        while(actionNode.next != null){
        	actionNode = actionNode.next;
        	count++;
        }
        
        ListNode last = actionNode;
        actionNode = head;
        
        return convertToBST(1, count, actionNode, last);
    }

	public TreeNode convertToBST(int start, int end, ListNode firstNode, ListNode lastNode){
		if(end < start)
			return null;
		
		int mid = (start + end) / 2;
		ListNode midNode = firstNode;
		int count = start;
		while(count < mid){
			midNode = midNode.next; 
			count++;
		}

		TreeNode newNode = new TreeNode(midNode.val);
		newNode.left = convertToBST(start, mid - 1, firstNode, lastNode);
		newNode.right = convertToBST(mid + 1, end, midNode.next, lastNode);
		
		return newNode;
	}
    
}
