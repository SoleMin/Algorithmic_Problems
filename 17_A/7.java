import java.awt.*;
import java.math.*;
import java.util.regex.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.lang.Integer.parseInt;
import static java.util.AbstractMap.*;
import static java.lang.System.*;
import static java.lang.Math.*;
import java.awt.geom.*;
import java.util.*;
import java.text.*;
import java.io.*;

public class A {

	public static void main(String[] args) throws Exception {
		boolean submit = true;		
		Scanner sc = submit ? new Scanner(System.in) : new Scanner(new File("A.in"));
		while(sc.hasNext()) {
			int n = sc.nextInt(), k = sc.nextInt();
			boolean p[] = sieveOfEratosthenes(1001);
			ArrayList<Integer> nolds = new ArrayList<Integer>();
					
			for(int i = 0, prev = 0; i < p.length; i++) {
				if(p[i]) {
					nolds.add(prev+i + 1);
					prev = i;
				}					
			}
			
			//System.out.println(nolds);
			
			int c = 0;
			for(int i : nolds)
				if(i >= 2 && i <= n && p[i])
					c++;
			
			System.out.println(c >= k ? "YES" : "NO");
			
		}
		
		
			
		
		

	}
	
	//prime[i] = true iff i is prime, prime[0] = prime[1] = false and i can be from 0 to n (both inclusive)
    static boolean[] sieveOfEratosthenes(int n) {
        boolean prime[] = new boolean[n+1];
        fill(prime, 2, n, true);
        for(int i = 2; i <= n; i++)
            if(prime[i])
                for(int j = i*i; j <= n; j+=i) //check for i*i overflow
                    prime[j] = false;
        return prime;
    }

}
