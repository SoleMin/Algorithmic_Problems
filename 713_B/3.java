import java.io.*;
import java.util.*;
import java.math.*;

public class B {
	public static void main(String[] args) throws IOException {

		/**/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/b.in"))));
		/**/
		
		int n = sc.nextInt();
		int l1 = 1;
		int r1 = n;
		int b1 = 1;
		int t1 = n;
		int min = b1;
		int max = t1;
		while (min != max) {
			int mid = (min+max)/2;
			System.out.println("? "+l1+" "+b1+" "+r1+" "+mid);
			System.out.flush();
			if (sc.nextInt() >= 1)
				max = mid;
			else
				min = mid+1;
		}
		t1 = min;
		min = l1;
		max = r1;
		while (min != max) {
			int mid = (min+max)/2;
			System.out.println("? "+l1+" "+b1+" "+mid+" "+t1);
			System.out.flush();
			if (sc.nextInt() >= 1)
				max = mid;
			else
				min = mid+1;
		}
		r1 = min;
		min = b1;
		max = t1;
		while (min != max) {
			int mid = (min+max+1)/2;
			System.out.println("? "+l1+" "+mid+" "+r1+" "+t1);
			System.out.flush();
			if (sc.nextInt() >= 1)
				min = mid;
			else
				max = mid-1;
		}
		b1 = min;
		min = l1;
		max = r1;
		while (min != max) {
			int mid = (min+max+1)/2;
			System.out.println("? "+mid+" "+b1+" "+r1+" "+t1);
			System.out.flush();
			if (sc.nextInt() >= 1)
				min = mid;
			else
				max = mid-1;
		}
		l1 = min;
		int l2 = 1;
		int r2 = n;
		int b2 = 1;
		int t2 = n;
		min = b2;
		max = t2;
		while (min != max) {
			int mid = (min+max+1)/2;
			System.out.println("? "+l2+" "+mid+" "+r2+" "+t2);
			System.out.flush();
			if (sc.nextInt() >= 1)
				min = mid;
			else
				max = mid-1;
		}
		b2 = min;
		min = l2;
		max = r2;
		while (min != max) {
			int mid = (min+max+1)/2;
			System.out.println("? "+mid+" "+b2+" "+r2+" "+t2);
			System.out.flush();
			if (sc.nextInt() >= 1)
				min = mid;
			else
				max = mid-1;
		}
		l2 = min;
		min = b2;
		max = t2;
		while (min != max) {
			int mid = (min+max)/2;
			System.out.println("? "+l2+" "+b2+" "+r2+" "+mid);
			System.out.flush();
			if (sc.nextInt() >= 1)
				max = mid;
			else
				min = mid+1;
		}
		t2 = min;
		min = l2;
		max = r2;
		while (min != max) {
			int mid = (min+max)/2;
			System.out.println("? "+l2+" "+b2+" "+mid+" "+t2);
			System.out.flush();
			if (sc.nextInt() >= 1)
				max = mid;
			else
				min = mid+1;
		}
		r2 = min;
		System.out.println("! "+l1+" "+b1+" "+r1+" "+t1+" "+l2+" "+b2+" "+r2+" "+t2);
		System.out.flush();
	}
}