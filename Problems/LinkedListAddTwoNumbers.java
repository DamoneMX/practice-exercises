/*
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 * Solution: straightforward, medium difficulty
 */
public class LinkedListAddTwoNumbers{
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		int sum = 0;
		ListNode newStart = new ListNode(0);
		ListNode newHead = newStart;
		
		while(l1 != null || l2 != null){
			if(l1 != null)
				sum += l1.val;
			if(l2 != null)
				sum += l2.val;
			
			if(carry != 0){
				sum += carry;
				carry = 0;
			}
			
			sum += carry;
			
			if(sum >= 10){
				carry = 1;
				sum -= 10;
			}
			
			ListNode newNode = new ListNode(sum);
			newStart.next = newNode;
			newStart = newStart.next;
			
			sum = 0;
			
			if(l1 != null)
				l1 = l1.next;
			if(l2 != null)
				l2 = l2.next;
		}
		
		if(carry != 0){
			ListNode newNode = new ListNode(carry);
			newStart.next = newNode;
			newStart = newStart.next; 
		}
		
		return newHead.next;
		
    }
}