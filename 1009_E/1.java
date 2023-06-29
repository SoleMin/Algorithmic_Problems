import java.io.*;
import java.util.*;

public class Main{
	static int mod=998244353;
	static long fastpow(long n,long ti) {
		 if (ti == 0) 
		        return 1l;
		if(ti%2==0) {
			long y=fastpow(n, ti/2);
			long k=y*y;
			k%=mod;
			return k;
		}
		else {
			long y=fastpow(n, ti/2);
			long k=((n*y)%mod)*y;
			k%=mod;
			return k;
		}
	}
	static long modInverse(long x) {
    	return fastpow(x, mod-2);
    }
	static void main() throws Exception{
		int n=sc.nextInt();
		int[]in=sc.intArr(n);
		if(n==1) {
			pw.println(in[0]);
			return;
		}
		long inv2=modInverse(2);
		long invpow2=1;
		long es=0,as=0;
		long ans=-1;
		for(int i=0;i<n;i++) {
			as=(in[i]*invpow2+as)%mod;
			ans=as+es;
			es=(es*inv2)%mod;
			es=(es+inv2*ans)%mod;
			invpow2=(invpow2*inv2)%mod;
		}
		for(int i=1;i<n;i++) {
			ans=(ans*2)%mod;
		}
		pw.println(ans);
    }
    public static void main(String[] args) throws Exception{
    	sc=new MScanner(System.in);
    	pw = new PrintWriter(System.out);
        int tc=1;
//        tc=sc.nextInt();
        for(int i=1;i<=tc;i++) {
//            pw.printf("Case #%d: ", i);
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