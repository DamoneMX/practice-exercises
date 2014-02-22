/**
 * Given a linked list, swap every two adjacent nodes and return its head. 
 * Use only constant space. 
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
 *
 * Before Start: clarify, is list always an odd number???
 * Major Problems: compilation errors, overall good, ran first time after copied from draft
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        int i = 1; 
        ListNode previousNode = new ListNode(0);
        ListNode currentNode = head;

        while(currentNode != null && currentNode.next != null){
            if(i == 1)
                head = simpleSwap(currentNode);
            else{
                currentNode = swap(previousNode, currentNode);
                i++;
            }
            
            previousNode = currentNode;
            currentNode = currentNode.next;
            i++;
        }
    
        return head;    
    }
    
    //TODO: merge simpleSwap and swap
    public ListNode simpleSwap(ListNode node){
        ListNode temp;
        temp = node.next;
        node.next = node.next.next;
        temp.next = node;
        return temp;
    }
    
    public ListNode swap(ListNode previousNode, ListNode currentNode){
        ListNode temp;
        temp = currentNode;
        previousNode.next = currentNode.next;
        temp.next = previousNode.next.next;
        previousNode.next.next = temp;
        return temp;
    }
}
