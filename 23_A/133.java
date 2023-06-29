import java.io.BufferedReader;
import static java.lang.Math.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class CFC23A implements Runnable {
	BufferedReader in;
	PrintWriter out;
	StringTokenizer tok;

	public static void main(String[] args) {
		new Thread(new CFC23A()).start();
	}

	void solve() throws IOException {
		int res = 0;
		String str = nextToken();
		for(int i = 0; i < str.length(); ++i)
			for(int j = i + 1; j <= str.length(); ++j)
				if(isOk(str.substring(i, j), str))
					res = max(res, j - i);
		out.println(res);
	}

	private boolean isOk(String substring, String str) {
		int from = 0, kol = 0;
		while(str.indexOf(substring, from) != -1 && kol < 2) {
			++kol;
			from = str.indexOf(substring, from) + 1;
		}
		return kol >= 2;
	}

	@Override
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			// in = new BufferedReader(new FileReader(new File("input.txt")));
			out = new PrintWriter(System.out);
			//out = new PrintWriter(new File("output.txt"));
			solve();
			out.flush();
			out.close();
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	String nextLine() throws IOException {
		tok = null;
		return in.readLine();
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	String nextToken() throws IOException {
		while (tok == null || !tok.hasMoreTokens()) {
			tok = new StringTokenizer(in.readLine());
		}
		return tok.nextToken();
	}
}
