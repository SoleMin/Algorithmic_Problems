import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {		
		new TaskA().solve();
	}

}

class TaskA extends Base {	
	public static void solve () {
		long l = in.nextLong();
		long r = in.nextLong();		
		
		if (r - l < 2) {
			System.out.println(-1);
			return;
		}
		
		if (l % 2 == 0) {
			System.out.println(l + " " + (l + 1) + " " + (l + 2));
			return;
		}
		
		if (r - l > 2) {
			System.out.println((l + 1) + " " + (l + 2) + " " + (l + 3));
			return;
		}
		
		System.out.println(-1);		
	}
}

class Base {
	public static InputReader in = new InputReader(System.in);
}

class InputReader {
	BufferedReader reader;
	StringTokenizer tokenizer;
	
	public InputReader (InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream), 32768);
		tokenizer = null;
	}
	
	public String next() {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			try {
				tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {			
				e.printStackTrace();
			}
		}
		return tokenizer.nextToken();
	}
	
	public int nextInt() {
		return Integer.parseInt(next());
	}
	
	public long nextLong() {
		return Long.parseLong(next());
	}
}

