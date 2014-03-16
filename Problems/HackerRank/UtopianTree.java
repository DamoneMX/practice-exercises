import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//Level: Warm up 
public class UtopianTree {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine(); //returns null when end of file has been reache
		int T = Integer.parseInt(line);
		for(int i = 1; i <= T; i++){
			line = br.readLine();
			int N = Integer.parseInt(line);
			int height = 1; 
			
			for(int j = 1; j <= N; j++){
				if(j % 2 == 1)
					height = height * 2;
				else if(j % 2 == 0)
					height++;
			}
			
			System.out.println(height);		
		}
    }
}