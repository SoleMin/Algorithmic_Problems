import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {
	static PrintWriter out = new PrintWriter(System.out);
	static FS in;
	
	static int N;
	static final boolean debug = false;
	static int inp[] = new int[] {1,2,3,2,1,0};
	public static void main(String[] args) {
		in = new FS();
		if(!debug) N = in.nextInt();
		else N = inp.length;
		int x = solve(0, N/2-1, N/2, N-1);
		out.println("! "+(x+1));
		out.flush();
		out.close();
	}
	
	static int solve(int l1, int r1, int l2, int r2) {
		int sz = r1-l1+1;
		if(sz <= 0) return -2;
		int a1 = query(l1);
		int a2 = query(l2);
		if(a1 == a2) return l1;
		
		if(sz == 1) return -2;
		
		int b1 = query(l1+sz/2);
		int b2 = query(l2+sz/2);
		if(b1 == b2) return l1 + sz/2;
		
		if(sz == 2) return -2;
		
		int d1 = a2-a1;
		int d2 =  b2-b1;
		if((d1 < 0 && d2 > 0) || (d1 > 0 && d2 < 0)) {
			return solve(l1+1, l1 + sz/2 - 1, l2+1, l2 + sz/2 - 1);
		}
		else {
			return solve(l1 + sz/2 + 1, r1, l2 + sz/2 + 1, r2);
		}
	}
	
	static int query(int a) {
		out.println("? "+(a+1));
		out.flush();
		if(debug) return inp[a];
		else return in.nextInt();
	}
	
	static class FS{
		BufferedReader br;
		StringTokenizer st;
		public FS() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {st = new StringTokenizer(br.readLine());}
				catch(Exception e) { throw null;}
			}
			return st.nextToken();
		}
		int nextInt() { return Integer.parseInt(next());}
		double nextDouble() { return Double.parseDouble(next());}
		long nextLong() { return Long.parseLong(next());}
		int[] NIA(int n) {
			int r[] = new int[n];
			for(int i = 0; i < n; i++) r[i] = nextInt();
			return r;
		}
		long[] NLA(int n) {
			long r[] = new long[n];
			for(int i = 0; i < n; i++) r[i] = nextLong();
			return r;
		}
		char[][] grid(int r, int c){
			char res[][] = new char[r][c];
			for(int i = 0; i < r; i++) {
				char l[] = next().toCharArray();
				for(int j = 0; j < c; j++) {
					res[i][j] = l[j];
				}
			}
			return res;
		}
	}
	
}
