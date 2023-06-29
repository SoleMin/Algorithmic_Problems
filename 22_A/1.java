import java.io.*;
import java.math.*;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		n = sc.nextInt();
		if(n >1) {
			long[] a = new long[n + 1];
			for(int i=1; i<=n; i++) {
				a[i] = sc.nextInt();
			}
			Arrays.sort(a, 1, n+1);

			w: for(int x = 1; x <= n; x++) {
				if(a[x] == a[x+1]) {
					if(x + 1 == n) {
						System.out.println("NO");
						break w ;
					}
					continue;
				}
				System.out.println(a[x + 1]);
				break;
			}
		} else {
			System.out.println("NO");
		}
	}
}
       	 		 		 	     		  		 	