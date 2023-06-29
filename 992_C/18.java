import java.util.*;
import java.io.*;

public class R489C {
	
	static long m = (long)(1e9+7);
	/*
	1000000000000000000
	 */

	public static void main(String[] args) {
		JS scan = new JS();
		long n = scan.nextLong();
		long k = scan.nextLong();
		if(n == 0) {
			System.out.println(0);
			return;
		}
		if(k == 0) {
			long ans = (n%m)*(2%m)%m;
			System.out.println(ans%m);
			return;
		}
		//System.out.println(2+" "+(k+1)+" "+m);
		long coeff = power(2L, k+1, m);
		//System.out.println(coeff);
		long r = (coeff%m)*(n%m)%m;
		//System.out.println(r);
		long x = power(2L, k, m)%m-1;
		if(x < 0) x += m;
		long ans = r-x;
		if(ans < 0) ans += m;
		System.out.println(ans%m);
	}
	
	static long power(long x, long y, long p){
        // Initialize result
		long res = 1;     
       
        // Update x if it is more  
        // than or equal to p
        x = x % p; 
    
        while (y > 0){
            // If y is odd, multiply x
            // with result
            if((y & 1)==1)
                res = (res%p * x%p) % p;
    
            // y must be even now
            // y = y / 2
            y = y >> 1; 
            x = (x%p * x%p) % p; 
        }
        return res;
    }
	
	/*
	1000000000000000000 1000000000000000000
	 */
	
	static class JS{
		public int BS = 1<<16;
		public char NC = (char)0;
		byte[] buf = new byte[BS];
		int bId = 0, size = 0;
		char c = NC;
		double num = 1;
		BufferedInputStream in;

		public JS() {
			in = new BufferedInputStream(System.in, BS);
		}

		public JS(String s) throws FileNotFoundException {
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
	}
}
