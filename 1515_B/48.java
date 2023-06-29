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
		
		int t = sc.nextInt();
		for (int z = 0; z < t; ++z) {
			int n = sc.nextInt();
			if (n%2==1) {
				System.out.println("NO");
				continue;
			}
			n/=2;
			int sqrt = (int)Math.sqrt(n);
			if (sqrt*sqrt==n) {
				System.out.println("YES");
				continue;
			}
			if (n%2==1) {
				System.out.println("NO");
				continue;
			}
			n/=2;
			sqrt = (int)Math.sqrt(n);
			if (sqrt*sqrt==n) {
				System.out.println("YES");
				continue;
			}
			System.out.println("NO");
		}
	}
}