import java.util.*;
import java.io.*;

public class File {
	public static class FastScanner {
		BufferedReader br;
		StringTokenizer st;
		
		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
	}
	
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		
		
		
		int n = sc.nextInt();
		
		// Should always be possible.
		int F1 = getClosest(n);
		n -= F1;
		int F2 = getClosest(n);
		n -= F2;
		int F3 = getClosest(n);
		
		out.println(F1 + " " + F2 + " " + F3);
		
		
		
		out.close();
	}
	
	// Gets the closest fibonacci number to n.
	public static int getClosest(int n) {
		int closest = 0;
		int f1 = 0;
		int f2 = 1;
		
		while (f1 <= n) {
			closest = Math.max(closest, f1);
			
			int next = f1 + f2;
			f1 = f2;
			f2 = next;
		}
		
		return closest;
	}
}






















