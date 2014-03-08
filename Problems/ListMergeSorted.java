/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * 
 * Before Start: - Clarify if it's possible to have repeated elements in list.
 * 
 * Solution: 2 possible cases.
 * 1. You are inserting at the start of the list
 * 2. You are inserting somwehere else in the list.
 * 
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;
        while(pointer1 != null){
            if(pointer2 == null || pointer2.val > pointer1.val){
                l1 = pointer1.next;
                pointer1.next = pointer2;
                pointer2 = pointer1;
                pointer1 = l1;
                l2 = pointer2; //setting new head
            }
            else if(pointer2.next == null || pointer2.val < pointer1.val && pointer2.next.val > pointer1.val || pointer1.val == pointer2.val){
                ListNode temp = pointer1;
                pointer1 = pointer1.next;
                temp.next = pointer2.next;
                pointer2.next = temp;
                pointer2 = temp;
            }
            else
                pointer2 = pointer2.next;
        }
        
        return l2;
    }
}
