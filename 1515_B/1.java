import java.io.*;
import java.util.*;

public class Main{
	static long inf=(long)1e9;
	static HashSet<Long>squares;
	static void main() throws Exception{
		long n=sc.nextInt();
		if((n%2==0 && squares.contains(n/2)) || (n%4==0 && squares.contains(n/4))) {
			pw.println("YES");
		}
		else {
			pw.println("NO");
		}
    }
    public static void main(String[] args) throws Exception{
    	sc=new MScanner(System.in);
    	pw = new PrintWriter(System.out);
        int tc=1;
        tc=sc.nextInt();
        squares=new HashSet<Long>();
        for(long i=1;i*i<=inf;i++) {
        	squares.add(i*i);
        }
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