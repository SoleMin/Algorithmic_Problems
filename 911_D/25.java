import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class D911 {

	public static long total = 0;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Integer> temp = new ArrayList<>();
		int[] ar = new int[n];
		int[] memo = new int[n];
		for (int i = 0; i < n; i++) {
			int t = in.nextInt();
			int index = -1*Collections.binarySearch(temp, t)-1;
			temp.add(index, t);
			ar[i] = t;
			memo[i] = i - index;
			total += memo[i];
		}
		int m = in.nextInt();
		for (int i = 0; i < m; i++) {
//			int a = in.nextInt() - 1, b = in.nextInt() - 1;
//			query(ar, memo, in.nextInt() - 1, in.nextInt() - 1);
			total += (-1*(in.nextInt() - 1 - in.nextInt() + 1) + 1) / 2;
			System.out.println(total%2 == 0 ? "even" : "odd");
		}
	}
	
	public static void query(int[] ar, int[] memo, int a, int b) {
		if (a >= b) {
			return;
		}
		if (ar[a] < ar[b]) {
			memo[a]++;
			total++;
		} else {
			memo[b]--;
			total--;
		}
		int t = ar[a];
		ar[b] = ar[a];
		ar[b] = t;
		t = memo[a];
		memo[b] = memo[a];
		memo[b] = t;
		query(ar, memo, a + 1, b - 1);
	}
	
}
