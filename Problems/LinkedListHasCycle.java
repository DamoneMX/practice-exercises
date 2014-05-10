 /**
 * Given a linked list, determine if it has a cycle in it. 
 * 
 * Solution: LOW
 */
public class LinkedListHasCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
            
        ListNode runner = head;
        ListNode slowPace = head;
        
        while(true){
            if(runner.next == null || runner.next.next == null)
                return false;
                
            runner = runner.next.next;
            slowPace = slowPace.next;
            if(runner == slowPace)
                return true;
        }
    }
}
