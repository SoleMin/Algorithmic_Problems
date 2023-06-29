import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class A25 {

	static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	static PrintWriter out = new PrintWriter(System.out);
	
	static int nextInt() throws Exception {
		in.nextToken();
		return (int)in.nval;
	}
	
	static String nextString() throws Exception {
		in.nextToken();
		return in.sval;
	}
	
	public static void main(String[] args) throws Exception {
		int n = nextInt();
		int[] c = new int[2];
		int[] f = new int[2];
		for (int i = 0; i < n; i++) {
			int x = nextInt(), p = x%2;
			if (c[p]++ == 0) f[p] = i+1;
		}
		out.println(c[0] == 1 ? f[0] : f[1]);
		
		out.flush();
	}

}
