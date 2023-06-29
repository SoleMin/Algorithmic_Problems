import java.util.*;
public class A {
	static int [] reverse = new int [257];
	public static void main (String [] arg) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] A =new int [n];
		for (int i = 0; i<A.length; ++i) A[i] = sc.nextInt();
		Arrays.sort(A);
		if (n == 1) {
			System.out.println( (A[0] == 1) ? "2" : "1");
			return;
		} else if (A[0] == A[A.length-1] && A[0] == 1) {
			System.out.print("1");
			for (int i = 1; i<n-1; ++i) System.out.print(" " + A[i]);
			System.out.println(" 2");
			return;
		} else if (A[0] == A[A.length-1]) {
			System.out.print("1");
			for (int i = 1; i<n; ++i) System.out.print(" " + A[i]);
			System.out.println();
			return;
		} 
		
		for (int i = 0; i<A.length; ++i) {
			int prev = (i == 0) ? Integer.MAX_VALUE : A[i-1];
			int next = (i == A.length-1) ? Integer.MAX_VALUE : A[i+1];
			int ans = Math.min(prev, Math.min(next, A[i]));
			if (i == 0) ans = 1;
			
			System.out.print((i == 0) ? "" + ans : " " + ans);
		}
		System.out.println();
		
		
	}
	
}