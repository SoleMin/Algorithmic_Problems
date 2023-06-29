import java.io.*;
import java.util.*;
import java.lang.reflect.Array;
import java.math.*;

public class Solution {
	private BufferedReader in;
	private PrintWriter out;
	private StringTokenizer st;
	private Random rnd;
	
	int[] levels;
	int[] loyal;
	int n, k;
	double A;
	
	int[] choices;
	int[] new_loyal;
	double[] koef;
	
	double ans = 0.0;
	int total;
	
	void rec(int step, int start) {
		if(step == k) {
			for(int i = 0; i < n; i++) {
				new_loyal[i] = loyal[i];
			}
			for(int i = 0; i < k; i++) {
				new_loyal[choices[i]] = Math.min(100, new_loyal[choices[i]] + 10);
			}
			
			int full = 0;
	
			for(int i = 0; i < n; i++) {
				if(new_loyal[i] == 100) {
					++full;
				}
			}
			
			if(full > (n / 2)) {
				ans = 1.0;
				return;
			}
			
			for(int i = 0; i < n; i++) {
				koef[i] = (double) new_loyal[i] / 100.0;
			}
			

			int bits_needed = (n / 2) + 1;
			
			double total_win = 0.0;
			double total_fights = 0.0;
			
			for(int mask = 0; mask < total; mask++) {
				int bits = 0;
				
				double win = 1.0;
				double loose = 1.0;
				double b = 0.0;
				
				for(int bit = 0; bit < n; bit++) {
					if((mask & (1 << bit)) != 0) {
						++bits;
						win *= koef[bit];
					} else {
						loose *= (1.0 - koef[bit]);
						b += levels[bit];
					}
				
				}
				
				double prob = win * loose;
				
				if(bits >= bits_needed) {
					total_win += prob;
				} else {
					total_fights += prob * (A / (A + b));
				}
			}

			
			ans = Math.max(ans, total_win + total_fights);

		} else {
			for(int i = start; i < n; i++) {
				choices[step] = i;
				rec(step + 1, i);
			}
		}
	}
	
	public void solve() throws IOException {
		n = nextInt();
		k = nextInt();
		A = nextInt();
		
		levels = new int[n];
		loyal = new int[n];
		new_loyal = new int[n];
		choices = new int[k];
		koef = new double[n];
		
		for(int i = 0; i < n; i++) {
			levels[i] = nextInt();
			loyal[i] = nextInt();
		}
		
		total = 1 << n;
		
		rec(0, 0);
		
		out.println(ans);
	}
		
	public static void main(String[] args) {
		new Solution().run();
	}
	
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			st = null;
			rnd = new Random();
			
			solve();
			
			out.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private String nextToken() throws IOException, NullPointerException {
		while(st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(in.readLine());
		}
		
		return st.nextToken();
	}
	
	private int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}
	
	private long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}
	
	private double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

}