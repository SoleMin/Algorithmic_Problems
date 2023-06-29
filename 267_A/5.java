import java.io.*;
import java.util.*;

public class Mai {

	public static void main(String[] args) throws IOException{
		Scanner cin = new Scanner(System.in);
		
		int t, n, m;
		
		t = cin.nextInt();
		
		while(t > 0) {
			t--;
			int sum = 0;
			n = cin.nextInt();
			m = cin.nextInt();
			while(n > 0 && m > 0) {
				if(n < m) {
					int k = n;
					n = m;
					m = k;
				}
				sum += n / m; n %= m;
			}
			
			System.out.println(sum);
		}
	}

}
 		  		   	 	  	 		 		    	