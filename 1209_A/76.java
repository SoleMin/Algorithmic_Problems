import java.io.*;
import java.util.*;
import java.math.*;

public class A {
	public static void main(String[] args) throws IOException {

		/**/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/a.in"))));
		/**/
		
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		Arrays.sort(a);
		int ans = 0;
		boolean[] v = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (v[i])
				continue;
			v[i] = true;
			ans++;
			for (int j = i; j < n; j++) {
				if (a[j]%a[i]==0)
					v[j] = true;
			}
		}
		System.out.println(ans);
	}
}