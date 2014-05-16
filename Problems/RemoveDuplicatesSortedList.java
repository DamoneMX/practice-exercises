/**
 * Follow up: 
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. 
 * Example: Given 1->2->3->3->4->4->5, return 1->2->5.
 */
public class RemoveDuplicatesSortedList {
    public ListNode deleteDuplicates(ListNode head){
        if(head == null)
            return head;
        
        ListNode trail = head;
        ListNode beacon = head;
        
        while(beacon != null){
            if(trail == beacon){
                if(beacon.next == null || beacon.val != beacon.next.val)
                    beacon = beacon.next;
                else{
                    while(true){
                        beacon = beacon.next;
                        trail = trail.next;
                        if(beacon.next == null || beacon.val != beacon.next.val){
                            head = beacon.next;
                            beacon = head;
                            trail.next = null;
                            trail = head;
                            break;
                        }
                    }
                }
            }
            else{
                if(beacon.next == null || beacon.val != beacon.next.val){
                    beacon = beacon.next;
                    trail = trail.next;
                }
                else{
                    while(true){
                        beacon = beacon.next;
                        if(beacon.next == null || beacon.val != beacon.next.val){
                            beacon = beacon.next;
                            trail.next = beacon;
                            break;
                        }
                    }
                }
            }
        }
        
        return head;
    }
}
