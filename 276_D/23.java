import java.util.*;
import java.io.*;

public class Main {

	BufferedReader in;
	StringTokenizer str = null;
	
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
		long l = nextLong();
		long r = nextLong();

		int bit = 63;
		while(bit >= 0 && (hasBit(l, bit) == hasBit(r, bit))) {
			bit--;
		}
		System.out.println((1L<<bit+1)-1);
	}

	private boolean hasBit(long x, int i){
		return (x & (1L<<i)) > 0;
	}
		
	public static void main(String[] args) throws Exception{
		new Main().run();
	}
}
