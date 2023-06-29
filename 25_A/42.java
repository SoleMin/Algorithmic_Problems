import java.io.*;
import java.util.*;

public class Main implements Runnable {
	private BufferedReader in;
	private PrintWriter out;
	private StringTokenizer st;
	
	private void eat(String line)
	{
		st = new StringTokenizer(line);
	}
	
	private String next() throws IOException
	{
		while(!st.hasMoreTokens()) {
			String line = in.readLine();
			if(line == null)
				return null;
			eat(line);
		}
		return st.nextToken();
	}
	
	private int nextInt() throws IOException
	{
		return Integer.parseInt(next());
	}
	
	public void run()
	{
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(new OutputStreamWriter(System.out));
			eat("");
			
			go();
			
			out.close();
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public static void main(String[] args)
	{
		new Thread(new Main()).start();
	}
	
	public void go() throws IOException
	{
		int n = nextInt();
		int[] v = new int[n], count = new int[2];
		for(int i = 0; i < n; ++i) {
			v[i] = nextInt();
			++count[v[i] % 2];
		}
		int residue = count[0] == 1 ? 0 : 1;
		for(int i = 0; i < n; ++i)
			if(v[i] % 2 == residue)
				out.println(i + 1);
	}
}
