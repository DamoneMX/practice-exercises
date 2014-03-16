public class BinarySearch{
	
	public static int binarySearch(int[] a, int numberToFind){
		return binarySearch(a, numberToFind, 0, a.length -1);
	}

	public static int binarySearch(int[] a, int x, int low, int high){
		if(high < low) return -1;
		
		int mid = low + high / 2;
		if(x == a[mid])
			return a[mid];
		else if(x < a[mid])	//Search on the left side
			return binarySearch(a, x, low, mid - 1);
		else	//Search on the right side
			return binarySearch(a, x, mid + 1, high);
	}
	
	public static void main(String[] args){
		int[] a = new int[5];
		a[0] = 5;
		a[1] = 10;
		a[2] = 15;
		a[3] = 20;
		a[4] = 25;
		System.out.println(binarySearch(a, 8));
	}
	
}
