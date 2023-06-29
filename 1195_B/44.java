import java.io.*;
import java.util.*;

public class  zz{
	static int mod=(int)1e9+7;
    public static void main(String[] args) throws Exception{
        //MScanner sc = new MScanner("chess.in");
        MScanner sc = new MScanner(System.in);
        PrintWriter pw=new PrintWriter(System.out);
        int n=sc.nextInt();
        //int[]in=new int[n];for(int i=0;i<n;i++)in[i]=sc.nextInt();
        int k=sc.nextInt();
        int x=(-3+(int)Math.sqrt(9+4*1.0*(2*k*1.0+2*n*1.0)))/2;
        pw.println(n-x);
        pw.flush();
    }
    static class pair implements Comparable<pair>{
    	String t;int d;int idx;
    	pair(String x,int y,int i){
    		t=x;d=y;idx=i;
    	}
    	@Override
    	public int compareTo(pair o) {
    		if(t.compareTo(o.t)!=0) {
    			return t.compareTo(o.t);
    		}
    		return o.d-d;
    	}
    	 
    	public boolean equals(pair o) {
    		if(this.compareTo(o)==0)return true;
    		return false;
    	}
    	public String toString() {
    		return "("+t+" "+d+")";
    	}
    }
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
 
		public Long nextLong() throws IOException {
			return Long.parseLong(next());
		}
 
		public boolean ready() throws IOException {
			return br.ready();
		}
 
		public void waitForInput() throws InterruptedException {
			Thread.sleep(3000);
		}
	}
}