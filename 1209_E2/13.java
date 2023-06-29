import java.io.*;
import java.util.*;


public class Main{
	static int[][]memo;
	static int n,m,in[][];
	static int dp(int col,int maxRowMask) {
		if(col>=Math.min(n, m) || maxRowMask==((1<<n)-1))return 0;
		if(memo[col][maxRowMask]!=-1)return memo[col][maxRowMask];
		
		int ans=0;
		
		int availableBits=maxRowMask^((1<<n)-1);
		//all masks that don't intersect with maxRowMask
		for(int colMask=availableBits;colMask!=0;colMask=(colMask-1)&availableBits) {
			
			ans=Math.max(ans, maxMask[col][colMask]+dp(col+1, maxRowMask|colMask));
			
		}
		return memo[col][maxRowMask]=ans;
	}
	static int[][]sumOfMask;
	static int[][]maxMask;
	public static void main(String[] args) throws Exception{
		pw=new PrintWriter(System.out);
		sc = new MScanner(System.in);
		int tc=sc.nextInt();
		while(tc-->0) {
			n=sc.nextInt();m=sc.nextInt();
			
			int[]maxInCol=new int[m];
			in=new int[m][n+1];
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					in[j][i]=sc.nextInt();
					maxInCol[j]=Math.max(maxInCol[j], in[j][i]);
					in[j][n]=j;
				}
			}
			Arrays.sort(in,(x,y)->maxInCol[y[n]]-maxInCol[x[n]]);
			
			
			memo=new int[n][1<<n];
			sumOfMask=new int[n][1<<n];
			maxMask=new int[n][1<<n];
			for(int i=0;i<n;i++) {
				for(int msk=0;msk<memo[i].length;msk++) {
					memo[i][msk]=-1;
					if(i>=m)continue;
					for(int bit=0;bit<n;bit++) {
						if(((msk>>bit)&1)!=0) {
							sumOfMask[i][msk]+=in[i][bit];
						}
					}
				}
			}
			for(int col=0;col<n;col++) {
				for(int msk=0;msk<(1<<n);msk++) {
					int curMask=msk;
					for(int cyclicShift=0;cyclicShift<n;cyclicShift++) {
						maxMask[col][msk]=Math.max(maxMask[col][msk], sumOfMask[col][curMask]);
						
						int lastBit=curMask&1;
						curMask>>=1;
						curMask|=(lastBit<<(n-1));
						
					}
				}
			}
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