import static java.lang.Math.*; 
import java.io.*; 
import java.util.*; 

public class A {
	BufferedReader in; 
	PrintWriter out;
	StringTokenizer st; 


	public String next() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(in.readLine());
			} catch(Exception e) {}
		}
		return st.nextToken();
	}

	public int nextInt() {
		return Integer.parseInt(next()); 
	}
	public long nextLong() {
		return Long.parseLong(next());
	}

	boolean bit(int m, int i) {
		return (m & (1 << i)) > 0; 
	}

	int n, x, y, c;  
 
 	long cnt(int m) {
 		long ret=0;
 		for (int i=max(1, y-m); i<=min(n, y+m); i++) {
 			int x1 = max(1, x - (m - abs(i - y)));
 			int x2 = min(n, x + (m - abs(i - y)));
 			ret += x2 - x1 + 1; 
 		}
 		return ret;
 	}

	public void run() {
		in  = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		n = nextInt(); 
		x = nextInt(); 
		y = nextInt(); 
		c = nextInt();

		int l = 0, r = 1000000;
		int ans=0;
		while (l <= r) {
			int m = (l+r) / 2; 
			if (cnt(m) >= c) {
				ans = m; 
				r = m-1; 
			} else l=m+1; 
		} 

		out.println(ans);

		out.close(); 
	}

	class Pair implements Comparable<Pair> {
		long x,y; 
		public Pair(long x, long y) {
			this.x=x; 
			this.y=y; 
		}
		public int compareTo(Pair o) {
			if (x != o.x) return sign(o.x - x); 
			return sign(y - o.y); 
		}
	}

	int sign(long x) {
		if (x < 0) return -1; 
		if (x > 0) return 1; 
		return 0;
	}

	public static void main(String[] args) throws Exception {
		new A().run(); 		
	}
}