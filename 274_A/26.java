import java.io.*;
import java.util.*;
import java.util.Map.Entry;

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
		
		String readLine() {
			try {
				in.nextToken();
				asserT(in.ttype == StreamTokenizer.TT_WORD);
				return in.sval;
			} catch (IOException e) {
				throw new Error();
			}
		}
		
		int nextInt() {
			return Integer.parseInt(readLine());			
		}
	}
	
	
	
	void solve() {
		int n = in.nextInt();
		long k = in.nextInt();
		int ar[] = new int[n];
		TreeMap <Integer, Integer> nums = new TreeMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
			nums.put(ar[i], i);
		}
		
		if (k == 1) {
			out.println(n);
			return;
		}
		
		int next[] = new int[n];
		Arrays.fill(next, -1);
		
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			long val = ar[i] * k;
			int intVal = (int)val;
			if (intVal == val) {
				if (nums.containsKey(intVal)) {
					int idx = nums.get(intVal);
					next[i] = idx;
					continue;
				}
			}
			
			if (ar[i] % k == 0) {
				intVal = ar[i] / (int)k;
				
				if (nums.containsKey(intVal)) {
					continue;
				}
			}
			
			
			count++;
		}
		
		for (int i = 0; i < n; i++) {
			int curr = nums.pollFirstEntry().getValue();
			boolean odd = false;
			while (next[curr] != -1) {
				if (!odd) {
					count++;
				}
				int to = next[curr];
				next[curr] = -1;
				curr = to;
				odd = !odd;
				
				if (next[curr] == -1) {
					if (!odd) {
						count++;
					}
				}
			}
		}
		out.println(count);
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