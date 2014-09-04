/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 */
public class Solution {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(k == 0 || head == null || head.next == null)
            return head;
        
        int length = 0;
        ListNode start = head;
        while(start != null) {
            start = start.next;
            length++;
        }
        start = head;
        
        if(k > length)
            return head;
        
        int groups = length / k;
        int currGroup = 1;
        
        ListNode previous = start;
        ListNode current = start;
        ListNode ahead = start;
        ListNode reverseHead = start;
        ListNode reverseTail = start;
        
        while(currGroup <= groups) {            
            if(currGroup == 1){
                previous = getAheadNode(k, previous);
                current = reverseKNodes(current, k, reverseHead, reverseTail);
                head = current;
                for(int i = 1; i < k; i++)
                    current = current.next;
                current.next = previous;
                previous = current;
                current = current.next; //added this
            } else {
                ahead = current;
                ahead = getAheadNode(k, ahead);
                previous.next = ahead;
                current = reverseKNodes(current, k, reverseHead, reverseTail);
                previous.next = current;
                for(int i = 1; i < k; i++)
                    current = current.next;
                current.next = ahead;
                
                previous = current; //??
                if(current != null) //if it's last node then don't do anything
                    current = current.next;
            }
            
            currGroup++;
        }       
        
        return head;
    }
    
    public static ListNode getAheadNode(int steps, ListNode currentNode){
        for(int i = 0; i < steps; i++) {
            currentNode = currentNode.next;
        }
        
        return currentNode;
    }
    
    public static ListNode reverseKNodes(ListNode current, int k, ListNode holder, ListNode tail) {
        int processed = 0;
        tail = null;
        while(processed < k) {
            holder = current;
            current = current.next;
            holder.next = tail;
            tail = holder;
            processed++;
        }
        
        return holder;
    }

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
        ListNode h1 = sol.new ListNode(1);
        ListNode el1 = sol.new ListNode(2);
        ListNode el2 = sol.new ListNode(3);
        ListNode el3 = sol.new ListNode(4);
        ListNode el4 = sol.new ListNode(5);
        
        h1.next = el1;
        el1.next = el2;
        el2.next = el3;
        el3.next = el4;
        
        h1 = reverseKGroup(h1, 3);
        
        while(h1 != null) {
            System.out.println("node: " +  h1.val);
            h1 = h1.next;
        }
    }
}
