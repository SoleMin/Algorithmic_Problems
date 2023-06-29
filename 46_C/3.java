import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	Scanner in;
	PrintWriter out;
	StreamTokenizer ST;
	BufferedReader br;

	int nextInt() throws IOException {
		ST.nextToken();
		return (int) ST.nval;
	}

	double nextDouble() throws IOException {
		ST.nextToken();
		return ST.nval;
	}

	String next() throws IOException {
		ST.nextToken();
		return ST.sval;
	}

	String nextLine() throws IOException {
		return br.readLine();
	}

	void solve() throws IOException {
		br.readLine();
		char[]s = br.readLine().toCharArray();
		int n = s.length;
		int h=0;
		for(int i=0;i<n;++i)if (s[i]=='H')++h;
		int res=1000000;
		for(int i=0;i<n;++i)
		{
			int t=0;
			for(int j=0;j<h;++j)
			{
				if (s[(i+j)%n]=='T')++t;
			}
			res=Math.min(res,t);
		}
		out.println(res);
	}

	public void run() throws IOException {
		// br = new BufferedReader(new FileReader(new File("input.txt")));
		br = new BufferedReader(new InputStreamReader(System.in));
		ST = new StreamTokenizer(br);
		in = new Scanner(br);
		out = new PrintWriter(System.out);
		// out = new PrintWriter(new FileWriter(new File("output.txt")));
		solve();
		in.close();
		out.close();
		br.close();
	}

	public static void main(String[] args) throws Exception {
		new Main().run();
	}

}
