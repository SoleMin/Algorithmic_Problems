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
		
		
		
		int n = sc.nextInt(); // Number of supply-line filters
		int m = sc.nextInt(); // Number of devices
		int k = sc.nextInt(); // Number of sockets available to plug to directly
		
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		// Need >= m free sockets to charge all devices.
		// Find minimum supply-line filters needed to do this.
		
		// Always best to use supply-line filter with more sockets in it.
		Arrays.sort(a);
		
		// Keep adding a filter until total sockets >= m
		int sockets = k;
		int filtersNeeded = 0;
		int index = n-1;
		
		while (sockets < m && index >= 0) {
		    // Each filter we add can increase number of sockets by a[i] - 1.
			sockets += (a[index] - 1);
			filtersNeeded++;
			index--;
		}
		
		if (sockets >= m) {
			out.println(filtersNeeded);
		}
		else {
			out.println(-1);
		}
		
		out.close();
	}
}






















