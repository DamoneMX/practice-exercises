 /**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 */
public class MergeTwoSortedLists {

    public int MergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
            
        if(l2 == null)
            return l1;
            
        ListNode tempHead = new ListNode(-1);
        ListNode beacon = tempHead;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val) {
                beacon.next = l1;
                l1 = l1.next;
            } else {
                beacon.next = l2;
                l2 = l2.next;
            }
            
            beacon = beacon.next;
            beacon.next = null;
        }
        
        if(l1 != null)
            beacon.next = l1;
        
        if(l2 != null)
            beacon.next = l2;
        
        return tempHead.next;
    }

}
