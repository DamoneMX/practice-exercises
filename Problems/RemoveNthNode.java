/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Given n will always be valid, do this in one pass. 
 * 
 * Solution: Medium difficulty, edge cases are extremely important
 **/
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode beacon = head;
        int stepsTaken = 1;
        ListNode prevToRemove = head;
        
        while(beacon != null){
        	beacon = beacon.next;
        	if(stepsTaken > (n + 1))
        		prevToRemove = prevToRemove.next;
        	
        	stepsTaken++;
        }
        
       if(beacon == null && prevToRemove.next == null && n == 1){ //one element list
        	head = null;
        	return head;
        }
        
        if(prevToRemove == head && prevToRemove.next.next == null && n==1){ //2 element list
        	prevToRemove.next = null;
        	return head;
        }
        
        if(prevToRemove == head && prevToRemove.next.next == null && n == 2){ //2 element list
        	head = head.next; 
        	return head;
        }

        if(n == (stepsTaken - 1)){ //n means we have to Remove head
        	head = head.next;
        }
        else{
        	prevToRemove.next = prevToRemove.next.next; //simplest case, prevToRemove is node before the one we are removing
        }
        return head;
    }
}