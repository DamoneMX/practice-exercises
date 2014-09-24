/**
 * Problem: 
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 */
public class MergeKSortedLists {


    //Divide and conquer solution, modifying one list
    //Better to sort lists 2 by 2 then merge    
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists.size() == 0)
            return null;
            
        if(lists.size   () == 1)
            return lists.get(0);
            
        ListNode newHead = new ListNode(0);
        ListNode current = newHead;
        
        ListNode n1 = lists.get(0);
        ListNode n2 = lists.get(1);
        lists.remove(0);
        lists.remove(0);
        
        while(n1 != null && n2 != null) {
            if(n1.val < n2.val){
                current.next = n1;
                n1 = n1.next;
            } else if(n2.val < n1.val) {
                current.next = n2;
                n2 = n2.next;
            } else {
                current.next = n1;
                n1 = n1.next;
            }
            
            current = current.next;
        }
        
        if(n1 != null)
            current.next = n1;
        
        if(n2 != null)
            current.next = n2;
        
        lists.add(0, newHead.next);
        
        return mergeKLists(lists);
    }

    //Solution with priority queue(Min heap)
    public static ListNode mergeKListsMinHeap(ArrayList<ListNode> lists){
        if(lists.size() == 0)
            return null;
        
        Comparator<ListNode> comp = new Comparator<ListNode>(){
            @Override
            public int compare(ListNode n1, ListNode n2){
                return n1.val - n2.val;
            }
        };
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(lists.size(), comp);
        
        HashMap<ListNode, Integer> map = new HashMap<ListNode, Integer>();
        
        Solution sol = new Solution();
        Solution.ListNode newHead = sol.new ListNode(0);
        ListNode current = newHead;
        //System.out.println(lists.size()  + "fdsafsd");
        for(int i = 0; i < lists.size(); i++) {
                ListNode temp = lists.get(i);
                lists.add(i, temp.next);
                lists.remove(i + 1);
                
                minHeap.add(temp);
                map.put(temp, i);
                
        }
        //System.out.println(lists.size() + "fdsafsd");
        
        
        while(!minHeap.isEmpty()) {
            ListNode temp = minHeap.remove();
            current.next = temp;
            current = current.next;
            int i = map.get(temp);
            map.remove(temp);
            if(lists.get(i) != null) {
                ListNode temp1 = lists.get(i);
                minHeap.add(temp1);
                map.put(temp1 , i);
                lists.add(i, temp1.next);
                lists.remove(i + 1);
            }
            //System.out.println("acads");
        }
        
        ListNode head = newHead;
        while(head != null){
            //System.out.println(head.val + "val");
            head = head.next;
        }
        
        //System.out.println(newHead.val);
        return newHead;
    }


    public static void main(String[] args) {
        ArrayList<ListNode> test = new ArrayList<ListNode>();
        Solution sol = new Solution();
        
        Solution.ListNode t = sol.new ListNode(0);
        Solution.ListNode t1 = sol.new ListNode(2);
        t.next = t1;
        Solution.ListNode t2 = sol.new ListNode(5);
        t1.next = t2;
        test.add(t1);
        Solution.ListNode t4 = sol.new ListNode(0);
        Solution.ListNode t5 = sol.new ListNode(2);
        t4.next = t5;
        Solution.ListNode t6 = sol.new ListNode(5);
        t5.next = t6;
        test.add(t4);
        
        while(t != null){
            System.out.println(t.val);
            t = t.next;
        }
        
        ListNode head = mergeKLists(test);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
           
    }   

}
