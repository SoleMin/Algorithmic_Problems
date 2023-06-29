import java.io.*;
import java.util.StringTokenizer;

public class Contest200C {	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader in = new BufferedReader(new FileReader("200C.in"));
		StringTokenizer st = new StringTokenizer(in.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		System.out.println(min(a,b));
	}
	
	static long min(long a, long b) {
		if (a <= 0 || b <= 0) return 0;
		return a/b+min(b,a%b);
	}
}
