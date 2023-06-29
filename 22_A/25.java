import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class A22 {

	static StreamTokenizer in;
	static PrintWriter out;
	
	static int nextInt() throws IOException {
		in.nextToken();
		return (int)in.nval;
	}
	
	static String nextString() throws IOException {
		in.nextToken();
		return in.sval;
	}

	public static void main(String[] args) throws IOException {
		in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		out = new PrintWriter(System.out);

		int n = nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = nextInt();
		
		Arrays.sort(a);
		int f = a[0], q = 1;
		while (q < n && a[q] == f) q++;
		
		out.println(q < n ? a[q] : "NO");
		
		out.flush();
	}

}
