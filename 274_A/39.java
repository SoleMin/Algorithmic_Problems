import static java.lang.Math.*; 

import java.io.*; 
import java.util.*; 

public class Template {
	BufferedReader in; 
	PrintWriter out;
	StringTokenizer st; 

	String next() {
		while (st==null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(in.readLine());
			} catch (Exception e) {}
		}
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
	
	class Point implements Comparable<Point> {
		int x, y; 
		public Point(int x, int y) {
			this.x=x; 
			this.y=y; 
		}
		public int compareTo(Point o) {
			return x-o.x; 
		}

		public String toString() {
			return x + " " + y; 
		}
	}
	

	public void run() throws Exception {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		Long start = System.currentTimeMillis();
			int n = nextInt(); 
			long k = nextLong(); 

			long[] a = new long[n]; 
			TreeMap<Long, Integer> st  = new TreeMap<Long, Integer>(); 

			for (int i=0; i<n; i++) {
				a[i] = nextLong(); 
				st.put(a[i], 1);
			}

			Arrays.sort(a); 

			for (int i=0; i<n; i++) {
				if (a[i] % k == 0) {
					long x = a[i] / k; 
					if (st.containsKey(x)) {
						int y = st.get(x); 
						st.remove(a[i]); 
						st.put(a[i], y + 1); 
					}
				}
			}


			int ans = 0; 
			for (int i=0; i<n; i++) {
				//System.err.println(a[n-i-1] + " " + st.get(a[n-i-1])); 
				ans+=(st.get(a[n-i-1]) + 1) / 2; 
				if (a[n-i-1] % k == 0) {
					long x = a[n-i-1] / k; 
					if (st.containsKey(x)) {
						//System.err.println(x); 
						st.remove(x); 
						st.put(x, 0); 
					}
				}
			}

			out.println(ans); 

		Long end = System.currentTimeMillis();
		out.close(); 
	}

	public static void main(String[] args) throws Exception {
		new Template().run(); 
	}
}