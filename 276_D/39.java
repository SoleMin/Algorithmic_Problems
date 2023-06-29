import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class D {
	
	static StringTokenizer st;
	static BufferedReader in;
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		long L = nextLong();
		long R = nextLong();
		if (L==R) {
			System.out.println(0);
			return;
		}
		String s1 = Long.toBinaryString(L), s2 = Long.toBinaryString(R);
		while (s1.length() != s2.length())
			s1 = "0"+s1;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				int pow = s1.length()-i;
				System.out.println((long)Math.pow(2, pow)-1);
				return;
			}
		}
		pw.close();
	}
	private static int nextInt() throws IOException{
		return Integer.parseInt(next());
	}
	
	private static long nextLong() throws IOException{
		return Long.parseLong(next());
	}
	
	private static double nextDouble() throws IOException{
		return Double.parseDouble(next());
	}
	
	private static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }
}
