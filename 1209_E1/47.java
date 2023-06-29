import java.io.*;
import java.util.*;


public class Main{
	static int[][]memo;
	static int n,m,in[][];
	static int dp(int col,int maxRowMask) {
		if(col>=m)return 0;
		if(memo[col][maxRowMask]!=-1)return memo[col][maxRowMask];
		
		int ans=0;
		
		for(int colMask=0;colMask<(1<<n);colMask++) {
			
			int sum=0;
			for(int i=0;i<n;i++) {
				if(((colMask>>i)&1)!=0) {
					sum+=in[i][col];
				}
			}
			int curMask=colMask;
			for(int cyclicShift=0;cyclicShift<n;cyclicShift++) {
				if((curMask&maxRowMask)!=0) {//some row has max value already determined
					int lastBit=curMask&1;
					curMask>>=1;
					curMask|=(lastBit<<(n-1));
					continue;
				}
				
				ans=Math.max(ans, sum+dp(col+1, maxRowMask|curMask));
				
				int lastBit=curMask&1;
				curMask>>=1;
				curMask|=(lastBit<<(n-1));
				
			}
			
		}
		return memo[col][maxRowMask]=ans;
	}
	public static void main(String[] args) throws Exception{
		pw=new PrintWriter(System.out);
		sc = new MScanner(System.in);
		int tc=sc.nextInt();
		while(tc-->0) {
			n=sc.nextInt();m=sc.nextInt();
			in=new int[n][m];
			for(int i=0;i<n;i++)in[i]=sc.intArr(m);
			memo=new int[m][1<<n];
			for(int i=0;i<m;i++)Arrays.fill(memo[i], -1);
			pw.println(dp(0, 0));
		}
		
		
		pw.flush();
	}
	static PrintWriter pw;
	static MScanner  sc;
	static class MScanner {
		StringTokenizer st;
		BufferedReader br;
		public MScanner(InputStream system) {
			br = new BufferedReader(new InputStreamReader(system));
		}
 
		public MScanner(String file) throws Exception {
			br = new BufferedReader(new FileReader(file));
		}
 
		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		public int[] intArr(int n) throws IOException {
	        int[]in=new int[n];for(int i=0;i<n;i++)in[i]=nextInt();
	        return in;
		}
		public long[] longArr(int n) throws IOException {
	        long[]in=new long[n];for(int i=0;i<n;i++)in[i]=nextLong();
	        return in;
		}
		public int[] intSortedArr(int n) throws IOException {
	        int[]in=new int[n];for(int i=0;i<n;i++)in[i]=nextInt();
	        shuffle(in);
	        Arrays.sort(in);
	        return in;
		}
		public long[] longSortedArr(int n) throws IOException {
	        long[]in=new long[n];for(int i=0;i<n;i++)in[i]=nextLong();
	        shuffle(in);
	        Arrays.sort(in);
	        return in;
		}
		public Integer[] IntegerArr(int n) throws IOException {
	        Integer[]in=new Integer[n];for(int i=0;i<n;i++)in[i]=nextInt();
	        return in;
		}
		public Long[] LongArr(int n) throws IOException {
	        Long[]in=new Long[n];for(int i=0;i<n;i++)in[i]=nextLong();
	        return in;
		}
		public String nextLine() throws IOException {
			return br.readLine();
		}
 
		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
 
		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}
 
		public char nextChar() throws IOException {
			return next().charAt(0);
		}
 
		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}
 
		public boolean ready() throws IOException {
			return br.ready();
		}
 
		public void waitForInput() throws InterruptedException {
			Thread.sleep(3000);
		}
	}
	static void shuffle(int[]in) {
		for(int i=0;i<in.length;i++) {
			int idx=(int)(Math.random()*in.length);
			int tmp=in[i];
			in[i]=in[idx];
			in[idx]=tmp;
		}
	}
	static void shuffle(long[]in) {
		for(int i=0;i<in.length;i++) {
			int idx=(int)(Math.random()*in.length);
			long tmp=in[i];
			in[i]=in[idx];
			in[idx]=tmp;
		}
	}
}