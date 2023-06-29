import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class E implements Runnable {
	public static void main (String[] args) {new Thread(null, new E(), "_cf", 1 << 28).start();}

	int n, m;
	char[] str;
	int[][] occs, cost;
	int[] dp;
	
	public void run() {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		System.err.println("");

		n = fs.nextInt(); m = fs.nextInt();
		str = fs.next().toCharArray();
		occs = new int[m][m];
		for(int i = 0; i < n-1; i++) {
			occs[str[i]-'a'][str[i+1]-'a']++;
			occs[str[i+1]-'a'][str[i]-'a']++;
		}
		//cost[mask][v] = numPairs with v for some all bits on in mask
		int all = (1<<m)-1;
		cost = new int[m][1<<m];
		for(int i = 0; i < m; i++) {
			for(int mask = 1; mask < all; mask++) {
				if(((1<<i)&mask) > 0) continue;
				int lb = mask & (-mask);
				int trail = Integer.numberOfTrailingZeros(lb);
				int nmask = mask ^ lb;
				cost[i][mask] = cost[i][nmask]+occs[i][trail];
			}
		}
		
		dp = new int[1<<m];
		Arrays.fill(dp, -1);
		System.out.println(solve(0));
		
		out.close();
	}
	
	int oo = (int)1e9;
	int solve(int mask) {
		if(mask == (1<<m)-1) return 0;
		if(dp[mask] != -1) return dp[mask];
		int res = oo;
		
		int addOn = 0;
		for(int nxt = 0; nxt < m; nxt++) {
			if(((1<<nxt)&mask) > 0) continue;
			addOn += cost[nxt][mask];
		}
		for(int nxt = 0; nxt < m; nxt++) {
			if(((1<<nxt)&mask) > 0) continue;
			int ret = addOn+solve(mask | (1<<nxt));
			res = Math.min(res, ret);
		}
		
		return dp[mask] = res;
	}
	
	class FastScanner {
		public int BS = 1<<16;
		public char NC = (char)0;
		byte[] buf = new byte[BS];
		int bId = 0, size = 0;
		char c = NC;
		double num = 1;
		BufferedInputStream in;

		public FastScanner() {
			in = new BufferedInputStream(System.in, BS);
		}

		public FastScanner(String s) {
			try {
				in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
			}
			catch (Exception e) {
				in = new BufferedInputStream(System.in, BS);
			}
		}

		public char nextChar(){
			while(bId==size) {
				try {
					size = in.read(buf);
				}catch(Exception e) {
					return NC;
				}                
				if(size==-1)return NC;
				bId=0;
			}
			return (char)buf[bId++];
		}

		public int nextInt() {
			return (int)nextLong();
		}

		public long nextLong() {
			num=1;
			boolean neg = false;
			if(c==NC)c=nextChar();
			for(;(c<'0' || c>'9'); c = nextChar()) {
				if(c=='-')neg=true;
			}
			long res = 0;
			for(; c>='0' && c <='9'; c=nextChar()) {
				res = (res<<3)+(res<<1)+c-'0';
				num*=10;
			}
			return neg?-res:res;
		}

		public double nextDouble() {
			double cur = nextLong();
			return c!='.' ? cur:cur+nextLong()/num;
		}

		public String next() {
			StringBuilder res = new StringBuilder();
			while(c<=32)c=nextChar();
			while(c>32) {
				res.append(c);
				c=nextChar();
			}
			return res.toString();
		}

		public String nextLine() {
			StringBuilder res = new StringBuilder();
			while(c<=32)c=nextChar();
			while(c!='\n') {
				res.append(c);
				c=nextChar();
			}
			return res.toString();
		}

		public boolean hasNext() {
			if(c>32)return true;
			while(true) {
				c=nextChar();
				if(c==NC)return false;
				else if(c>32)return true;
			}
		}
		
		public int[] nextIntArray(int n) {
			int[] res = new int[n];
			for(int i = 0; i < n; i++) res[i] = nextInt();
			return res;
		}
		
	}

}