import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class A {
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = new StringTokenizer("");

	static String readString() throws Exception {
		while(!st.hasMoreTokens())
			st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}

	static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}

	static long readLong() throws Exception {
		return Long.parseLong(readString());
	}
	public static void main(String[] args) throws Exception{
		long a = readLong();
		long b = readLong();
		
		System.out.println(rec(a,b));

	}

	private static long rec(long a, long b) {
		if(a == 1){
			return b;
		}
		if(a >= b){
			return a/b + rec(a%b, b);
		}
		return rec(b, a);
	}

}
