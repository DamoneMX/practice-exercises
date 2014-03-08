public class LinkedStackOfStrings{

	private Node first = null;

	private class Node{
		String item;
		Node next;
	}

	public boolean isEmpty(){
		return first == null;	
	}

	public void push(String newItem){
		System.out.println("Pushing: " + newItem);
		Node oldFirst = first;
		first = new Node();
		first.item = newItem;
		first.next = oldFirst;
	}

	public String pop(){
		String item = first.item;
		first = first.next;
		System.out.println("Pop Operation: " + item);
		return item;
	}

	public static void main(String[] args){
		System.out.println("Sample Stack");
		LinkedStackOfStrings stack = new LinkedStackOfStrings();
		stack.push("1");
		stack.push("2");
		stack.pop();
		stack.pop();
		//stack.pop();
		System.out.println(stack.isEmpty());
	}

}
