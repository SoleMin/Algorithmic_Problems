import java.util.*;
import java.io.*;

public class codeforces {
	public static void main(String[] args) throws Exception {

		int t=sc.nextInt();
		while(t-->0) {
			int n=sc.nextInt();
			int[]a=sc.nextIntArray(n);
			LinkedList<Integer>ll=new LinkedList<Integer>();
			for(int i=0;i<n;i++) {
				if(a[i]==1) {
					ll.addLast(a[i]);
				}else if(ll.isEmpty()) {
					ll.addLast(a[i]);
					
				}else {
					while(!(ll.getLast()==a[i]-1)) {
						ll.removeLast();
					}
					ll.removeLast();
					ll.addLast(a[i]);
				}
				int ii=0;
				for(int j:ll) {
					pw.print(j);
					if(ii!=ll.size()-1){
						pw.print('.');
					}
					ii++;
				}
				pw.println();
			}
			
		}
		
		
		
		
		pw.close();
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(FileReader r) {
			br = new BufferedReader(r);
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public long[] nextlongArray(int n) throws IOException {
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}

		public Long[] nextLongArray(int n) throws IOException {
			Long[] a = new Long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}

		public int[] nextIntArray(int n) throws IOException {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		public Integer[] nextIntegerArray(int n) throws IOException {
			Integer[] a = new Integer[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}

	static class pair implements Comparable<pair> {
		long x;
		long y;

		public pair(long x, long y) {
			this.x = x;
			this.y = y;
		}

		public String toString() {
			return x + " " + y;
		}

		public boolean equals(Object o) {
			if (o instanceof pair) {
				pair p = (pair) o;
				return p.x == x && p.y == y;
			}
			return false;
		}

		public int hashCode() {
			return new Long(x).hashCode() * 31 + new Long(y).hashCode();
		}

		public int compareTo(pair other) {
			if (this.x == other.x) {
				return Long.compare(this.y, other.y);
			}
			return Long.compare(this.x, other.x);
		}
	}

	static class tuble implements Comparable<tuble> {
		int x;
		int y;
		int z;

		public tuble(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public String toString() {
			return x + " " + y + " " + z;
		}

		public int compareTo(tuble other) {
			if (this.x == other.x) {
				if (this.y == other.y) {
					return this.z - other.z;
				}
				return this.y - other.y;
			} else {
				return this.x - other.x;
			}
		}
	}

	static long mod = 1000000007;
	static Random rn = new Random();
	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);
}
