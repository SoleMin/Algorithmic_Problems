import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;


public class C364 {
	static HashMap<Character, Integer> freq;
	static int unique = 0;
	public static void main(String[] args) throws Exception {
		FastScanner in = new FastScanner();
		PrintWriter pw = new PrintWriter(System.out);
		
		int n = in.nextInt();
		char[] s = in.next().toCharArray();
		freq = new HashMap<Character, Integer>();
		for(int i = 0; i < n; i++) {
			char c = s[i];
			if(!freq.containsKey(c))
				freq.put(c, 0);
		}
		
		int k = freq.size();
		int l = 0, r = 0, best = n;
		inc(s[0]);
		
		while(r < n) {
			if(unique == k) { // got all, move left
				best = Math.min(best, r+1-l);
				dec(s[l++]);
			}
			else { // advance r
				if(++r == n)
					break;
				inc(s[r]);
			}
		}
		
		pw.println(best);
		
		pw.flush();
		pw.close();
	}
	
	static void inc(char c) {
		int cur = freq.get(c);
		if(cur == 0)
			unique++;
		freq.put(c, cur+1);
	}
	
	static void dec(char c) {
		int cur = freq.get(c);
		if(cur == 1)
			unique--;
		freq.put(c, cur-1);
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;
		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}
		
		String next() throws Exception {
			while(!st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		
		int nextInt() throws Exception {
			return Integer.parseInt(next());
		}
	}
}
