import java.io.*;
import java.util.*;

public class Codeforces911D {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sp = br.readLine().split(" ");
		int n = Integer.parseInt(sp[0]);
		int[] a = new int[n];
		sp = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sp[i]);
		}
		int inversions = 0;
		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n; j++) {
				if (a[i] > a[j]) {
					inversions++;
				}
			}
		}
		inversions = inversions%2;
		
		sp = br.readLine().split(" ");
		int m = Integer.parseInt(sp[0]);
		for (int i = 0; i < m; i++) {
			sp = br.readLine().split(" ");
			int l = Integer.parseInt(sp[0]);
			int r = Integer.parseInt(sp[1]);
			if ((r-l+1)%4 == 2 || (r-l+1)%4 == 3) {
				inversions = 1-inversions;
			}
			if (inversions == 1) {
				System.out.println("odd");
			}
			else {
				System.out.println("even");
			}
		}
	}
}
