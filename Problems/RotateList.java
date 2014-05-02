 /**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * Solution: 
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null || n == 0)
			return head;
		
		ListNode last = head;
		int length = 1;
		while(last.next != null){
			last = last.next;
			length++;
		}
		
		if(n >= length)
			n = n % length;
		
		for(int i = length; i > (length - (length - n)); i--){
			last.next = head;
			last = last.next;
			head = head.next;
			last.next = null;
		}
		
		return head;
    }
}