/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x. 
 * You should preserve the original relative order of the nodes in each of the two partitions. 
 *
 * Solution: 
 * Medium low difficulty
 *
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null)
            return head;
        
        ListNode current = head;
        ListNode list1 = new ListNode(0);
        ListNode list2 = new ListNode(1);
        ListNode current1 = list1;
        ListNode current2 = list2;
        
        while(current != null){
            if(current.val < x){
                current1.next = current;
                current = current.next;
                current1 = current1.next;
                current1.next = null;
            }
            else{
                current2.next = current;
                current = current.next;
                current2 = current2.next;
                current2.next = null;
            }
        }
        
        if(list1.next == null){
            list1 = list2.next;
        }
        else{
            current1.next = list2.next;
            list2.next = null;
            list1 = list1.next;
        }

        return list1;
        
    }
}
