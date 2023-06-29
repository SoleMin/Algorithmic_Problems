import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;

public class A {
	private static StreamTokenizer in;
	private static PrintWriter out;

	private static int nextInt() throws Exception {
		in.nextToken();
		return (int) in.nval;
	}

	private static String nextString() throws Exception {
		in.nextToken();
		return in.sval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		out = new PrintWriter(System.out);
		
		ArrayList<Integer> p = new ArrayList<Integer>();
		ArrayList<Integer> o = new ArrayList<Integer>();
		
		int n = nextInt();
		for (int i=0; i<n; i++) {
			int a = nextInt();
			if (a % 2 == 0) p.add(i+1);
			else o.add(i+1);
		}
		
		if (p.size() < o.size()) out.println(p.get(0));
		else out.println(o.get(0));

		out.flush();

	}
}