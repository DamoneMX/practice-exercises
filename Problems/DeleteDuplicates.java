/**
 * Problem: 
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 
 * Definition for singly-linked list. 
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while(current != null){

            ListNode check = current.next;
	    //Spent time on check.next nullcheck, if needed don't hesitate to add
            while(check != null && check.next != null && check.next.val == current.val) 
                check = check.next;
            
            if(check != null && current.val == check.val)
               current.next = check.next;
            
            current = current.next;
        }
        
        return head;
    }

    public ListNode deleteDuplicatesV2(ListNode head) {
        if(head == null)
            return head;
            
        if(head.next != null && head.val == head.next.val)
            head = head.next;
        
        ListNode beacon = head;
        while(beacon != null) {
            if(beacon.next != null && beacon.val != beacon.next.val) {
                beacon = beacon.next;
                continue;
            }
            
            if(beacon.next != null && beacon.val == beacon.next.val)
                beacon.next = beacon.next.next;
            
            if(beacon.next == null || beacon.val != beacon.next.val)
                beacon = beacon.next;
        }
        
        return head;
    }
}
