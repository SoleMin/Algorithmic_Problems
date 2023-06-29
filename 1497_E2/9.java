import java.io.*;
import java.util.*;

public class CF1497E2 extends PrintWriter {
	CF1497E2() { super(System.out); }
	static class Scanner {
		Scanner(InputStream in) { this.in = in; } InputStream in;
		byte[] bb = new byte[1 << 15]; int i, n;
		byte getc() {
			if (i == n) {
				i = n = 0;
				try { n = in.read(bb); } catch (IOException e) {}
			}
			return i < n ? bb[i++] : 0;
		}
		int nextInt() {
			byte c = 0; while (c <= ' ') c = getc();
			int a = 0; while (c > ' ') { a = a * 10 + c - '0'; c = getc(); }
			return a;
		}
	}
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF1497E2 o = new CF1497E2(); o.main(); o.flush();
	}

	static final int A = 10000000, K = 20;
	int[] cc = new int[A + 1]; {
		boolean[] composite = new boolean[A + 1];
		for (int a = 1; a <= A; a++)
			cc[a] = a;
		for (int a = 2; a <= A; a++) {
			if (composite[a])
				continue;
			for (int b = a + a; b <= A; b += a)
				composite[b] = true;
			if (a <= A / a) {
				int a2 = a * a;
				for (int b = a2; b <= A; b += a2) {
					int c = cc[b];
					while (c % a2 == 0)
						c /= a2;
					cc[b] = c;
				}
			}
		}
	}
	void main() {
		int[] pp = new int[A + 1]; Arrays.fill(pp, -1);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] aa = new int[n];
			for (int i = 0; i < n; i++)
				aa[i] = cc[sc.nextInt()];
			int[] mp = new int[k + 1];
			int[] ip = new int[k + 1];
			for (int i = 0; i < n; i++) {
				int a = aa[i];
				for (int h = k; h >= 0; h--) {
					if (pp[a] >= ip[h]) {
						mp[h]++;
						ip[h] = i;
					}
					if (h > 0 && (mp[h - 1] < mp[h] || mp[h - 1] == mp[h] && ip[h - 1] > ip[h])) {
						mp[h] = mp[h - 1];
						ip[h] = ip[h - 1];
					}
				}
				pp[a] = i;
			}
			println(mp[k] + 1);
			for (int i = 0; i < n; i++) {
				int a = aa[i];
				pp[a] = -1;
			}
		}
	}
}
