import java.io.*;
import java.util.*;

public class C implements Runnable{
	public static void main (String[] args) {new Thread(null, new C(), "_cf", 1 << 28).start();}

	long MOD = (long)1e9+7;
	
	public void run() {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		System.err.println("Go!");

		long x = fs.nextLong();
		long k = fs.nextLong();
		if(x == 0) {
			System.out.println(0);
			return;
		}
		if(k == 0) {
			System.out.println(mult(x, 2));
			return;
		}
		
		long max = mult(x, power(2, k, MOD));
		long min = sub(max, power(2, k, MOD));
		long total = 0;
		if(min <= max) {
			total = sub(summ(max), summ(min));
		}
		else {
			total = summ(max);
			total = add(total, sub(summ(MOD-1), summ(min)));
		}
		total = mult(total, 2);
		total = div(total, power(2, k, MOD));
		out.println(total);
		out.close();
	}
	
	long summ(long x) {
		x *= x+1;
		x /= 2;
		x %= MOD;
		return x;
	}

	long add(long a, long b) {
		a %= MOD;
		b %= MOD;
		a += b;
		a %= MOD;
		return a;
	}
	
	long sub(long a, long b) {
		a %= MOD;
		b %= MOD;
		a -= b;
		while(a < 0) a += MOD;
		a %= MOD;
		return a;
	}
	
	long mult(long a, long b) {
		a %= MOD;
		b %= MOD;
		a *= b;
		a %= MOD;
		return a;
	}
	
	long div(long a, long b) {
		a %= MOD;
		b %= MOD;
		a *= inv(b);
		a %= MOD;
		return a;
	}
	
	long inv(long x) {
		long res = power(x, MOD-2, MOD);
		while(res < 0) res += MOD;
		res %= MOD;
		return res;
	}
	
	long power (long x, long y, long m) {
    	long res = 1;
    	x %= m;
    	while(y > 0) {
    		if(y % 2 == 1) {
    			res = (res * x) % m;
    		}
    		y >>= 1L;
    		x = (x * x) % m;
    	}
    	return res;
    }
	
	void sort (int[] a) {
		int n = a.length;
		for(int i = 0; i < 50; i++) {
			Random r = new Random();
			int x = r.nextInt(n), y = r.nextInt(n);
			int temp = a[x];
			a[x] = a[y];
			a[y] = temp;
		}
		Arrays.sort(a);
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