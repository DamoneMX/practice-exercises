import java.util.Scanner;
public class Test{
     public static void main(String[] args){
     String input = "1 fish 2 fish red fish blue fish";
     Scanner s = new Scanner(input).useDelimiter("\\s*\\s*");
     System.out.println(s.nextInt());
     if(s.hasNextInt())
     	System.out.println(s.nextInt());
     System.out.println(s.next());
     System.out.println(s.next());
     s.close();
     }

}
