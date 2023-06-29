import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	
	Scanner in;
	static PrintWriter out;
	
	static class Scanner {
		StreamTokenizer in;
		
		Scanner(InputStream is) {
			in = new StreamTokenizer(new BufferedReader(new InputStreamReader(is)));
			  in.resetSyntax();
		         in.whitespaceChars(0, 32);
		         in.wordChars(33, 255);
		     
		}
		
		int nextInt() {
			try {
				in.nextToken();
				return Integer.parseInt(in.sval);
			} catch (IOException e) {
				throw new Error();
			}
		}
		
		String next() {
			try {
				in.nextToken();
				return in.sval;
			} catch (IOException e) {
				throw new Error();
			}
		}
	}
	
	
	
	static class Value implements Comparable <Value> {
		int x;
		int pos;
		
		Value(int x, int pos) {
			this.x = x;
			this.pos = pos;
		}
		
		public int compareTo(Value second) {
			if (this.x == second.x) {
				return this.pos - second.pos;
			} else {
				return this.x - second.x;
			}
		}
	}
	
	void solve() {
		int n = in.nextInt();
		
		Value ar[] = new Value[n];

		for (int i = 0; i < n; i++) {
			ar[i] = new Value(in.nextInt(), i);
		}
		Arrays.sort(ar);
		int cnt = 0;
		//LinkedList <Integer> gavno = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			if (ar[i].pos != i && ar[ar[i].pos].x != ar[i].x) {
				cnt++;
				//gavno.add(i);
			}
		}
		if (cnt > 2) {
			out.println("NO");
		} else {
			out.println("YES");
		}
	}
	
	static void asserT(boolean e) {
		if (!e) {
			throw new Error();
		}
	}
	
	
	public void run() {
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
		
		try {
			solve();
		} finally {
			out.close();
		}
	}
	
	public static void main(String[] args) {
		new Main().run();
	}

} 