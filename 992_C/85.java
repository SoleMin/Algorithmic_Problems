import java.io.*;
import java.util.*;
	
public	 class template
	{
		private InputStream is;
		private PrintWriter pw;
		static char[][] ch;
		static int  x1,x2,y1,y2,n,m,h,k;
		static long dist[][];
		static boolean boo[][];
		
		void soln()
		{
			is = System.in;
			pw = new PrintWriter(System.out);
			long s = System.currentTimeMillis();
			solve();
			pw.close();
			pw.flush();
			// tr(System.currentTimeMillis() - s + "ms");
		}
	
		public static void main(String[] args) throws Exception 
		{
			new Thread(null, new Runnable() 
			{
				public void run() 
				{
					try
					{
						// new CODEFORCES().soln();
					} catch (Exception e)
					{
						System.out.println(e);
					}
				}
			}, "1", 1 << 26).start();
			new template().soln();
		}
	
		void solve() 
		{
			long n = nl(), k = nl();
			if(n==0){
				pw.println(0);
				return;
			}
			long MOD = 1000000007;
			long pow1 = pow(2,k,MOD), pow2 = pow(2,k+1,MOD);
			pw.println(((((n%MOD)*pow2)%MOD) - (pow1-1+MOD)%MOD + 2*MOD)%MOD);
			pw.close();	
		}
		long pow(long x, long y, long mod){
			long ans = 1;
			while(y>0){
				if(y%2==0) {
					x *= x;
					x %= mod;
					y/=2;
				}
				else{
					ans *= x;
					ans %= mod;
					y-=1;
				}
			}
			return ans;
		}
		long gcd(long a, long b){
			if(b==0) return a;
			return gcd(b,a%b);
		}
		void printArray(long[] arr) {
			for(long i : arr) pw.print(i +" ");
			pw.println();
		}
	static long min(long x, long y){
		return (x<y)?x:y;
	}
	static class Pair implements Comparable<Pair>{
		long val;
		int  x, y;
		Pair(long v, int a, int b){
			val = v; x = a; y = b;
		}
		public int compareTo(Pair p){
			return Long.compare(this.val,p.val);
		}
	}
	private static class Queue{
		int st = 0;
		int et = 0;
		Pair[] arr;
		public Queue(int len) {
			arr = new Pair[len];
		}
		public boolean isEmpty() {
			return st==et;
		}
		public void add(Pair x) {
			arr[et++] = x;
		}
		public Pair poll() {
			return arr[st++];
		}
		public void clear() {
			st = et = 0;
		}
	}
		/*void bfs(int k) {
			while(!q.isEmpty()) {
				int y = q.poll();
				for(long i : amp[y]) {
					if(!b[i]) {
						D[i][k] = D[y][k]+1;
						q.add(i);
						b[i] = true;
					}
				}
			}
		}
		*/
		/*
		int dfs(int x) {
			b[x] = true;
			//start[x] = time++;
			int ans = 1;
			for(int i : amp[x]) {
				if(!b[i]) {
					ans += dfs(i);
				}
			}
			//end[x] = time;
			if(x!= 0 && ans%2==0 && (N-ans)%2==0) cost++;
				
			return ans;
		}*/
		
		/*void buildGraph(int n) 
		{
			for (int i = 0; i < n; i++) 
			{
				int x1 = ni() - 1, y1 = ni() - 1;
				amp[x1].add(y1);
				amp[y1].add(x1);
			}
		}*/
		public static int[] shuffle(int[] a, Random gen)
		{
			for (int i = 0, n = a.length; i < n; i++)
			{
				int ind = gen.nextInt(n - i) + i;
				int d = a[i];
				a[i] = a[ind];
				a[ind] = d;
			}
			return a;
		}
		// To Get Input
		// Some Buffer Methods
		private byte[] inbuf = new byte[1024];
		public int lenbuf = 0, ptrbuf = 0;
	
		private int readByte()
		{
			if (lenbuf == -1)
				throw new InputMismatchException();
			if (ptrbuf >= lenbuf) 
			{
				ptrbuf = 0;
				try 
				{
					lenbuf = is.read(inbuf);
				} catch (IOException e)
				{
					throw new InputMismatchException();
				}
				if (lenbuf <= 0)
					return -1;
			}
			return inbuf[ptrbuf++];
		}
	
		private boolean isSpaceChar(int c) 
		{
			return !(c >= 33 && c <= 126);
		}
	
		private int skip() 
		{
			int b;
			while ((b = readByte()) != -1 && isSpaceChar(b))
				;
			return b;
		}
	
		private double nd() 
		{
			return Double.parseDouble(ns());
		}
	
		private char nc() 
		{
			return (char) skip();
		}
	
		private String ns()
		{
			int b = skip();
			StringBuilder sb = new StringBuilder();
			while (!(isSpaceChar(b)))
			{ // when nextLine, (isSpaceChar(b) && b != '
										// ')
				sb.appendCodePoint(b);
				b = readByte();
			}
			return sb.toString();
		}
	
		private char[] ns(int n) 
		{
			char[] buf = new char[n];
			int b = skip(), p = 0;
			while (p < n && !(isSpaceChar(b)))
			{
				buf[p++] = (char) b;
				b = readByte();
			}
			return n == p ? buf : Arrays.copyOf(buf, p);
		}
	
		private char[][] nm(int n, int m)
		{
			char[][] map = new char[n][];
			for (int i = 0; i < n; i++)
				map[i] = ns(m);
			return map;
		}
	
		private int[] na(int n)
		{
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = ni();
			return a;
		}
	
		private int ni() 
		{
			int num = 0, b;
			boolean minus = false;
			while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
				;
			if (b == '-')
			{
				minus = true;
				b = readByte();
			}
	
			while (true) 
			{
				if (b >= '0' && b <= '9') 
				{
					num = num * 10 + (b - '0');
				} else 
				{
					return minus ? -num : num;
				}
				b = readByte();
			}
		}
	
		private long nl() 
		{
			long num = 0;
			int b;
			boolean minus = false;
			while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
				;
			if (b == '-') 
			{
				minus = true;
				b = readByte();
			}
	
			while (true) 
			{
				if (b >= '0' && b <= '9') 
				{
					num = num * 10 + (b - '0');
				} else 
				{
					return minus ? -num : num;
				}
				b = readByte();
			}
		}
	
		private boolean oj = System.getProperty("ONLINE_JUDGE") != null;
	
		private void tr(Object... o) 
		{
			if (!oj)
				System.out.println(Arrays.deepToString(o));
		}
	}