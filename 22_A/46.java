import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.Arrays;


public class Main {
	private static StreamTokenizer in;
	private static PrintWriter out;
	
	private static int nextInt() throws Exception {
		in.nextToken();
		return (int)in.nval;
	}
	
	private static String nextString() throws Exception {
		in.nextToken();
		return in.sval;
	}
	
	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		out = new PrintWriter(System.out);
		
		int n = nextInt();
		int[] a = new int[n];
		for (int i=0; i<n; i++)
			a[i] = nextInt();
		Arrays.sort(a);
		int u = a[0];
		for (int i=0; i<n; i++)
			if (a[i]>u) {
				out.println(a[i]);
				out.flush();
				return;
			}
		out.println("NO");
		out.flush();
	}
}
