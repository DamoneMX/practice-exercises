//Same solution but with a doubly linked list
//reduces expelLRU operation to O(1)
//create methods for inserting head and remove node, keeps the code clean
public class LRUCache {
    private HashMap<Integer, DoubleLinkedListNode> map 
        = new HashMap<Integer, DoubleLinkedListNode>();
    private DoubleLinkedListNode head;
    private DoubleLinkedListNode end;
    private int capacity;
    private int len;
 
    public LRUCache(int capacity) {
        this.capacity = capacity;
        len = 0;
    }
 
    public int get(int key) {
        if (map.containsKey(key)) {
            DoubleLinkedListNode latest = map.get(key);
            removeNode(latest);
            setHead(latest);
            return latest.val;
        } else {
            return -1;
        }
    }
 
    public void removeNode(DoubleLinkedListNode node) {
        DoubleLinkedListNode cur = node;
        DoubleLinkedListNode pre = cur.pre;
        DoubleLinkedListNode post = cur.next;
 
        if (pre != null) {
            pre.next = post;
        } else {
            head = post;
        }
 
        if (post != null) {
            post.pre = pre;
        } else {
            end = pre;
        }
    }
 
    public void setHead(DoubleLinkedListNode node) {
        node.next = head;
        node.pre = null;
        if (head != null) {
            head.pre = node;
        }
 
        head = node;
        if (end == null) {
            end = node;
        }
    }
 
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            DoubleLinkedListNode oldNode = map.get(key);
            oldNode.val = value;
            removeNode(oldNode);
            setHead(oldNode);
        } else {
            DoubleLinkedListNode newNode = 
                new DoubleLinkedListNode(key, value);
            if (len < capacity) {
                setHead(newNode);
                map.put(key, newNode);
                len++;
            } else {
                map.remove(end.key);
                end = end.pre;
                if (end != null) {
                    end.next = null;
                }
 
                setHead(newNode);
                map.put(key, newNode);
            }
        }
    }
}
 
class DoubleLinkedListNode {
    public int val;
    public int key;
    public DoubleLinkedListNode pre;
    public DoubleLinkedListNode next;
 
    public DoubleLinkedListNode(int key, int value) {
        val = value;
        this.key = key;
    }
}


//simplest implementation, works but times out
//expelLRU takes too long
public class LRUCache {
    
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	LinkedList<Integer> list = new LinkedList<Integer>();
	int capacity = 0;
	int count = 0;
	
	
    public LRUCache(int capacity) {
       this.capacity = capacity;
    }
    
    public int get(int key) {
    	if(map.get(key) == null)
    		return -1;
    	
    	int value = map.get(key);
    	return value;
    }
    
    public void set(int key, int value) {
        if(get(key) == -1) {
        	if(count == capacity){
        		expelLRU();
        	}
        	
        	map.put(key, value);
        	list.addFirst(key);
        	count++;
        } else {
        	map.put(key,value);
        	for(int i = 0; i < list.size(); i++) {
        		if(list.get(i) == key) {
        			list.remove(i);
        			break;
        		}
        	}
        	list.addFirst(key);
        }
    }
    
    public int expelLRU(){
    	if(count == 0)
    		return -1;
    	
    	int val = list.removeLast();
    	map.remove(val);
    	count--;
    	return val;
    }
}