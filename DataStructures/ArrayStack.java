public class ArrayStack{

	private String[] s;
	private int N = 0;

	//Simple implementation, user must tell size of stack, sample almost useless
	public ArrayStack(int capacity){ 
		s = new String[capacity];
	}

	public boolean isEmpty(){
		return N == 0;	
	}

	public void push(String newItem){
		System.out.println("Pushing: " + newItem);
		
		if(N++ > s.length){
			N--;
			System.out.println("Array has reached capacity");
			return;
		}
		else
			s[N] = newItem;			
		
	}

	public String pop(){
		if(isEmpty()){
			System.out.println("Stack is empty");
			return "null";
		}
		else{
			System.out.println("Popping: " + s[N--]);
			return s[N];
		}
	}
	
	public static void main(String[] args){
		System.out.println("Sample Stack");
		ArrayStack stack = new ArrayStack(5);
		stack.pop();
		stack.push("this");
		stack.push("word");
		stack.push("counts");
		stack.pop();
		stack.pop();
		stack.pop();
		//stack.pop();
		System.out.println(stack.isEmpty());
	}

}
