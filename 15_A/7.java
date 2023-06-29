import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class A15 {

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
		
		int n = nextInt(), t = nextInt();
		
		int[] x = new int[n];
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = nextInt();
			a[i] = nextInt();
		}
		
		int ans = 0;
		for (int i = 0; i < n; i++) {
			boolean left = true, right = true;
			for (int j = 0; j < n; j++)
				if (x[j] < x[i] && a[i] + 2*t + a[j] >= 2*Math.abs(x[i] - x[j])) left = false;
				else if (x[j] > x[i] && a[i] + 2*t + a[j] > 2*Math.abs(x[i] - x[j])) right = false;
			if (left) ans++;
			if (right) ans++;
		}
		
		out.println(ans);
		
		out.flush();
	}
}
