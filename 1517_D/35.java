import java.io.*;
import java.util.*;

public class Main{
	static int[][][]memo;
	static int inf=(int)1e9;
	static int n,m,down[][],right[][];
	static int dp(int i,int j,int k) {
		if(k<=0)return 0;
		if(memo[i][j][k]!=-1)return memo[i][j][k];
		int ans=inf;
		if(i+1<n) {
			ans=Math.min(ans, down[i][j]+dp(i+1, j, k-1));
		}

		if(i-1>=0) {
			ans=Math.min(ans, down[i-1][j]+dp(i-1, j, k-1));
		}

		if(j+1<m) {
			ans=Math.min(ans, right[i][j]+dp(i, j+1, k-1));
		}

		if(j-1>=0) {
			ans=Math.min(ans, right[i][j-1]+dp(i, j-1, k-1));
		}
		return memo[i][j][k]=ans;
	}
	static void main() throws Exception{
		n=sc.nextInt();m=sc.nextInt();int k=sc.nextInt();
		if((k&1)==1) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					pw.print((-1)+" ");
				}
				pw.println();
			}
			return;
		}
		k>>=1;
		right=new int[n][];
		down=new int[n-1][];
		for(int i=0;i<n;i++) {
			right[i]=sc.intArr(m-1);
		}
		for(int i=0;i<n-1;i++) {
			down[i]=sc.intArr(m);
		}
		memo = new int[n][m][k+1];
		int inf=(int)1e9;
		for(int i=0;i<=k;i++) {
			for(int j=0;j<n;j++) {
				for(int o=0;o<m;o++) {
					memo[j][o][i]=-1;
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				pw.print((dp(i, j, k)<<1)+" ");
			}
			pw.println();
		}
    }
    public static void main(String[] args) throws Exception{
    	sc=new MScanner(System.in);
    	pw = new PrintWriter(System.out);
        int tc=1;
//        tc=sc.nextInt();
        for(int i=1;i<=tc;i++) {
//            pw.printf("Case #%d:", i);
            main();
        }
        pw.flush();
    }
    static PrintWriter pw;
    static MScanner sc;
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
    static void sort(int[]in) {
    	shuffle(in);
        Arrays.sort(in);
    }
    static void sort(long[]in) {
    	shuffle(in);
        Arrays.sort(in);
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