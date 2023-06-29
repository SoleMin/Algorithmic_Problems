import java.util.*;
import static java.lang.Math.*; 
import static java.util.Arrays.*;
import static java.lang.Character.*;
import static java.lang.Double.*;


public class A {

	Scanner scan = new Scanner(System.in);
	
	
	void solve() {
		int n = scan.nextInt();
		String[]A = new String[n];
		String[]B = new String[n];
		int res =0;
		for(int i=0;i<n;i++)A[i]=scan.next();
		for(int i=0;i<n;i++)B[i]=scan.next();
		for(int i=0;i<A.length;i++) {
			boolean fnd = false;
			for(int j=0;j<B.length;j++) {
				if(A[i].equals(B[j])) {
					fnd = true;
					B[j]="";
					break;
				}
			}
			if(!fnd)res++;
		}
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		new A().solve();
	}
}
