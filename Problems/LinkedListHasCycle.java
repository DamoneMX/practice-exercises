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

    //Follow up: 
    //Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
    public static ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        
        //find out if there is a loop
        ListNode seeker = head;
        ListNode runner = head;
        ListNode loopNode = null;
        
        while(runner.next != null && runner.next.next != null){
            seeker = seeker.next;
            runner = runner.next.next;
            if(seeker == runner){
                loopNode = seeker;
                break;
            }
        }
        
        if(loopNode == null)
            return null;

        //count how many nodes are part of the loop
        seeker = loopNode.next;
        int count = 2;
        while(true) {
            seeker = seeker.next;
            if(seeker == loopNode){ 
                break;
            } else {
                count++;
            }
        }
    
        //start two pointers, one from head, the other one at kth node from head
        //move them at same pace, they'll meet at the place where the loop starts
        
        //place seeker at kth steps from start
        seeker = head;
        for(int i = 1; i <= count; i++){
            seeker = seeker.next;
        }
        
        
        runner = head;
        while(true){
            if(seeker == runner)
                return seeker;
            else {
                seeker = seeker.next;
                runner = runner.next;
            }
        }
    }

}
