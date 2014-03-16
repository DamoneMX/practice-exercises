public class GeneralRecursion{

	public static String ex234(int n) {
	    if (n <= 0) return "";
	    return ex234(n-3) + n + ex234(n-2) + n;
	}

	public static void main(String[] args){
		System.out.println("Recursion Exercises");	

		System.out.println(32 + 32);
		System.out.println(32 + "32" + 33);

		System.out.println(ex234(2));

	}

}
