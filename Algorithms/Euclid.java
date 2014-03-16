public class Euclid{

	// recursive implementation
    public static int gcd(int p, int q) {
        if (q == 0) return p;  ////Base Case
        else return gcd(q, p % q); 
    }

    // non-recursive implementation
    public static int gcd2(int p, int q) {
        while (q != 0) {	
            int temp = q;	//When modulo is equal to 0 we know that we have found the Greatest Common Divisor
            q = p % q;
            p = temp;
        }
        return p;
    }

    public static void main(String[] args) {
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        int d  = gcd(p, q);
        int d2 = gcd2(p, q);
        System.out.println("gcd(" + p + ", " + q + ") = " + d);
        System.out.println("gcd(" + p + ", " + q + ") = " + d2);
    }



}
