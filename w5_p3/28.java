import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String t = scan.nextLine();
		String p = scan.nextLine();
		int next[] = new int[t.length()];
		next[0] = 0;
		int n = t.length();
		int m = p.length();
		int k = 0;
		int q = 1;
		int i = 0;
		while (q < m) {
			while (k > 0 && p.charAt(k) != p.charAt(q))
				k = next[k-1];
			if (p.charAt(k) == p.charAt(q)) {
				k = k + 1;
				next[q] = k;
			}
			q++;
		}
		q = 0;
		int cnt = 0;
		int move[] = new int[n];
		while (i < n) {
			while (q > 0 && p.charAt(q) != t.charAt(i)) {
				q= next[q-1];
			}
			if (p.charAt(q) == t.charAt(i)) {
				if (q == m-1) {
					move[cnt] = i - m + 2;
					cnt++;
					q = next[q];
				}
				else q++;
			}
			i++;
		}
		System.out.println(cnt);
		for (int j = 0; j < cnt; j++) {
			if (move[j] > 0)
				System.out.print(move[j] + " ");
		}
	}
}