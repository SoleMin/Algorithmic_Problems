import java.io.*;
import java.util.*;

public class B {
	static double max;
	static int n, A, b[], l[];
	static int sw[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int k = sc.nextInt();
		A = sc.nextInt();
		b = new int[n];
		l = new int[n];
		sw = new int[n];
		for(int i=0; i<n; i++) {
			b[i] = sc.nextInt();
			l[i] = sc.nextInt();
		}
		max = 0;
		search(k, 0);
		System.out.println(max);
	}

	static void search(int k, int m) {
		if(max == 1) return;
		if(m == n) {
			if(k > 0) return;
			double pr[] = new double[n];
			for(int i=0; i<n; i++) {
				pr[i] = Math.min(100, l[i] + 10*sw[i])*1./100;
			}
			double ex = 0;
			for(int i=0; i<1<<n; i++) {
				double p = 1;
				int cnt = 0;
				int lv = 0;
				for(int j=0; j<n; j++) {
					if((i&(1<<j))>0) {
						p *= pr[j];
						cnt++;
					}
					else {
						p *= (1-pr[j]);
						lv += b[j];
					}
				}
				if(cnt > n/2) {
					ex += p;
				}
				else {
					ex += p*A/(A+lv);
				}
			}
			max = Math.max(max, ex);
			return;
		}
		for(int i=k; i>=0; i--) {
			sw[m] = i;
			search(k-i, m+1);
		}
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
			eat("");
		}

		void eat(String s) {
			st = new StringTokenizer(s);
		}

		String nextLine() {
			try {
				return br.readLine();
			} catch (IOException e) {
				throw new IOError(e);
			}
		}

		boolean hasNext() {
			while (!st.hasMoreTokens()) {
				String s = nextLine();
				if (s == null)
					return false;
				eat(s);
			}
			return true;
		}

		String next() {
			hasNext();
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}
