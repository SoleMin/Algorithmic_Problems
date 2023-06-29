import java.io.*;
import java.util.*;

public class A {

	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}

	int nextInt() throws Exception {
		return Integer.parseInt(next());
	}

	long nextLong() throws Exception {
		return Long.parseLong(next());
	}

	double nextDouble() throws Exception {
		return Double.parseDouble(next());
	}

	void solve() throws Exception {
		int n = nextInt(), k = nextInt(), s = nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = -nextInt();
		
		Arrays.sort(a);
		for(int i=0;i<n;i++)
		{
			if (s>=k)
			{
				out.println(i);
				return;
			}
			
			s += -a[i];
			s--;
		}
		if (s<k)
			out.println(-1);
		else
			out.println(n);
	}

	void run() {
		try {
			Locale.setDefault(Locale.US);
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(new OutputStreamWriter(System.out));
			solve();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		new A().run();
	}


}
