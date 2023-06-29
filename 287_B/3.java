import java.util.*;
import java.io.*;

public class Main {

	BufferedReader in;
	StringTokenizer str = null;
	PrintWriter out;
	
	private String next() throws Exception{
		if (str == null || !str.hasMoreElements())
			str = new StringTokenizer(in.readLine());
		return str.nextToken();
	}
	
	private int nextInt() throws Exception{
		return Integer.parseInt(next());
	}
	
	private long nextLong() throws Exception{
		return Long.parseLong(next());
	}
	
	private double nextDouble() throws Exception{
		return Double.parseDouble(next());
	}
	
	public void run() throws Exception{
		in =  new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);

		long n = nextLong();
		if (n == 1) {
			System.out.println(0);
			return;
		}
		long k = nextLong();
		long t = 1-(k-1) + k*(k+1)/2-1;
		if (t < n){
			System.out.println(-1);
			return;
		}

		long l = 0;
		long r = k;

		while(r - l > 1) {
			long m = (r + l)/2;
			long s = 1 - m + k*(k+1)/2 - (k-m)*(k-m+1)/2;
			//System.out.println(m + " " + s + " " + n);
			if (s >= n){
				r = m;
			}else{
				l = m;
			}
		}
		System.out.println(r);
		out.close();
	}
		
	public static void main(String[] args) throws Exception{
		new Main().run();
	}
}
