public class BinaryHeap{

	public int[] heap;
	private int N;

	public BinaryHeap(int capacity){
		heap = new int[capacity];
		N = 0;
	}

	public boolean isEmpty(){
		return N == 0;
	}

	//we set N to 1 more element, add value there then make it locate itself through swim
	public void insert(int newValue){
		heap[++N] = newValue; 
		swim(N);
	}

	private int delMax(){
		int max = heap[1];
		exchange(1, N--);
		sink(1);
		heap[N + 1] = 0;
		return max;
	}

	//swim to the top of the tree,  k = node position in tree
	private void swim(int k){
		while(k > 1 && less(k/2, k)){ //while parent is bigger than current, then switch
			exchange(k, k/2);
			k = k/2; //we have switched element with parent 
		}
	}

	//k = node position in tree
	private void sink(int k){
		while(2*k <= N){
			int j = 2 * k;
			if(j < N && less(j, j + 1)) j++; //we will switch with the biggest child
			if(!less(k, j)) break; //if parent is bigger than child, there is no need to continue
			exchange(k , j);
			k = j;
		}
	}

	/*** Helper functions ***/

	private boolean less(int i, int j){
		return heap[i] < heap[j];
	}

	private void exchange(int i, int j){
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	public static void main(String[] args){
		BinaryHeap heap = new BinaryHeap(13);
		heap.insert(3);
		heap.insert(2);
		heap.insert(1);
		heap.insert(5);
		System.out.println(heap.delMax());
		System.out.println(heap.delMax());
		heap.insert(9);
		heap.insert(12);
		


		System.out.println("heap contents");
		for(int i = 0; i < heap.heap.length; i++){
			System.out.print(heap.heap[i] + " - ");
		}
		System.out.println();

	}

}