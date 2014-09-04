/**
 * Sort a linked list using insertion sort.
 */
public class InsertionSortList {
    
    class ListNode {
        public int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }   
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode h1 = sol.new ListNode(3);
        ListNode el1 = sol.new ListNode(4);
        ListNode el2 = sol.new ListNode(1);
        ListNode el3 = sol.new ListNode(4);
        
        h1.next = el1;
        el1.next = el2;
        //el2.next = el3;

        h1 = insertionSortList(h1);
        
        while(h1 != null) {
            System.out.println(h1.val);
            h1 = h1.next;
        }
        
    }

    //Solution with only one list, Times out because it uses a stack and pops and pushes all the nodes every time
    public static ListNode insertionSortList(ListNode head) {
        ListNode start = head;
        if(head == null)
            return head;
        
        Stack<ListNode> stack = new Stack<ListNode>();
        
        while(start != null) {
            ListNode current = start;
            
            start = start.next;
            if(stack.isEmpty() || stack.peek().val < current.val) {
                stack.push(current);
                //start = start.next;
            } else {
                ListNode analyze = stack.pop();
                ListNode behind = analyze;
                while(stack.isEmpty() == false && analyze.val > current.val){
                    analyze = stack.pop();
                }
                
                behind.next = current.next;
                if(analyze.val == head.val && analyze.val > current.val) { //we need to insert at the head
                    //System.out.println("did this");
                    if(analyze == behind)
                        analyze.next = current.next;
                    current.next = analyze;
                    head = current;
                    //System.out.println(head.val + "fdsafsd");
                } else {
                    //System.out.println("did this not");
                    current.next = analyze.next;
                    analyze.next = current;
                    analyze = current;
                }
                
                //start = start.next;
                while(current != null && current != start) {
                    stack.push(current);
                    current = current.next;
               }   
           }   
    }

    //Program Creek Solution, Create a new list an sort with this one
    public static ListNode insertionSortList(ListNode head) {
 
        if (head == null || head.next == null)
            return head;
 
        ListNode newHead = new ListNode(head.val);
        ListNode pointer = head.next;
 
        // loop through each element in the list
        while (pointer != null) {
            // insert this element to the new list
 
            ListNode innerPointer = newHead;
            ListNode next = pointer.next;
 
            if (pointer.val <= newHead.val) {
                ListNode oldHead = newHead;
                newHead = pointer;
                newHead.next = oldHead;
            } else {
                while (innerPointer.next != null) {
 
                    if (pointer.val > innerPointer.val && pointer.val <= innerPointer.next.val) {
                        ListNode oldNext = innerPointer.next;
                        innerPointer.next = pointer;
                        pointer.next = oldNext;
                    }
 
                    innerPointer = innerPointer.next;
                }
 
                if (innerPointer.next == null && pointer.val > innerPointer.val) {
                    innerPointer.next = pointer;
                    pointer.next = null;
                }
            }
 
            // finally
            pointer = next;
        }
 
        return newHead;
    }
}
