public class DynamicArrayStack{

	private String[] s;
	private int N = 0;

	//Simple implementation, user must tell size of stack, sample almost useless
	public DynamicArrayStack(){ 
		s = new String[2];
	}

	public boolean isEmpty(){
		return N == 0;	
	}

	public void push(String newItem){
		System.out.println("Pushing: " + newItem);
		
		if(N == s.length){
			resize(2 * s.length);
		}

		System.out.println("Array current length: " + s.length);

		s[N++] = newItem;			
		
	}

	public String pop(){
		System.out.println("Popping: " + s[--N]);
		
		if(s.length/4 == N){
			resize(s.length / 2);
			System.out.println("New size of array: " + s.length);
		}


		return s[N];
	}

	public void resize(int capacity){
		String[] copy = new String[capacity];
		for(int i = 0; i < N;i++)
			copy[i] = s[i];
		s = copy;
	}
	
	public static void main(String[] args){
		System.out.println("Sample Stack");
		DynamicArrayStack stack = new DynamicArrayStack();	
		stack.push("this");
		stack.push("word");
		stack.push("counts");
		stack.push("fourtj");
		stack.push("final");
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println(stack.isEmpty());
	}

}
