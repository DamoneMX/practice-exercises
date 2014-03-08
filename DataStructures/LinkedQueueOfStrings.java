public class LinkedQueueOfStrings{

	private Node first = null;
	private Node last  = null;

	private class Node{
		String item;
		Node next;
	}

	public boolean isEmpty(){
		return first == null;	
	}

	public void enqueue(String newItem){
		System.out.println("Pushing: " + newItem);
		if(first == null){
			Node node = new Node();
			node.item = newItem;
			node.next = null;
			first = node;
			last = node;
		}
		else{							
			Node oldLast = last;
			last = new Node();
			last.item = newItem;
			oldLast.next = last;
		}

	}

	public String dequeue(){
		String item = first.item;
		first = first.next;
		if(isEmpty()) last = null;
		System.out.println("Pop Operation: " + item);
		return item;
	}

	public static void main(String[] args){
		System.out.println("Sample Stack");
		LinkedQueueOfStrings queue = new LinkedQueueOfStrings();
		queue.enqueue("fisrt");
		queue.enqueue("word");
		queue.dequeue();
		queue.dequeue();
		System.out.println(queue.isEmpty());
	}

}
