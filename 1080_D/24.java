import java.io.*;
import java.util.*;

public class E implements Runnable {
	public static void main (String[] args) {new Thread(null, new E(), "_cf", 1 << 28).start();}
	
	long oo = (long)2e18;
	
	public void run() {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		System.err.println("Go!");

		int t = fs.nextInt();
		while(t-->0) {
			int n = fs.nextInt();
			long k = fs.nextLong();
			long toCut = 1, numSquares = 1, free = 0;
			int cuts = 0;
			while(true) {
				if(cuts >= n) {
					k = oo;
					break;
				}
				k -= toCut;
				if(k < 0) {
					k = oo;
					break;
				}
				cuts++;
				try {
					free = Math.addExact(free, Math.multiplyExact(numSquares, getVal(n-cuts)));
				} catch (Exception e) {
					k = 0;
					break;
				}
				if(free >= k) {
					k = 0;
					break;
				}
				toCut += (1L<<cuts);
				numSquares += (1L<<(cuts+1));
			}
			if(k == 0) {
				out.printf("YES %d\n", n-cuts);
			}
			else {
				out.printf("NO\n");
			}
		}
		
		out.close();
	}
	
	long getVal(int n) {
		if(n > 31) return oo;
		long last = 0, cur = 0;
		for(int i = 1; i <= n; i++) {
			cur = 1 + 4*last;
			last = cur;
		}
		return cur;
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

		public FastScanner(String s) throws FileNotFoundException {
			in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
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