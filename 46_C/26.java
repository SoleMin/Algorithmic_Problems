import java.io.*;
import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.fill;
import static java.util.Arrays.binarySearch;
import static java.util.Arrays.sort;

public class Main {
	public static void main(String[] args) throws IOException {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					try {
						if (new File("input.txt").exists())
							System.setIn(new FileInputStream("input.txt"));
					} catch (SecurityException e) {}
					new Main().run();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}, "1", 1L << 24).start(); 
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st = new StringTokenizer("");
	
	int N;
	int[] a;
	int[] b;
	int[] c;
	
	int T, H;
	
	void run() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		
		N = nextInt();
		char[] s = nextToken().toCharArray();
		a = new int [N];
		
		H = 0;
		T = 0;
		
		for (int i = 0; i < s.length; i++) {
			a[i] = s[i] == 'T' ? 1 : 0;
			if (s[i] == 'T')
				T++;
			else
				H++;
		}
		
		if (T == 1 || H == 1) {
			out.println(0);
			out.close();
			return;
		}
		
		b = Arrays.copyOf(a, a.length);
		c = Arrays.copyOf(a, a.length);
		sort(c);
		
		int ans = 100000000;
		for (int o = 0; o < N; o++) {
			for (int i = 0; i < N; i++)
				b[(i + o) % N] = a[i];
			int cur = 0;
			for (int i = 0; i < N; i++)
				if (b[i] != c[i])
					cur++;
			ans = min(ans, cur / 2);
		}
		
		out.println(ans);
		
		out.close();
	}
	
	String nextToken() throws IOException {
		while (!st.hasMoreTokens()) {
			st = new StringTokenizer(in.readLine());
		}
		
		return st.nextToken();
	}
	
	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}
	
	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}
	
	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}
	
	String nextLine() throws IOException {
		st = new StringTokenizer("");
		return in.readLine();
	}
	
	boolean EOF() throws IOException {
		while (!st.hasMoreTokens()) {
			String s = in.readLine();
			
			if (s == null) {
				return true;
			}
			
			st = new StringTokenizer(s);
		}
		
		return false;
	}
}
