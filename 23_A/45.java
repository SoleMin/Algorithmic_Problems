import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

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
		in = new StreamTokenizer(new BufferedReader(new InputStreamReader(
				System.in)));
		out = new PrintWriter(System.out);

		String s = nextString();
		int max = 0;
		for (int i=0; i<s.length(); i++) {
			for (int j=i+1; j<=s.length(); j++) {
//				System.out.println(i+ " "+ j);
				String u = s.substring(i,j);
				if (s.substring(i+1).indexOf(u) >= 0) {
					max = Math.max(max, u.length());
				}
			}
		}
		out.println(max);
		
		out.flush();
	}
}